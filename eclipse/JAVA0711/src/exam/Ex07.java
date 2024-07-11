/*
 * 2자리 양수를 입력받는 프로그램을 작성하세요.
 * */
package exam;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n; 
		do {
			System.out.print("n > ");
			n = scan.nextInt();
		}while( n<=9 || n >= 100);
		
		System.out.println("변수 n값은 "+n+"입니다.");
		
		
	}
}
