/*
 * for 문으로 1부터 n까지의 합 구하기
 * */
package exam;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {

		int i, n;
		int result = 0;
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.print("n > ");
			n = scan.nextInt();
		}while(n <= 0);		
		
		for(i = 0; i <= n; i++) {
			result += i;
		}

		System.out.println("1부터" +n+"까지의 합은" +result+"입니다.");
	}

}
