/* 
 * 3개의 정수값을 받아서 최대값을 구하여 출력하여 보세요.
 **/
package exam;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int num1 = getNumber("첫 번째 숫자 : ", scan);
		int num2 = getNumber("두 번째 숫자 : ", scan);
		int num3 = getNumber("세 번째 숫자 : ", scan);
		int result = maxNum(num1, num2, num3);
		
		System.out.println(result);		
	}
	
	public static int getNumber(String msg, Scanner sc) {
		System.out.print(msg);
		String input = sc.nextLine();
		return Integer.parseInt(input);
	}
	
	public static int maxNum(int x, int y, int z) {
		if ( x > y ) {
			if ( x > z ) {
				return x;
			}
			else {
				return z;
			}
		}
		else if ( x < y) {
			if( y > z ) {
				return y;
			}
			else {
				return z;
			}
		}
		else {
			return z;
		}
	}

}
