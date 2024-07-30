package java0730;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Ex01 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("홍길동", 100));
		list.add(new Student("고길동", 60));
		list.add(new Student("장발장", 80));
		
		// 70점 이상인 사람 이름
		list.stream()
		.filter(s->s.getScore() >= 70)
		.forEach(s->System.out.println(s.getName()));
		
		// 점수 70 미만 삭제
//		for(int i  = 0; i < list.size(); i++) {
//			if(list.get(i).getScore() < 70) {
//				list.remove(i);
//			}
//		}

		list.stream().forEach(a->{
			String msg = MessageFormat.format("{0}, {1}", a.getName(), a.getScore());
			System.out.println(msg);
		});
		
		
//		for(Student student : list) {
//			String msg = MessageFormat.format("{0}, {1}", student.getName(), student.getScore());
//			System.out.println(msg);
//		}
		
		long num = list.stream().filter(a->a.getScore() >= 70).count();
		System.out.println("70점 이상인 사람은 "+num+"명");
	}
}
