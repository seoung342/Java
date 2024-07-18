package java0718;

public class Ex01 {

	public static void main(String[] args) {
//		Phone phone = new Phone(); // 추상 클래스는 직접 객체 생성이 안된다.
		Phone phone = new SmartPhone();
		
		phone.turnOn();
	}

}
