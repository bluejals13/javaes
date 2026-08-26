package HoWk.mylab.bank.entity;

import HoWk.mylab.bank.exception.InsufficientBalanceException;

public class CheckingAccount extends Account {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
        super(accountNumber, ownerName, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    // 오버라이딩: 출금 한도 초과 여부 추가 확인
    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > withdrawalLimit) {
            throw new InsufficientBalanceException("출금 한도(" + withdrawalLimit + "원)를 초과했습니다.");
        }
        super.withdraw(amount); // 부모 클래스의 출금(잔액 확인) 로직 호출
    }

    @Override
    public String toString() {
        return super.toString() + ", 출금 한도: " + withdrawalLimit + "원";
    }
}