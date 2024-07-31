package java0731;

import java.util.Arrays;
import java.util.List;

public class Ex05 {
	public static void main(String[] args) {
		List<Member>  list = Arrays.asList(
				new Member("홍길동",Member.MALE, 30),
				new Member("김길동",Member.MALE, 60),
				new Member("이길동",Member.FEMALE, 45),
				new Member("박길동",Member.FEMALE, 27));
		
		// 전체 평균 나이
		double avg = list.stream().mapToInt(Member::getAge).average().orElse(0);
		System.out.println(avg);
		
		// 남자 평균 나이
		double avg1 = list.stream().filter(x->x.getSex() == Member.MALE).mapToInt(s->s.getAge()).average().orElse(0);
		System.out.println(avg1);
		
		
		
		
		
	}
}
