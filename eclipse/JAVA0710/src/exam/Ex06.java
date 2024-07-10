/* 
 * 구구단 출력하기
 * */

package exam;

public class Ex06 {
	public static void main(String[] args) {
		
		for(int x = 1; x < 10; x++) {
			for(int y = 2; y <= 9; y++) {
				System.out.printf("%d * %d = %d \t", y, x, y*x);
			}
			System.out.println();	
		}
		
	}
}
