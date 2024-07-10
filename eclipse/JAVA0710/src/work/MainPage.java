package work;

import java.util.Scanner;
import work.User;

public class MainPage {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run1 = true;
		boolean run2 = true;
		
		User user = new User();
		int balance = 0; // 입, 출금액
		int num = 0; // 선택 메뉴
		String myId = ""; // 내 아이디
		String myPass = ""; // 내 비밀번호
		
		while(run1) {
			System.out.println("-------------------------------------------------");
			System.out.println(" 1.로그인 | 2.회원가입 | 3.종료");
			System.out.println("-------------------------------------------------");
			System.out.print("선택 > ");
			num = Integer.parseInt(scan.nextLine());
			switch(num) {
			case 1:
				System.out.print("아이디 > ");
				myId = scan.nextLine();
				System.out.print("비밀번호 > ");
				myPass = scan.nextLine();
				if(myId.equals(user.getId()) && myPass.equals(user.getPass())) {
					System.out.println("로그인 성공");
					while(run2) {
						System.out.println("-------------------------------------------------");
						System.out.println(" 1.예금 | 2.출금 | 3.잔고 | 4.종료");
						System.out.println("-------------------------------------------------");
						System.out.print("선택 > ");
						num = Integer.parseInt(scan.nextLine());
						switch(num) {
						case 1:
							System.out.print("예금할 금액 > ");
							balance = Integer.parseInt(scan.nextLine());
							user.setAddMoney(balance);
							break;
						case 2:
							System.out.print("츨금할 금액 > ");
							balance = Integer.parseInt(scan.nextLine());
							user.setSubMoney(balance);
							break;
						case 3:
							System.out.printf("잔고 > %d\n",user.getMoney());
							break;
						case 4:
							run2 = false;
							break;
						}
					}
				}else {
					System.out.println("로그인 실패");
					break;
				}
				run2 = true;
				break;
			case 2:
				System.out.print("새로운 아이디 > ");
				user.setId(scan.nextLine());
				System.out.print("새로운 비밀번호 > ");
				user.setPass(scan.nextLine());
				System.out.println("회원 가입 성공!!");
				break;			
			case 3:
				run1 = false;
				break;
			}
		}
		run1 = true;
		System.out.println("프로그램 종료");
	}
}
