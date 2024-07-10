package exam;

import java.util.Scanner;

public class Ex08 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(;;) {
			System.out.print("명령 >>");
			String input = scan.nextLine();
			if(input.equalsIgnoreCase("q")) {
				break;
			}
		}
		System.out.println("종료");
	}
}
