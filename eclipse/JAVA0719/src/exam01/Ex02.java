/*
 * MySql 연동
 * */

package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex02 {

	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("MySql 접속 성공!!");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}