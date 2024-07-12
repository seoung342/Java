package project2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import project2.User;
import project3.Member;

public class MainPage {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run1 = true;
		boolean run2 = true;
		
		User[] user = new User[10];
		int userCount = 0; // 회원 수
		int balance = 0; // 입, 출금액
		int num = 0; // 선택 메뉴
		String myId = ""; // 내 아이디
		String myPass = ""; // 내 비밀번호
		String str = ""; // 빈 객체
		
		try(FileInputStream fis = new FileInputStream("c:\\_dev\\eclipse\\Practice\\src\\project2\\User.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			
			user = (User[]) ois.readObject();
			userCount = (int) ois.readObject();
			
			System.out.println("파일에서 객체를 가져왔습니다.");
			
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("회원 : " + userCount +"명");
		while(run1) {
			System.out.println("--------------------------------------------------------");
			System.out.println(" 1.로그인 | 2.회원가입 | 3.아이디 찾기 | 4.비밀번호 찾기 | 5.종료");
			System.out.println("--------------------------------------------------------");
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
				if(myId.equals("123123") && myPass.equals("123123")) {
					for(int info = 0; info < userCount; info++) {
						user[info].getInfo();
					}
					break;
				}
				for(int i = 0; i < userCount; i++) {
                    if(user[i] != null && user[i].getId().equals(myId)) {
                    	if(user[i].getPass().equals(myPass)) {
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
									user[i].setAddMoney(balance);
									break;
								case 2:
									do{
										System.out.print("츨금할 금액 > ");
										str = scan.nextLine();
									}while(!str.matches("^[0-9]+$"));
									balance = Integer.parseInt(str);
									user[i].setSubMoney(balance);
									break;
								case 3:
									System.out.printf("잔고 > %d\n",user[i].getMoney());
									break;
								case 4:
									user[i].getInfo();
									break;
								case 5:
									System.out.println("예금 / 출금 프로그램 종료");
									run2 = false;
									break;
								}
							}
						}else {
							System.out.println("로그인 실패 비밀번호를 다시 확인하세요.");
						}
                    	break;
                    }
                    if (i == userCount - 1) {
                        // 모든 사용자를 검색했으나 일치하는 아이디가 없는 경우
                        System.out.println("로그인 실패 아이디를 다시 확인하세요.");
                    }
				}
				run2 = true;
				break;
			case 2: // 회원 가입
				if(userCount < 10) {
					System.out.print("회원 가입 \n [필수 정보 입력] \n");
					System.out.print("1. 이름 : ");
					String name = scan.nextLine();
					System.out.print("2. 주민번호 앞 6자리 : ");
					String Personal = scan.nextLine();
					System.out.print("3. 전화 번호 : ");
					String Phone = scan.nextLine();
					System.out.print("4. 아이디 : ");
					String Id = scan.nextLine();
					System.out.print("5. 비밀번호 : ");
					String Pass = scan.nextLine();
					user[userCount] = new User(name, Personal, Phone, Id, Pass);
					user[userCount].getInfo();
					userCount++;
				}else {
					System.out.println("더 이상 회원 가입을 하지 못합니다.");
				}
				break;			
			case 3: // 아이디 찾기
				System.out.print("이름 > ");
				String name = scan.nextLine();
				System.out.print("전화 번호 > ");
				String phone = scan.nextLine();
				for (int i = 0; i < userCount; i++) {
					if(user[i].getName().equals(name)) {
						if(user[i].getPhone().equals(phone)) {
							System.out.println("당신의 아이디는 "+user[i].getId()+" 입니다.");
						}else {
							System.out.println("전화번호가 틀렸습니다.");
							break;
						}
					}else {
						System.out.println("이름이 틀렸습니다.");
						break;
					}
				}
				break;
			case 4: // 비밀번호 찾기
				System.out.print("아이디 > ");
				String Id1 = scan.nextLine();
				System.out.print("이름 > ");
				String name1 = scan.nextLine();
				System.out.print("전화 번호 > ");
				String phone1 = scan.nextLine();
				for (int i = 0; i < userCount; i++) {
					if(user[i].getId().equals(Id1)) {
						if(user[i].getName().equals(name1)) {
							if(user[i].getPhone().equals(phone1)) {
								System.out.println("당신의 비밀번호는 "+user[i].getPass()+" 입니다.");
							}else {
								System.out.println("전화번호가 틀렸습니다.");
								break;
							}
						}else {
							System.out.println("이름이 틀렸습니다.");
							break;
						}
					}else {
						System.out.println("아이디가 틀렸습니다.");
						break;
					}
				}
				break;
			case 5: // 종료
				try(FileOutputStream fos = new FileOutputStream("c:\\_dev\\eclipse\\Practice\\src\\project2\\User.dat");
						ObjectOutputStream oos = new ObjectOutputStream(fos)){
					
					oos.writeObject(user);
					oos.writeObject(userCount); // 사용자 수 저장
					System.out.println("객체를 파일에 저장했습니다.");
					
				}catch(IOException e) {
					e.printStackTrace();
				}
				run1 = false;
				break;
			default:
				System.out.println("잘못된 선택입니다.");
				break;
			}
		}
		System.out.println("프로그램 종료");
	}
}
