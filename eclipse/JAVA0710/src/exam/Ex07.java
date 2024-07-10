/*
 * 원하는 구구단 출력
 * */

package exam;

import java.util.Scanner;

public class Ex07 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num = 0;
		
		System.out.print("숫자를 입력하세요 : ");
		num = scan.nextInt();		
		
		for (int x = 1 ; x <= 9; x++) {
			System.out.printf(" %d * %d = %d\n", num, x, num*x);
		}
	}

}
