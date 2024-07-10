package exam;

import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		Scanner scan = new Scanner(System.in);
		int num = 0;
		int sum = 0;		
		
		while(run) {
			System.out.println("-------------------------------");
			System.out.println(" 1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-------------------------------");
			System.out.print("선택 > ");
			num = scan.nextInt();
			switch(num) {
			case 1:
				System.out.print("예금액 > ");
				balance = scan.nextInt();
				sum += balance;
				break;
			case 2:
				System.out.print("출금액 > ");
				balance = scan.nextInt();
				sum -= balance;
				break;
			case 3:
				System.out.printf("잔고 > %d\n", sum);
				break;
			case 4:
				run = false;				
			}
		}
		System.out.println("프로그램 종료");
		
	}
}
