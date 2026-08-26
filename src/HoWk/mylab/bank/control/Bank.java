package HoWk.mylab.bank.control;

import HoWk.mylab.bank.entity.Account;
import HoWk.mylab.bank.exception.AccountNotFoundException;
import HoWk.mylab.bank.exception.InsufficientBalanceException;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    // Bank가 Account 생명주기를 관리 (합성 관계)
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    // 계좌 생성 및 추가
    public void addAccount(Account account, String typeName) {
        accounts.add(account);
        System.out.println(typeName + " 계좌가 생성되었습니다: " + account.toString());
    }

    // 계좌 검색
    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        throw new AccountNotFoundException("오류: 존재하지 않는 계좌입니다. (" + accountNumber + ")");
    }

    // 입금 처리
    public void deposit(String accountNumber, double amount) {
        try {
            Account acc = findAccount(accountNumber);
            acc.deposit(amount);
            System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + acc.getBalance() + "원");
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // 출금 처리 (try-catch로 예외 처리)
    public void withdraw(String accountNumber, double amount) {
        try {
            Account acc = findAccount(accountNumber);
            acc.withdraw(amount);
            System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + acc.getBalance() + "원");
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    // 송금 기능
    public void transfer(String fromAccount, String toAccount, double amount) {
        try {
            Account from = findAccount(fromAccount);
            Account to = findAccount(toAccount);
            
            from.withdraw(amount);
            to.deposit(amount);
            System.out.println(amount + "원이 " + fromAccount + "에서 " + toAccount + "로 송금되었습니다.");
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("송금 실패: " + e.getMessage());
        }
    }

    // 모든 계좌 출력
    public void printAllAccounts() {
        for (Account acc : accounts) {
            System.out.println(acc.toString());
        }
    }
}