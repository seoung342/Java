package exam02;

public class Main {
	public static void main(String[] args) {
		Driver driver = new Driver();
		Role role = driver;
		role.doIt();
		
		role = new Worker();
		if (role instanceof Worker) {
			Worker worker = (Worker) role;
		}
		Person p = new Person();
		p.setRole(new Driver());
		p.doIt();
		p.setRole(new Worker());
		p.doIt();
	}
}
