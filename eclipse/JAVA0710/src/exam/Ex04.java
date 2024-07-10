/*
 * 1부터 10까지 짝수의 합
 * */

package exam;

public class Ex04 {
	public static void main(String[] args) {
		
		for (int i = 1; i <= 10; i++) {
			if( i % 2 == 0) {
				System.out.println(i);
			}
		}
	}
}
