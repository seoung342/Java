package java0730;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex03 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("홍길동", 100));
		list.add(new Student("고길동", 60));
		list.add(new Student("장발장", 80));
		
		Collections.sort(list, (s1, s2)->Integer.compare(s1.getScore(), s2.getScore()));
//		객체 배열 Arrays.sort 사용
		list.stream().forEach(s->{
			System.out.println(s.getName() + ", " + s.getScore());
		});
	}
}
