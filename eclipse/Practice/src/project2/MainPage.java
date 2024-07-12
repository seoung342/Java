package project2;

import java.util.Scanner;
import project2.User;

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
		String str = ""; // 빈 객체
		
		while(run1) {
			System.out.println("-------------------------------------------------");
			System.out.println(" 1.로그인 | 2.회원가입 | 3.종료");
			System.out.println("-------------------------------------------------");
			do{
				System.out.print("선택 > ");
				str = scan.nextLine();
			}while(!str.matches("^[0-9]$"));
			num = Integer.parseInt(str);
			switch(num) {
			case 1:
				System.out.println("로그인 처리");
				System.out.print("아이디 > ");
				myId = scan.nextLine();
				System.out.print("비밀번호 > ");
				myPass = scan.nextLine();
                if(user.getId().equals(myId) && user.getPass().equals(myPass)) {
                    System.out.println("로그인 성공");
					while(run2) {
						System.out.println("-------------------------------------------------");
						System.out.println(" 1.예금 | 2.출금 | 3.잔고 | 4.내 정보 확인 | 5.종료");
						System.out.println("-------------------------------------------------");
						do{
							System.out.print("선택 > ");
							str = scan.nextLine();
						}while(!str.matches("^[0-9]$"));
						num = Integer.parseInt(str);
						switch(num) {
						case 1:
							do{
								System.out.print("예금할 금액 > ");
								str = scan.nextLine();
							}while(!str.matches("^[0-9]+$"));
							balance = Integer.parseInt(str);
							user.setAddMoney(balance);
							break;
						case 2:
							do{
								System.out.print("츨금할 금액 > ");
								str = scan.nextLine();
							}while(!str.matches("^[0-9]+$"));
							balance = Integer.parseInt(str);
							user.setSubMoney(balance);
							break;
						case 3:
							System.out.printf("잔고 > %d\n",user.getMoney());
							break;
						case 4:
							user.getInfo();
							break;
						case 5:
							System.out.println("예금 / 출금 프로그램 종료");
							run2 = false;
							break;
						}
					}
				}else if(!user.getId().equals(myId)){
					System.out.println("로그인 실패 아이디를 다시 확인하세요.");
					break;
				}else {
					System.out.println("로그인 실패 비밀번호를 다시 확인하세요.");
				}
				run2 = true;
				break;
			case 2:
				System.out.print("회원 가입 \n [필수 정보 입력] \n");
				System.out.print("1. 이름 : ");
				user.setName(scan.nextLine());
				System.out.print("2. 주민번호 앞 6자리 : ");
				user.setPersonal(scan.nextLine());
				System.out.print("3. 전화 번호 : ");
				user.setPhone(scan.nextLine());
				System.out.print("4. 아이디 : ");
				user.setId(scan.nextLine());
				System.out.print("5. 비밀번호 : ");
				user.setPass(scan.nextLine());
				user.getInfo();
				break;			
			case 3:
				run1 = false;
				break;
			}
		}
		System.out.println("프로그램 종료");
	}
}
