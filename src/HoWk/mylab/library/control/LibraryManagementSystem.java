package HoWk.mylab.library.control;

import HoWk.mylab.library.entity.Library;
import HoWk.mylab.library.entity.Book;

import java.util.List; 		// Prd 사항 준수를 위한 list 반환용 사용

public class LibraryManagementSystem {
	public static void main(String[] args) {
		
		// 테스트 시도 결과를 기록할 boolean 배열 (최대 10개 기록 가능)
        boolean[] f1 = new boolean[10];
        int testCount = 0; // 테스트 실행 횟수 카운터
        
        Library library = new Library("황인찬");
        
        System.out.println("====== 1. 도서 추가 ======");
        addSampleBooks(library);
        System.out.println("총 도서 수: " + library.getTotalBooks() + "권\n");

        System.out.println("====== 2. 중앙 도서관 ======");
        System.out.println("전체 도서 수: " + library.getTotalBooks() + "권");
        System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount() + "권");
        System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount() + "권\n");

        System.out.println("====== 3. 도서 검색 테스트 ======");
        Book bookByTitle = library.findByTitle("클린 코드");
        System.out.println("[제목 검색 결과] " + (bookByTitle != null ? bookByTitle : "없음"));

        System.out.println("[저자 '남궁성' 검색 결과]");
        List<Book> booksByAuthor = library.findByAuthor("남궁성");
        System.out.println(booksByAuthor + "\n");

        System.out.println("====== 4. 도서 대출 및 반납 테스트 ======");
        String targetIsbn = "978-89-01-14077-4"; // 자바의 정석 ISBN

        // 4-1. 대출 시도 일반
        System.out.println("------ 4-1. 대출 시도 일반 ------");
        boolean isCheckedOut = library.checkOutBook(targetIsbn);
        f1[testCount++] = isCheckedOut; // 결과 기록 (0번 인덱스)
        System.out.println("자바의 정석 대출 결과: " + (isCheckedOut ? "성공" : "실패"));

        // 4-2. 중복 대출 시도
        System.out.println("------ 4-2. 이미 대출된 도서에 대한 중복 대출 시도 ------");
        boolean isCheckedOutAgain = library.checkOutBook(targetIsbn);
        f1[testCount++] = isCheckedOutAgain; // 결과 기록 (1번 인덱스)
        System.out.println("자바의 정석 재대출 시도 결과: " + (isCheckedOutAgain ? "성공" : "실패(이미 대출중)"));

        // 4-3. 반납 시도 일반
        System.out.println("------ 4-3. 반납 시도 일반 ------");
        boolean isReturned = library.returnBook(targetIsbn);
        f1[testCount++] = isReturned; // 결과 기록 (2번 인덱스)
        System.out.println("자바의 정석 반납 결과: " + (isReturned ? "성공" : "실패"));

        // 4-4. 중복 반납 시도
        System.out.println("------ 4-4. 이미 반납된 도서에 대한 중복 반납 시도 ------");
        boolean isReturned2 = library.returnBook(targetIsbn);
        f1[testCount++] = isReturned2; // 결과 기록 (3번 인덱스)
        System.out.println("자바의 정석 반납 결과: " + (isReturned2 ? "성공" : "실패") + "\n");

        System.out.println("====== 5. 대출 가능 도서 목록 ======");
        System.out.println(library.getAvailableBooks() + "\n");
        
        // f1 배열을 순회하여 테스트 결과 총합 집계
        int successCount = 0;
        int failCount = 0;
        for (int i = 0; i < testCount; i++) {
            if (f1[i]) {
                successCount++;
            } else {
                failCount++;
            }
        }
        
        System.out.println("====== 6. 결과표 ======");
        System.out.println("테스트 시도 총 횟수: " + testCount + "회");
        System.out.println("테스트 성공 건수: " + successCount + "건");
        System.out.println("테스트 실패 건수: " + failCount + "건");
	
	}
	private static void addSampleBooks(Library library) {
        library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
	}

}