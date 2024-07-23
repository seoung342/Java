package ramda;

public class Ex05 {
	public static void main(String[] args) {
		MyInterf4 myInterf4 = (t,y)->{
			return t+y;
		};
		
		int x = myInterf4.method(100, 200);
		System.out.println(x);
	}
}
