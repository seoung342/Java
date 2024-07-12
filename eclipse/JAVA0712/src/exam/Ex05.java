/*
 * 2차원 배열을 이용하여 국어 점수와 수학 점수를 입력 받아서 학생별 평균을 출력하는 프로그램을 작성하세요.
 * */
package exam;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("학생은 몇명 > ");
		int x = Integer.parseInt(scan.nextLine());
		String[] name = new String[x];
		double[][] score = new double[x][3]; 
		
		for(int i = 0; i < name.length; i++) {
			System.out.print("학생의 이름 > ");
			name[i] = scan.nextLine();
			System.out.print("국어 점수 > ");
			score[i][0] = Double.parseDouble(scan.nextLine());
			System.out.print("수학 점수 > ");
			score[i][1] = Double.parseDouble(scan.nextLine());
			score[i][2] = (score[i][0] + score[i][1]) / 2;
		}
		
		for (int j = 0; j < name.length; j++) {
			System.out.println(name[j]+"의 국어 점수는 "+score[j][0]+" 수학 점수는 "+score[j][1]+" 평균은 "+score[j][2]+"입니다.");
		}
	}

}
