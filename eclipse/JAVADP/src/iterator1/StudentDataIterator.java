package iterator1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StudentDataIterator implements Iterator<Student> {
	
	private StudentData studentData;
	private int index;
	
	public StudentDataIterator(StudentData studentData) { // 생성자
		this.studentData = studentData;
		this.index = 0;
	}
	
	@Override
	public boolean hasNext() { // 다음 학생이 있나요
		if(index < studentData.getLength()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Student next() { // 다음 학생을 가져올 때
		if(!hasNext()) {
			throw new NoSuchElementException(); // 예외 발생
		}
		Student student = studentData.getStudentAt(index);
		index++;
		return student;
	}

}
