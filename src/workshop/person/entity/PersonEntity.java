package workshop.person.entity;

// import workshop.person.*;

public class PersonEntity {
	private String name;
	private char gender;

	private String ssn;	
	private String address;
	private String phone;
	
	
	// default constructor 선언
	public PersonEntity() {
		System.out.println("PersonEntity 기본 생성자 호출");
	}


	public PersonEntity(String name, String ssn, String address, String phone) {
		setName(name);
		setSsn(ssn);
		setAddress(address);
		setPhone(phone);
	}

	// 단순  Getter Setter
	public String getName() { return name;	}
	public void setName(String name) { this.name = name;	}
	public char getGender() { return gender;	}
	public void setGender(char gender) { this.gender = gender; }
	public void setSsn(String ssn) {
		this.ssn = ssn;
		//0508071345897
		char genderNum = ssn.charAt(6);
		if(genderNum == '1' || genderNum == '3') {
			setGender('남');
		}else {  //2,4
			setGender('여');
		}
	}
	public void getSsn(String ssn) { this.ssn = ssn; }
	public String getAddress() { return address;	}
	public void setAddress(String address) { this.address = address;	}
	public String getPhone() {return phone;	}
	public void setPhone(String phone) { this.phone = phone;	}
	

	
}