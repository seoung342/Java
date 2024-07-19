/*
 * MySql 연동
 * 
 * 테이블에 데이터 넣는 방법
 * */

package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex05 {

	public static void main(String[] args) {
		String createString = "INSERT INTO customer VALUES('C-1003', '홍길동', '010-3333-4444', '율도국')";
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("MySql 접속 성공!!");
			stmt = con.createStatement();
			int num = stmt.executeUpdate(createString);
			System.out.println("테이블에 데이터 삽입!!!" + num);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}