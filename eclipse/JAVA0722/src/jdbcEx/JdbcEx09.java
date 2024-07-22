package jdbcEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;



public class JdbcEx09 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;	// 접속 정보
		Statement stmt = null;	// 
		
		System.out.print("테이블 이름 입력 > ");
		String str = scan.nextLine();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,"root","mysql");
			System.out.println("접속 성공~!");
			stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("Select * from " + str);
			ResultSetMetaData rsmd = result.getMetaData();
			int numOfCol = rsmd.getColumnCount();
			System.out.println(numOfCol);
			for ( int i = 1; i <= numOfCol; i++) {
				System.out.println(rsmd.getColumnName(i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
// Scanner 사용해서 입력받아 dept 테이블 자료 입력하기 ( deptno는 자동으로 들어간다 )