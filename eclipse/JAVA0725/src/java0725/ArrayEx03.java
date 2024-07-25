package java0725;

import java.util.Arrays;

public class ArrayEx03 {
	public static void main(String[] args) {
		int[] array = {1,1,3,4,5,7,8,11,12,17,21,24};
		int found = Arrays.binarySearch(array, 5);
		System.out.println(found);
	}
}
