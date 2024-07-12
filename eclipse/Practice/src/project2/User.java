package project2;

public class User {
	String myId; // 아이디
	String myPass; // 비밀번호
	int myMoney = 0; // 잔고
	String Name; // 이름
	String Personal; // 주민번호
	String Phone; // 전화 번호
	
	User(){ // 생성자
	}
	
	public void setId(String id) {
		this.myId = id;
	}
	
	public String getId() {
		return myId;
	}
	
	public void setPass(String pass) {
		this.myPass = pass;
	}
	
	public String getPass() {
		return myPass;
	}
	
	public void setAddMoney(int money) {
		this.myMoney += money;
	}
	
	public void setSubMoney(int money) {
		this.myMoney -= money;
	}
	
	public int getMoney() {
		return myMoney;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setPersonal(String personal) {
		this.Personal = personal;
	}
	
	public String getPersonal() {
		return Personal;
	}
	
	public void setPhone(String phone) {
		this.Phone = phone;
	}
	public String getPhone() {
		return Phone;
	}
	
	public void getInfo() {
		System.out.print("\n [내 정보] \n 1. 이름 : "+Name+"\n 2. 주민번호 앞 6자리 : "+Personal
		+"\n 3. 전화번호 : "+Phone+"\n 4. 아이디 : "+myId+"\n 5. 비밀번호 : "+myPass+"\n 6. 잔고 : " + myMoney+"\n");
	}
	
	
}
