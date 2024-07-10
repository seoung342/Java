package exam;

import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		int balance = 0; // 입, 출금액
		int num = 0; // 선택 메뉴
		int sum = 0; // 잔고
				
		while(run) {
			System.out.println("-------------------------------------------------");
			System.out.println(" 1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-------------------------------------------------");
			System.out.print("선택 > ");
			num = Integer.parseInt(scan.nextLine());
			switch(num) {
			case 1:
				System.out.print("예금액 > ");	
				balance = Integer.parseInt(scan.nextLine());
				sum += balance;
				break;
			case 2:
				System.out.print("출금액 > ");
				balance = Integer.parseInt(scan.nextLine());
				sum -= balance;
				break;
			case 3:
				System.out.printf("잔고 > %d\n", sum);
				break;
			case 4:
				run = false;
				break;
			}
		}
		System.out.println("프로그램 종료");
	}
}

