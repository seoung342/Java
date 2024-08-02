package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.JDBCUtil;

public class MemberDAO {
	// JDBC 관련 변수 
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private String MEMBER_LIST = "select * from member";
	private String MEMBER_LIST_ONE = "select * from member where id = ? and pw = ?";
	private String MEMBER_UPDATE = "update member set pw = ?, name = ? where id = ?";
	private String MEMBER_INSERT = "insert into member (id, pw, name) values (?, ?, ?)";
	private String MEMBER_CHECK = "select count(*) from member where id = ?";
	
	// 회원 확인
	public boolean getCheck(String id, String pw) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(MEMBER_CHECK);
			stmt.setString(1, id);
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
	public void insertMember(MemberDTO dto) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(MEMBER_INSERT);
			stmt.setString(1, dto.getId());
			stmt.setString(2, dto.getPw());
			stmt.setString(3, dto.getName());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 정보 수정
	public void updateMember(MemberDTO dto) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(MEMBER_UPDATE);
			stmt.setString(1, dto.getPw());
			stmt.setString(2, dto.getName());
			stmt.setString(3, dto.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	//맴버 하나 조회
	public MemberDTO getMemberOne(String id, String pw) {
		MemberDTO dto = null;
		
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(MEMBER_LIST_ONE);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			rs = stmt.executeQuery();
			while (rs.next()) {
				dto = new MemberDTO(rs.getString("id"), rs.getString("pw"),
						rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return dto;
	}		
	
	//맴버 전체 목록 조회
	public List<MemberDTO> getMemberList() {
		List<MemberDTO> list = new ArrayList<>();
		
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(MEMBER_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				MemberDTO dto = new MemberDTO(rs.getString("id"), rs.getString("pw"),
						rs.getString("name"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return list;
	}
}
