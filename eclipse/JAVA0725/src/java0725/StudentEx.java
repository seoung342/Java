package java0725;

import java.util.Arrays;
import java.util.Comparator;

public class StudentEx {

	public static void main(String[] args) {
		Student[] students = {
			new Student("홍길동", 97),
			new Student("고길동", 80),
			new Student("김길동", 85),
			new Student("박길동", 60),
			new Student("이길동", 71)
		};
		
		Comparator<Student> c = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return Integer.compare(o2.getScore(), o1.getScore());
			}
		};
		
		Arrays.sort(students, c);
		for ( Student st : students) {
			System.out.println(st);
		}

	}

}
