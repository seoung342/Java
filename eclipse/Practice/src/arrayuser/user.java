package arrayuser;

import java.util.Scanner;

public class user {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run1 = true;
		boolean run2 = true;
		
		String[] Id = new String[10];
		String[] Pass = new String[10];
		int[] Money = new int[10];
		
		int index = 0; // 배열 위치
		int balance = 0; // 입, 출금액
		int num = 0; // 선택 메뉴
		int i;
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
				for(i = 0; i < 10; i++) {
                    if(Id[i] != null && Id[i].equals(myId) && Pass[i] != null && Pass[i].equals(myPass)) {
                        index = i;
                        break;
                    }
                }
                if(Id[index] != null && Id[index].equals(myId) && Pass[index] != null && Pass[index].equals(myPass)) {
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
							Money[index] += balance;
							break;
						case 2:
							System.out.print("츨금할 금액 > ");
							balance = Integer.parseInt(scan.nextLine());
							Money[index] -= balance;
							break;
						case 3:
							System.out.printf("잔고 > %d\n",Money[index]);
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
				for (i = 0; i < 10; i++) {
					if(Id[i] == null) {
						index = i;
					}
					else {
						break;
					}
				}
				System.out.print("새로운 아이디 > ");
				Id[index] = scan.nextLine();
				System.out.print("새로운 비밀번호 > ");
				Pass[index] = scan.nextLine();
				System.out.println("회원 가입 성공!!");
				break;			
			case 3:
				run1 = false;
				break;
			}
		}
		System.out.println("프로그램 종료");

	}

}