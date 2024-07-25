package java0725;

class Parent{
	int x;
	void method() {
		System.out.println(x);
	}
}

public interface Ex01 {
	public static void main(String[] args) {
		Parent parent = new Parent() {
			
			void method2() {
				System.out.println("오직 나만 사용");
			}
			
			@Override
			void method() {
				System.out.println("나는 익명 자식 객체~!~!");
				super.method();
			}
			
		};
		parent.method();
		
		
		
	}
}
