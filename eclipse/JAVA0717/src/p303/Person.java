package p303;

public class Person {
	final String nation = "Korea";
	static final double PI =3.141592;
	final String ssn;
	String name;
	
	public Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
	
	public static void main(String[] args) {
		Person p1 = new Person("12356-1234567","홍길동");
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
	}
}
