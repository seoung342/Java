package exam;

public class Ex06 {

	public static void method(Object object) {
		switch(object) {
			case Integer i -> System.out.println(i);
			case String s -> System.out.println("문자열" + s);
			case null, default -> System.out.println("모른다");
		}
	}
	public static void main(String[] args) {
		method(100);
		method(5.77);
		method("Hello");

	}

}
