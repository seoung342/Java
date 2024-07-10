package exam;

public class BitAnd {
	public static void main(String[] args) {
		int a = 10;
		int b = -10;
		System.out.printf("[%32s] %d\n", Integer.toBinaryString(a), a);
		System.out.printf("[%32s] %d\n", Integer.toBinaryString(b), b);
		System.out.printf("[%32s] %d\n", Integer.toBinaryString(a&b), a&b);
	}
}
