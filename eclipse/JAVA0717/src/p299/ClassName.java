package p299;

public class ClassName {
	// 인스턴스 필드와 메소드
	int field1;
	void method1() {
		field2 = 200;
	}
	// 정적 필드와 메소드
	static int field2;
	static void method2() {}
	
	// 정적 메소드
	static void method3() {
//		this.field1 = 10;	// ( x ) 오류
//		this.method1();	//( x ) 오류
		field2 = 10;	// ( o )
		method2();	//( o )
	}
	
	public static void main(String[] args) {
//		method1(); 오류
		ClassName.method2();
		System.out.println(ClassName.field2);
		ClassName c1 = new ClassName();
		c1.method1();
		System.out.println(c1.field2);
		System.out.println();
		method3();
	}

}
