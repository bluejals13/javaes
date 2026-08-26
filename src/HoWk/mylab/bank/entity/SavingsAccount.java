package HoWk.mylab.bank.entity;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return super.toString() + ", 이자율: " + interestRate + "%";
    }
}