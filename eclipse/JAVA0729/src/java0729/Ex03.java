package java0729;

public class Ex03 {

	public static void main(String[] args) {
		int x = 100;
		Integer y;
		Integer z = 400;
		y = 100;
		
		x = Integer.valueOf("400");
		y = Integer.valueOf("400");
		if ( y.equals(z)) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}

	}

}
