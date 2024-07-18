package java0718;

public abstract class Phone {
	String name;
	
	void turnOn() {
		System.out.println("퐅 켜기");
	}
	
	abstract void tunrOff(); // 추상 메소드
}
