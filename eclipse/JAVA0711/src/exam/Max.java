package exam;

public class Max {

	public static void main(String[] args) {
		int a[] = { 1, 3, 10, 2, 8};
		
		int max = 0;
		
		for (int i = 0; i < a.length; i++) {
			if( max < a[i]) {
				max = a[i];
			}
		}
		
		System.out.println("최대 값 : " + max);

	}

}
