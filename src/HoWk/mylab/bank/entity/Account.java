package HoWk.mylab.bank.entity;

import HoWk.mylab.bank.exception.InsufficientBalanceException;

public class Account {
    protected String accountNumber;
    protected String ownerName;
    protected double balance;

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    // 입금 기능
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // 출금 기능
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("잔액이 부족합니다.");
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return "계좌번호: " + accountNumber + ", 소유자: " + ownerName + ", 잔액: " + balance + "원";
    }
}