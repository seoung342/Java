/*
 * 100점 만점의 학점을 입력받아서 90점 이상이면 A, 80점 이상이면 B,
 * 70점 이상이면 C, 60점 이상이면 D, 60점 미만이면 F를 구하는 프로그램을 작성하세요.
 * (단, 입력받은 점수는 0점에서 100점 사이의 값만 넣어햐 함) 
 **/
package exam;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("점수를 입력하세요( 0 ~ 100 ) : ");
		int score = scan.nextInt();
		String str = "";
		
		if( score < 0 && score > 100){
			System.out.println("다시 입력하세요.");
			System.out.print("점수를 입력하세요 : ");
			score = scan.nextInt();
		}
		
		String st1 = (score >= 90) ? "A": (score >= 80) ? "B" : (score >= 70) ? "C" : (score >= 60) ?"D" : "F";
		System.out.println(st1);
		
		
		String result = resultSwitch(score, str);
		System.out.println(result);
	}
	
	public static String resultElseIf(int x, String result) {
		if( x >= 90) {
			result = "A";
		}
		else if(x >= 80) {
			result = "B";
		}
		else if(x >= 70) {
			result = "C";
		}
		else if(x >= 60) {
			result = "D";
		}
		else {
			result = "F";
		}
		
		return result;
	}
	
	public static String resultSwitch(int x, String result) {
		
		int grade = x / 10;
		
		switch(grade) {
			case 10:
				result = "A";
				break;
			case 9:
				result = "A";
				break;
			case 8:
				result = "B";
				break;
			case 7:
				result = "C";
				break;
			case 6:
				result = "D";
				break;
			default:
				result = "F";
				break;	
		}
		
		return result;
		
	}
	
}
