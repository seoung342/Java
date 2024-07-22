/*
 * 콘솔 창ㅇ에서 입력을 방아 dept 테이블에 insert하는 자바 프로그램을 만들어 보세요.
 * */
package project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print(" DDEPTNO > ");
		int DEPTNO = Integer.parseInt(scan.nextLine());
		System.out.print(" DNAME > ");
		String DNAME = scan.nextLine();
		System.out.print(" LOC > ");
		String LOC = scan.nextLine();
		
		String insertDept = "INSERT INTO dept VALUES("+DEPTNO+", '"+DNAME+"', '"+LOC+"')";
		
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("MySql 접속 성공!!");
			stmt = con.createStatement();
			stmt.executeUpdate(insertDept);
			System.out.println("dept 테이블에 데이터 삽입 성공!!!");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
