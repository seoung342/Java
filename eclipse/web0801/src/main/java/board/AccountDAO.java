package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.JDBCUtil;

public class AccountDAO {
	// JDBC 관련 변수 
		private Connection conn = null;
		private PreparedStatement stmt = null;
		private ResultSet rs = null;
		
		private String ACCOUNT_LIST = "select * from account"; // account 조회
		private String ACCOUNT_INSERT = "insert into account (name, ssn, tel, balance) values (?, ?, ?, 0)";
		private String ACCOUNT_CHECK = "select count(*) from account where name = ? and ssn=?";
		
		// 회원 확인
		public boolean getCheck(String name, String ssn) {
			conn = JDBCUtil.getConnection();
			try {
				stmt = conn.prepareStatement(ACCOUNT_CHECK);
				stmt.setString(1, name);
				stmt.setString(2, ssn);
				rs = stmt.executeQuery();
				rs.next();
				if(rs.getInt(1) == 1) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			return false;
		}
		
		// 회원 가입
		public void insertAccount(AccountDTO dto) {
			conn = JDBCUtil.getConnection();
			try {
				stmt = conn.prepareStatement(ACCOUNT_INSERT);
				stmt.setString(1, dto.getName());
				stmt.setString(2, dto.getSsn());
				stmt.setString(3, dto.getTel());
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(stmt, conn);
			}
		}
		
		// account 데이터 조회
		public List<AccountDTO> getBoardList() {
			List<AccountDTO> list = new ArrayList<>();
			
			conn = JDBCUtil.getConnection();
			try {
				stmt = conn.prepareStatement(ACCOUNT_LIST);
				rs = stmt.executeQuery();
				while (rs.next()) {
					AccountDTO dto = new AccountDTO(rs.getInt("id"), rs.getString("name"),
							rs.getString("ssn"), rs.getString("tel"),rs.getInt("balance"));
					list.add(dto);
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(rs, stmt, conn);
			}
			
			return list;
		}

}
