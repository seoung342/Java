package exam;

public class SearchEx {

	public static void main(String[] args) {
		int a[] = {10, 3, 4, 1, 4, 2};
		int val =4;
		int find = -1;
		
		for (int i =0; i < a.length; i++) {
			if(a[i] == val) {
				find = i;
				break;
			}
		}
		
		System.out.println("인덱스 > "+find);
	}

}
