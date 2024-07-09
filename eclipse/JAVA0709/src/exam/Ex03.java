/**
 *  두개의 값을 받아서 큰 수를 출력하세요.(단, 같으면 0으로 출력)
 */
package exam;

import java.util.Scanner;

public class Ex03 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int a = getNumber("첫번째 숫자를 입력하세요 : ", scan);
		int b = getNumber("두번째 숫자를 입력하세요 : ", scan);
		int number = ( a > b ) ? a : ( a == b ) ? 0 : b;
		
		if( number == 0 ) {
			System.out.println("두 숫자는 같습니다.");
		}
		else {
			System.out.printf("두 숫자중 큰 수는 %d입니다.", number);
		}

	}

	public static int getNumber(String msg, Scanner sc) {
		System.out.print(msg);
		int input = sc.nextInt();
		return input;
	}
}
