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
		
		if ( num1 > num2 ) {
			if ( num1 > num3 ) {
				System.out.printf("최대값 : %d", num1);
			}
			else {
				System.out.printf("최대값 : %d", num3);
			}
		}
		else if ( num1 < num2) {
			if( num2 > num3 ) {
				System.out.printf("최대값 : %d", num2);
			}
			else {
				System.out.printf("최대값 : %d", num3);
			}
		}
		else {
			System.out.printf("최대값 : %d", num3);
		}
		
	}
	
	public static int getNumber(String msg, Scanner sc) {
		System.out.print(msg);
		String input = sc.nextLine();
		return Integer.parseInt(input);
	}

}
