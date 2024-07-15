package dp;

import java.util.Vector;

public class Student {
	private Professor advisor;
	private String name;
	private Vector<Course> courses;
	
	public Student() {	}

	public Student(String name) {
//		super();
		this.name = name;
		this.courses = new Vector<Course>();
	}

	public void advise(String msg) {
		System.out.println(msg);
	}

	public Professor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Professor advisor) {
		this.advisor = advisor;
	}
	
	public void registerCourse(Course course) {
		courses.add(course);
	}
	
	public void dropCourse(Course course) {
		if(courses.contains(course)) {
			courses.remove(course);
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vector<Course> getCourses() {
		return courses;
	}

	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [advisor=" + advisor + ", name=" + name + ", courses=" + courses + "]";
	}

	
	
	
	
}
