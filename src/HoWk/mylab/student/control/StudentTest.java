package HoWk.mylab.student.control;

import HoWk.mylab.student.entity.Student;
import HoWk.mylab.student.exception.InvalidGradeException;

public class StudentTest {
	public static void main(String[] args) {
		
		try {	//필드: 학번(studentId), 이름(name), 전공(major), 학년(grade) → 모두 private
			
			Student account = new Student();
		
			// 김민수 / 컴퓨터공학 / 3학년
	
			account.setStudentId("221223477");
			account.setName("김민수");	
			account.setMajor("컴퓨터공학");
			account.setGrade(3);
			
			account.EditEl(3);
			
			System.out.println("학번 : " + account.getStudentId() );
			System.out.println("이름 : " + account.getName() );
			System.out.println("학과 : " + account.getMajor() );
			System.out.println("학년 : " + account.getMajor() );
			
			
			
			Student account2 = new Student("16172200", "홍길동", "정보보안", 1);
			
			System.out.println("학생 : " + account2.toString() );
			// getClass().getName() + '@' + Integer.toHexStrig(hashCode());
			// 출금
			account2.EditEl(6);
			System.out.println("학생 : " + account2.toString() );
			
			
		}catch(InvalidGradeException exp){
			System.out.println("Error 메시지=" + exp.getMessage());
		}
	}
}