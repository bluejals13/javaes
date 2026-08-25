package HoWk.mylab.student.entity;

import HoWk.mylab.student.exception.InvalidGradeException;

public class Student {
	private String studentId;
	private String name;
	private String major;
	private int grade;

	//필드: 학번(studentId), 이름(name), 전공(major), 학년(grade) → 모두 private
	// default constructor 선언
	public Student() {
		System.out.println("Student 기본 학생 정보 호출");
	}
	
	// 생성자 중복 정의 (constructor overloading)
	public Student( String studentId, String name, String major, int grade) {
		
		this.studentId = studentId;
		this.name = name;
		this.major = major;
		this.grade = grade;
		
	}

	//getter method
	public String getStudentId() {
		return studentId;
	}
	//setter
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public int setGrade(int grade) {
		return grade;
	}
	
	//입금
	public void EditEl(int amount) 
		throws InvalidGradeException{
			if ( (amount > 4 )&&((amount < 1 ))) {
				//Exception을 발생시킨다
				throw new InvalidGradeException("학년은 1 ~ 4 사이 값으로 만 가능합니다", this.grade);
			}
			this.grade = amount;
		}
	
	//Method Overriding
	@Override
	public String toString() {
		return "Student [학번=" + studentId + ", "
				+ "이름=" + name + ", "
				+ "학과=" + major + ", "
				+ "잔액=" + grade + "]";
				
	}
	
}