package anony;

public class Anony {
	// 메소드
	void method() {
		Person2 pserson2 = new Person2() {
			
			@Override
			public void wake2() {
				// TODO Auto-generated method stub
				
			}
		};
		
		Person person = new Person() {

			@Override
			void wake() {
				// TODO Auto-generated method stub
				super.wake();
			}
			
		};
	}
}
