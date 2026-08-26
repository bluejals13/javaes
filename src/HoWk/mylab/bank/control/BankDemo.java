package HoWk.mylab.bank.control;

import HoWk.mylab.bank.entity.CheckingAccount;
import HoWk.mylab.bank.entity.SavingsAccount;

public class BankDemo {
    public static void main(String[] args) {
        // 은행 객체 생성
        Bank bank = new Bank();

        System.out.println("=== 계좌 생성 ===");
        bank.addAccount(new SavingsAccount("AC1000", "홍길동", 10000.0, 3.0), "Saving(저축)");
        bank.addAccount(new CheckingAccount("AC1001", "김철수", 20000.0, 5000.0), "체킹");
        bank.addAccount(new SavingsAccount("AC1002", "이영희", 30000.0, 2.0), "저축");

        System.out.println("\n=== 모든 계좌 목록 ===");
        bank.printAllAccounts();
        System.out.println("===================");

        System.out.println("\n=== 입금/출금 테스트 ===");
        // 홍길동(AC1000) 계좌에 5000원 입금
        bank.deposit("AC1000", 5000.0);
        // 김철수(AC1001) 계좌에서 3000원 출금
        bank.withdraw("AC1001", 3000.0);
        
        /* 
        // 예외 처리  테스트 시 아래 주석을 풀고 실행.
        System.out.println("\n=== 예외 처리 테스트 ===");
        bank.withdraw("AC1001", 6000.0); // 출금 한도(5000) 초과
        bank.withdraw("AC1002", 50000.0); // 잔액 부족
        bank.deposit("AC9999", 1000.0); // 없는 계좌 
        */
    }
}