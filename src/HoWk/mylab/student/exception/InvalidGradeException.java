package HoWk.mylab.student.exception;

public class InvalidGradeException extends Exception{
	/**
	 * 
	 */
	// 현재 잔액
	private int currentGrade;
	
	public InvalidGradeException(String errorMessage, int currentGrade) {
		super(errorMessage);
		this.currentGrade = currentGrade;
	}
	
	public int getCurrentGrade() {
		return currentGrade;
	}
}