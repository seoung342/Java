package dp2;

public class Transcript {
	private Course course;
	private Student student;
	private String date;
	private String grade;
	
	public Transcript() {
		
	}

	public Transcript(Course course, Student student, String date, String grade) {
		this.course = course;
		this.student = student;
		this.date = date;
        this.grade = grade;
	}
	public void registerCourse(Course course) {
        this.course = course;
    }
	
	public void dropCourse() {
        this.course = null;
    }
	
	public void addStudent(Student student) {
        this.student = student;
    }

    public void deleteStudent() {
        this.student = null;
    }
    
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Transcript [course=" + course + ", student=" + student + ", date=" + date + ", grade=" + grade + "]";
	}
	
	

}
