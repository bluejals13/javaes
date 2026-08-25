package workshop.account.exception;

public class InsufficientBalanceException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8591536659310984313L;
	// 현재 잔액
	private int currentBalance;
	
	public InsufficientBalanceException(String errorMessage, int currentBalance) {
		super(errorMessage);
		this.currentBalance = currentBalance;
	}
	
	public int getCurrentBalance() {
		return currentBalance;
	}
}