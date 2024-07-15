package project1_2;

import java.io.Serializable;

public class Member implements Serializable {

	private String name;
	private String ssn;   // 주민번호 6자리 패스워드
	private String phone;
	private int balance;

	@Override
	public String toString() {
		return "Member [name=" + name + ", ssn=" + ssn + ", phone=" + phone + ", balance=" + balance + "]";
	}

	public Member(String name, String ssn, String phone) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
	}
	
	public Member() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int AddBalance(int n) {
		this.balance += n;
		return this.balance;
	}
	
	public int SubBalance(int n) {
		this.balance -= n;
		return this.balance;
	}	
}