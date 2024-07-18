package java0718;

public class ChildExample {

	public static void main(String[] args) {
		Parent parent = new Child();
		Child child = (Child) parent;
		
//		if(parent instanceof Child) {
//			System.out.println("타입 변환 가능");
//			 // 강제 형변환
//			Child child1 = (Child) parent;
//		}else {
//			System.out.println("타입 변환 불가능");
//		}
		
		parent.field1 = "data1";
		child.method1();
		child.method2();
		child.method3();
		
	}

}
