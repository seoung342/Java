package exam;

import java.util.Scanner;

public class Ex02 {
	/* 사과가 10개가 있습니다. 2명의 친구가 있습니다.( 본인을 포합하면 총 3명)
	   사과를 똑같이 나눠 먹으면 몇개의 사과가 남을까요? (Scanner 사용해서 입력 받기 )
	*/
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int apple;
		System.out.print("사과의 개수 : ");
		apple = scan.nextInt();
		
		int human;
		System.out.print("몇명의 사람 : ");
		human = scan.nextInt();
		
		int eat = apple / human;
		int count = apple % human;
		
		System.out.printf("총 %d개의 사과를 %d명의 사람이 %d개씩 먹어서 %d개가 남았다.", apple, human, eat, count);
	}

}
