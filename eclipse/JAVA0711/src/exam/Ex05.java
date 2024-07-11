/*
 * +,- 기호를 번갈아 출력하는 프로그램을 작성하세요.
 * */
package exam;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		
		int n;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("홀수는 +, 짝수는 - 기호를 번갈아 출력하는 프로그램");
		
		do {
			System.out.print("n > ");
			n = scan.nextInt();
		}while(n <=0 );
		
		for (int i = 1; i <=n; i++) {
			if(i % 2 == 0) {
				System.out.print("-");
			}else {
				System.out.print("+");
			}
		}

	}

}
