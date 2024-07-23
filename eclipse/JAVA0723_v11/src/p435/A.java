package p435;

public class A {
	int field1;
	void method1() {}
	
	static int field2;
	static void method2() {}
	
	static class B{
		void method() {
//			field1 = 10;
//			method1();
			
			field2 = 10;
			method2();
		}
	}
	
	public static void main(String[] args) {
		A.B b = new A.B();
		b.method();
	}
}
