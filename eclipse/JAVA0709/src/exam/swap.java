package exam;

public class swap {

	public static void main(String[] args) {
		
		int x = 10;
		int y = 20;
		
		System.out.printf("x : %d, y : %d\n", x, y);
		
		swap(x, y);
	}
	
	public static void swap(int a, int b) {
		
		int tmp = a;
		a = b;
		b = tmp;
		
		System.out.printf("x : %d, y : %d", a, b);
	}

}
