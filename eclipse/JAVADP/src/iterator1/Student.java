package iterator1;

public class Student {
	private String name;
	private String hakbun;
	private int java;
	
	public Student(String name, String hakbun, int java) {
		this.name = name;
		this.hakbun = hakbun;
		this.java = java;
	}

	public String getName() {
		return name;
	}

	public String getHakbun() {
		return hakbun;
	}

	public int getJava() {
		return java;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", hakbun=" + hakbun + ", java=" + java + "]";
	}
	
	

}
