/*
 * 1부터 n까지의 합과 그 값을 구하는 과정을 출력하는 프로그램을 작성하세요.
 * */
package exam;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n;
		int result = 0;
		
		System.out.println("1부터 n까지의 합을 구합니다.");
		do {
			System.out.print("n > ");
			n = scan.nextInt();
		}while(n <=0);
		
		for (int i = 1; i <= n; i++) {
			System.out.print(i);
			
			if ( i < n ) {
				System.out.print("+");
			}else {
				System.out.print("=");
			}
			
			result += i;
		}
		System.out.print(result);
	}

}
