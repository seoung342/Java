package dp;

public class Main2 {

	public static void main(String[] args) {
		Student minsu = new Student("민수");	// 학생 등록
		Course java = new Course("cs100", "자바"); // Course 등록
		Course cplus = new Course("cs101", "C/C++"); // Course 등록
		minsu.registerCourse(java);
		java.addStudent(minsu);
		minsu.registerCourse(cplus);
		cplus.addStudent(minsu);
		
		
		Student gildong = new Student("길동");	// 학생 등록
		gildong.registerCourse(java);
		java.addStudent(gildong);
		
//		System.out.println(minsu);
//		System.out.println(gildong);
		
		// 코스별 신청자 출력
		System.out.println("자바 수강 신청자 : " + java.getNumOfStudent());
		for ( Student student : java.getStudents()) {
			System.out.println(student.getName());
			
		}
		System.out.println("C++ 수강 신청자 : " + cplus.getNumOfStudent());
		for ( Student student : cplus.getStudents()) {
			System.out.println(student.getName());
			
		}		
	}

}
