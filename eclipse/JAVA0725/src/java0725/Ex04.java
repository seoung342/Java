package java0725;

public class Ex04 {
	
	public static void method() throws ClassNotFoundException {
		
		Class.forName("asd");
	}

	public static void main(String[] args) {
		try {
			method();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
