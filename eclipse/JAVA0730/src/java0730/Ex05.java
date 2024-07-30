package java0730;

import java.util.stream.IntStream;

public class Ex05 {

	public static void main(String[] args) {

//		IntStream ii = IntStream.range(1, 5);
		int count = 10;
		
		IntStream ii = IntStream.rangeClosed(1, count);
//		ii.forEach(System.out::println);
		ii.forEach(a->{
			System.out.println(a);
		});
		
		
	}

}
