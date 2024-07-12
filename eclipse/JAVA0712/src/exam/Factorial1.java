package exam;

public class Factorial1 {

	public static void main(String[] args) {

		int num =4;
		int result = fac(num);
		System.out.println(result);

		int result2 = fac2(num);
		System.out.println(result2);
	}
	
	public static int fac(int n) {
		int res = 1;
		for (int i = 1; i <= n; i++) {
			res *= i;
		}
		return res;
	}
	
	public static int fac2(int n) { // 재귀 호출
		if(n==0) {
			return 0;
		}else {
			return n * fac(n-1);
		}
	}

}
