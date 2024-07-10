package exam;

public class Ex05 {
	public static void main(String[] args) {
		
		int result = 0;
		int target = 100;
		int i = 0;
		
		for(i=0; i <= target; i++) {
			if( i % 2 == 0) {
				result += i;
			}
		}
		
		System.out.println(result);
	}
}
