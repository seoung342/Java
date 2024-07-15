package dp;

import java.util.Vector;

public class Course {
	private String id;
	private String name;
	private int numOfStudent = 0;
	private Vector<Student> students;
	
	public Course(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.students = new Vector<Student>();
	}

	public void addStudent(Student student) {
		students.add(student);
		++numOfStudent;
	}
	
	public void deleteStudent(Student student) {
		if(students.contains(student)) {
			students.remove(student);
			--numOfStudent;
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumOfStudent() {
		return numOfStudent;
	}

	public void setNumOfStudent(int numOfStudent) {
		this.numOfStudent = numOfStudent;
	}

	
	public Vector<Student> getStudents() {
		return students;
	}

	public void setStudents(Vector<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", numOfStudent=" + numOfStudent + ", students=" + students
				+ "]";
	}


	

	
	
}
