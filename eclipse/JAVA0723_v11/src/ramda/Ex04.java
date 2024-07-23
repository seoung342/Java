package ramda;

public class Ex04 {
	public static void main(String[] args) {
		MyInterf3 myInterf3 = (a, b)->{
			System.out.println(a+", "+b);
		};
		
		myInterf3.method(100, 200);
	}
}
