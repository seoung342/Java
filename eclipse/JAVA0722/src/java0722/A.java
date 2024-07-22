package java0722;

public class A {
	class B{
		B(){}
		int field1;
		static int field2;
		void  method01() {}
		static void method02() {}
	}
	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B();
		b.method01();
		
	}
}
