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
		System.out.print("점수를 입력하세요 : ");
		int score = scan.nextInt();
		
		if( score < 0 && score > 100){
			System.out.println("다시 입력하세요.");
			System.out.print("점수를 입력하세요 : ");
			score = scan.nextInt();
		}
		
		if( score >= 90) {
			System.out.println("A");
		}
		else if(score >= 80) {
			System.out.println("B");
		}
		else if(score >= 70) {
			System.out.println("C");
		}
		else if(score >= 60) {
			System.out.println("D");
		}
		else {
			System.out.println("F");
		}
	}
	
}
