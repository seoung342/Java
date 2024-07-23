package ramda;

public class Ex02 {
	public static void main(String[] args) {
		
		// ramda 형식 ()->{}
		MyInterf1 myInterf1 = ()->{
			System.out.println("method()");
		};
		
//		MyInterf1 myInterf1 = new MyInterf1() {
//			@Override
//			public void method() {
//				System.out.println("method()");
//				
//			}
//		};

		myInterf1.method();
	}
}
