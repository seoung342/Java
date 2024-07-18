package exam02;

public class Main {
	public static void main(String[] args) {
		Person p = new Person();
		Driver driver = new Driver();
		Worker worker = new Worker();
		
		p.setRole(worker);
		p.doIt();
		
	}
}
