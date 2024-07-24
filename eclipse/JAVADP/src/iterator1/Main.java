package iterator1;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		StudentData studentData = new StudentData(3);
		studentData.appendStudent(new Student("홍길동","202020",90));
		studentData.appendStudent(new Student("고길동","101010",80));

		//명시적으로 Interator를 사용하는 방법
		Iterator<Student> it = studentData.iterator();
		while(it.hasNext()) {
			Student student = it.next();
			System.out.println(student);
		}
		System.out.println();
			
		// 확장 for문을 사용하는 방법
		for( Student student : studentData) {
			System.out.println(student);
		}
		System.out.println();
	}

}
