package p367;

import java.util.Scanner;

public class DriverExample {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("차량을 선택하세요(1:버스, 2:택시) : ");
		int num = scan.nextInt();
		Driver driver = new Driver();
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		Vehicle v1 = new Bus();
		
		switch(num){
			case 1:
				v1 = new Bus();
				driver.driver(v1);
				break;
			case 2:
				v1 = new Taxi();
				driver.driver(v1);
				break;
			default:
				System.out.println("선택 오류!");
					
					
		}
		
		
//		driver.driver(v1);
//		driver.driver(taxi);
	}
}
