package project3;

public class Member implements java.io.Serializable{
	String name;
	String ssn;   // 주민번호 6자리 패스워드
	String phone;
	int balance;
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", ssn=" + ssn + ", phone=" + phone +", balance="+balance+ "]";
	}

	public Member(String name, String ssn, String phone) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
	}
	
	public Member() {}
	
	
	
}