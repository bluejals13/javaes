package HoWk.mylab.bank.exception;

// 계좌가 존재하지 않을 때 발생하는 예외
public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}