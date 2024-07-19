/*
 * MySql 연동
 * 
 * 테이블 삭제하는 방법
 * */

package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex04 {

	public static void main(String[] args) {
		String createString = "drop table customer";
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("MySql 접속 성공!!");
			stmt = con.createStatement();
			stmt.executeUpdate(createString);
			System.out.println("테이블 삭제!!!");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}