/*
 * 정수의 값을 입력받아서 양수이면 그대로 출력하고, 음수일 경우 양수로 전환 하시오.
 * */
package exam;

import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int number = scan.nextInt();
		
		if (number >= 0 ) {
			System.out.println(number);
		}else {
			System.out.println(number*-1);
		}
		
	}
}
