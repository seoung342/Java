package dp2;

public class Main {

	// 성적이력 학업기록 나오게 만들기
	public static void main(String[] args) {
		
		Student minsu = new Student("민수");
		Student gildong = new Student("길동");
		
		Course java = new Course("자바");
		Course python = new Course("파이썬");
		
		Transcript t1 = new Transcript(java, minsu, "2024-07-15","A");
		Transcript t2 = new Transcript(java, gildong, "2024-07-15","A+");
		
		for(Transcript transcript : java.getTranscripts()) {
			System.out.println(transcript.getGrade());
		}
		
		
		
		
		

	}

}
