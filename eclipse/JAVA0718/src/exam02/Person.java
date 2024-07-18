package exam02;

public class Person {
	private Role role;
	
	public void doIt() {
		role.doIt();
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
