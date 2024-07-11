/*
 * 세 정수를 입력받아 중앙값 구하기
 * */
package exam;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int a, b, c, d;
		
		System.out.print("a > ");
		a = scan.nextInt();
		System.out.print("b > ");
		b = scan.nextInt();
		System.out.print("c > ");
		c = scan.nextInt();
		
		d = getMiddle(a,b,c);
		
		
		System.out.println("중앙 값은 "+d+"입니다.");	
	}
	
	public static int getMiddle(int a, int b, int c) {
		
		int result = 0;
		
		if((b >= a && c <= a) || ( b <= a && c >=a)){
			return a;
		}else if((a > b && c < b ) || ( a < b && c > b )) {
			return b;
		}
		return c;
		/*
		if ( a > b && a > c) {
			if ( b > c ) {
				result = b;
			}else {
				result = c;
			}
		}else if( b > a && b > c) {
			if ( a > c ) {
				result = a;
			}else {
				result = c;
			}
		}else {
			if( a > b ) {
				result = a;
			}else {
				result = b;
			}
		}
		
		return result;
		*/
	}

}
