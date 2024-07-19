/*
 * MySql 연동
 * CRUD
 * Create : insert 문
 * Read : select 문
 * Update
 * Delete
 * 
 * 테이블 만드는 법
 * */

package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex03 {

	public static void main(String[] args) {
		String createString = "CREATE TABLE customer"+
							"(customer_id char(6) not null primary key, " +
							"customer_name varchar(15) not null, "+
							"customer_tel varchar(13), " +
							"customer_addr varchar(20))";
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("MySql 접속 성공!!");
			stmt = con.createStatement();
			stmt.executeUpdate(createString);
			System.out.println("테이블 생성!!!");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}