package score;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Main {

	public static void main(String[] args) {
//		Class.forName("com.mysql.cj.jdbc.Driver");
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		List<Score> list = new ArrayList<>();
		
		try {
			Connection con = DriverManager.getConnection(URL,"root","mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from score");
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int math = rs.getInt("math");
				list.add(new Score(num, name, kor, eng, math));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		list.stream().forEach(a->{
			int sum = a.getKor() + a.getEng() + a.getMath();
			double avg = (double)sum / 3;
			System.out.println(a.getName()+"의 총점 : "+sum+", 평균 : "+avg);
		});
		
		int korSum = list.stream().mapToInt(s->s.getKor()).sum();
		OptionalDouble korAvg = list.stream().mapToInt(s->s.getKor()).average();
		korAvg.ifPresent(avg -> System.out.println("모든 학생의 국어 총점 :"+korSum+", 평균 : "+avg));
		int engSum = list.stream().mapToInt(s->s.getEng()).sum();
		OptionalDouble engAvg = list.stream().mapToInt(s->s.getEng()).average();
		engAvg.ifPresent(avg -> System.out.println("모든 학생의 영어 총점 :"+engSum+", 평균 : "+ avg));
		int mathSum = list.stream().mapToInt(s->s.getMath()).sum();
		OptionalDouble mathAvg = list.stream().mapToInt(s->s.getMath()).average();
		mathAvg.ifPresent(avg -> System.out.println("모든 학생의 수학 총점 :"+mathSum+", 평균 : "+ avg));

	}

}
