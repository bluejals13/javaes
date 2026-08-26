package HoWk.mylab.bank.exception;

// 잔액이 부족하거나 출금 한도를 초과했을 때 발생하는 예외
public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}