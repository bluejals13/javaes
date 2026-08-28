package HoWk.mylab.book.control;

import HoWk.mylab.book.entity.Magazine;
import HoWk.mylab.book.entity.Novel;
import HoWk.mylab.book.entity.Publication;
import HoWk.mylab.book.entity.ReferenceBook;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StatisticsAnalyzer {

    // 출판물 타입 확인 헬퍼 메서드
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "소설";
        if (pub instanceof ReferenceBook) return "참고서";
        if (pub instanceof Magazine) return "잡지";
        return "기타";
    }

    // 타입별 평균 가격 계산 메서드
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> sumMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            sumMap.put(type, sumMap.getOrDefault(type, 0) + pub.getPrice());
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        // 출력을 위해 순서를 보장하는 LinkedHashMap 사용
        Map<String, Double> avgMap = new LinkedHashMap<>();
        avgMap.put("소설", (double) sumMap.getOrDefault("소설", 0) / countMap.getOrDefault("소설", 1));
        avgMap.put("참고서", (double) sumMap.getOrDefault("참고서", 0) / countMap.getOrDefault("참고서", 1));
        avgMap.put("잡지", (double) sumMap.getOrDefault("잡지", 0) / countMap.getOrDefault("잡지", 1));
        
        return avgMap;
    }

    // 출판물 유형 분포 계산 메서드
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> countMap = new HashMap<>();
        int total = publications.length;

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distributionMap = new LinkedHashMap<>();
        distributionMap.put("소설", (double) countMap.getOrDefault("소설", 0) / total * 100);
        distributionMap.put("참고서", (double) countMap.getOrDefault("참고서", 0) / total * 100);
        distributionMap.put("잡지", (double) countMap.getOrDefault("잡지", 0) / total * 100);
        
        return distributionMap;
    }

    // 특정 연도 출판물 비율 계산 메서드
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            // 출판일자가 "yyyy-mm-dd" 형식이라고 가정하고 앞 4자리 비교
            if (pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        return (double) count / publications.length * 100;
    }

    // 통계 정보 출력 메서드
    public void printStatistics(Publication[] publications) {
        DecimalFormat dfMoney = new DecimalFormat("#,###"); // 금액 포맷
        DecimalFormat dfRatio = new DecimalFormat("#,##0.00"); // 백분율 포맷

        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        for (Map.Entry<String, Double> entry : avgPrices.entrySet()) {
            System.out.println("   - " + entry.getKey() + ": " + dfMoney.format(entry.getValue()) + "원");
        }

        System.out.println("\n2. 출판물 유형 분포:");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        for (Map.Entry<String, Double> entry : distribution.entrySet()) {
            System.out.println("   - " + entry.getKey() + ": " + dfRatio.format(entry.getValue()) + "%");
        }

        String targetYear = "2007";
        double yearRatio = calculatePublicationRatioByYear(publications, targetYear);
        System.out.println("\n3. " + targetYear + "년에 출판된 출판물 비율: " + dfRatio.format(yearRatio) + "%");
    }
}