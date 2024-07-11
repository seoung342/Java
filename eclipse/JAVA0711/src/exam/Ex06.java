/*
 * *를 n개 출력하되 w개마다 줄을 바꿔서 출력하는 프로그램을 작성하세요.
 * */
package exam;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {

		int n, w;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*를 n개 출력하되 w개마다 줄을 바꿔서 출력하는 프로그램을 작성하세요.");
		
		do {
		System.out.print("n > ");
		n = scan.nextInt();
		System.out.print("w > ");
		w = scan.nextInt();
		}while( n <= 0 || w <= 0 || n <= w);
		
		for ( int i = 1; i <= n; i++) {
			System.out.print("*");
			if(i % w == 0) {
				System.out.println();
			}
		}
	}

}
