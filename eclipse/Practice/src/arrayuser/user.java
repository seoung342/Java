/*
 * 회원 가입해서 입, 출금 관리
 * */
package arrayuser;

import java.util.Scanner;

public class user {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		boolean run1 = true;
		boolean run2 = true;
		
		String[] Id = new String[10];	// 아이디
		String[] Pass = new String[10];	// 비밀번호
		int[] Money = new int[10];	// 잔고
		String[] Name = new String[10]; // 이름
		String[] Personal = new String[10];	// 주민번호 핲 6자리
		String[] Phone = new String[10];	// 전화 번호
		
		int index = 0; // 배열 위치
		int balance = 0; // 입, 출금액
		int num = 0; // 선택 메뉴
		int i;
		String myId = ""; // 내 아이디
		String myPass = ""; // 내 비밀번호
		String str = "";
		
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
							Money[index] += balance;
							break;
						case 2:
							do{
								System.out.print("츨금할 금액 > ");
								str = scan.nextLine();
							}while(!str.matches("^[0-9]+$"));
							balance = Integer.parseInt(str);
							Money[index] -= balance;
							break;
						case 3:
							System.out.printf("잔고 > %d\n",Money[index]);
							break;
						case 4:
							System.out.print("\n [내 정보] \n 1. 이름 : "+Name[index]+"\n 2. 주민번호 앞 6자리 : "+Personal[index]
									+"\n 3. 전화번호 : "+Phone[index]+"\n 4. 아이디 : "+Id[index]+"\n 5. 비밀번호 : "+Pass[index]+"\n 6. 잔고 : "+Money[index]+"\n");
							break;
						case 5:
							System.out.println("예금 / 출금 프로그램 종료");
							run2 = false;
							break;
						}
					}
				}else if(Id[index] != null && !Id[index].equals(myId)){
					System.out.println("로그인 실패 아이디를 다시 확인하세요.");
					break;
				}else {
					System.out.println("로그인 실패 비밀번호를 다시 확인하세요.");
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
				System.out.print("회원 가입 \n [필수 정보 입력] \n");
				System.out.print("1. 이름 : ");
				Name[index] = scan.nextLine();
				System.out.print("2. 주민번호 앞 6자리 : ");
				Personal[index] = scan.nextLine();
				System.out.print("3. 전화 번호 : ");
				Phone[index] = scan.nextLine();
				System.out.print("4. 아이디 : ");
				Id[index] = scan.nextLine();
				System.out.print("5. 비밀번호 : ");
				Pass[index] = scan.nextLine();
				System.out.print("\n [입력된 내용] \n 1. 이름 : "+Name[index]+"\n 2. 주민번호 앞 6자리 : "+Personal[index]
									+"\n 3. 전화번호 : "+Phone[index]+"\n 4. 아이디 : "+Id[index]+"\n 5. 비밀번호 : "+Pass[index]+"\n");
				break;			
			case 3:
				run1 = false;
				break;
			}
		}
		System.out.println("프로그램 종료");

	}

}