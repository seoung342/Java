package work;

public class User {
	String myId; // 아이디
	String myPass; // 비밀번호
	int myMoney = 0; // 잔고
	
	User(){
		
	}
	
	User(String id, String pass, int money){
		myId = id;
		myPass = pass;	
		myMoney = money;
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
	
}
