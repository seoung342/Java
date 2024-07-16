package project1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MainPage {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Stock[] stock = new Stock[30];
		boolean run1 = true;
		String str = "";
		
		int num = 0;
		int x = 0;
		
		
		try(FileInputStream fis = new FileInputStream("c:\\_dev\\eclipse\\Practice\\src\\project1\\Stock.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			stock = (Stock[]) ois.readObject();
			System.out.println("파일에서 객체를 가져왔습니다.");
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		while(run1) {
			System.out.println("--------------------------------------------------------");
			System.out.println(" 1.추가 | 2.제거 | 3.현황 보기 | 4.종료");
			System.out.println("--------------------------------------------------------");
			do{
				System.out.print("선택 > ");
				str = scan.nextLine();
			}while(!str.matches("^[0-9]$"));
			num = Integer.parseInt(str);
			switch(num) {
			case 1:
				for(int i =0; i < 30; i++) {
					if (stock[i] == null) {
				        stock[i] = new Stock();
				        x = i;
				        break;
				    }
				}
				System.out.println("주식 추가");
				System.out.print("종목 > ");
				stock[x].setTicker(scan.nextLine());
				System.out.print("갯수 > ");
				stock[x].setAmount(Double.parseDouble(scan.nextLine()));
				System.out.print("가격 > ");
				stock[x].setPrice(Double.parseDouble(scan.nextLine()));
				break;
			case 2:
				System.out.print("종목 > ");
				str = scan.nextLine();
				for(int i = 0; i < 30; i++) {
					if(stock[i].getTicker().equals(str)) {
						stock[i] = null;
						break;
					}
				}
				break;
			case 3:
				for(int i = 0; i < 30; i++) {
					if(stock[i] != null) {
						stock[i].getInfo();
					}
				}
				break;
			case 4: // 종료
				try(FileOutputStream fos = new FileOutputStream("c:\\_dev\\eclipse\\Practice\\src\\project1\\Stock.dat");
						ObjectOutputStream oos = new ObjectOutputStream(fos)){
					
					oos.writeObject(stock);
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
