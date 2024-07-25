package du;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.log.Log;

/**
 * Servlet implementation class First
 */
@WebServlet("/First")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public First() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag = false;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf8");
		PrintWriter out = response.getWriter();
		
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;	// 접속 정보
		PreparedStatement pstmt = null;	// 
		String sql = "select * from account where name = ? and ssn = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,"root","mysql");
			System.out.println("접속 성공~!");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("name"));
			pstmt.setString(2, request.getParameter("ssn"));
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				flag = true;
				LoginSession.id = rs.getInt("id");
				LoginSession.name = rs.getString("name");
				LoginSession.ssn = rs.getString("ssn");
				LoginSession.tel = rs.getString("tel");
				LoginSession.balance =rs.getInt("balance");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(flag) {
			out.println("<h1>"+LoginSession.name+"님 환영합니다.");
		}else {
			out.println("<h1> 로그인을 다시해주세요.</h1>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
