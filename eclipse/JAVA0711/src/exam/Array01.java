package exam;

public class Array01 {

	public static void main(String[] args) {
		int[] myArr = new int[5]; // 배열 생성 ( 초기화 )
		
		for (int i = 0; i < 5; i++) {
			System.out.println(myArr[i]);
		}
		
		double[] myArr2 = new double[5];
		
		for (int i = 0; i < 5; i++) {
			System.out.println(myArr2[i]);
		}
		
		double sum =0;
		double avg = 0;
		int[] score = {83, 90, 87};
		for (int i =0; i<score.length; i++) {
			sum += score[i];
		}
		avg =sum / score.length;
		System.out.println("총점 : "+ sum);
		System.out.println("평균 : "+ avg);

	}

}
