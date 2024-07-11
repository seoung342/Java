/*
 * 정수 a, b를 포함하여 그 사이의 모든 정수의 합을 구하여 반환하는 메서드를 작성하세요.
 * */
package exam;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int x, y, z;
	
		System.out.print("x > ");
		x = scan.nextInt();
		System.out.print("y > ");
		y = scan.nextInt();
	
		z = sumOf(x, y);
		System.out.println("정수 a, b 사이의 모든 정수의 총합은 " + z + "입니다.");
		
	}
	
	public static int sumOf(int a, int b) {
		
		int result = 0;
		
		if( a >= b ) {
			for (int i = b; i <= a; i++) {
				result += i;
			}
		}else {
			for (int i = a; i <= b; i++) {
				result += i;
			}
		}
		
		return result;
	}

}
