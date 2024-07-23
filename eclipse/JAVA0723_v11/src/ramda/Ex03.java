package ramda;

public class Ex03 {
	public static void main(String[] args) {
		MyInterf2 myInterf2 = (a)->{
			System.out.println(a);
		};
		
		myInterf2.method(100);
	}
}
