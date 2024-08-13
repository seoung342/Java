package home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

public class ContentDAO {
	// JDBC 관련 변수 
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private String CONTENT_LIST = "select * from test_content order by num desc";
	private String CONTENT_ONE = "select * from test_content where num = ?";
	private String CONTENT_INSERT = "insert into test_content (writer, title, content, regtime, hits) values (?, ?, ?, ?, 0)";
	private String CONTENT_UPDATE = "update test_content set writer = ?, title = ?, content = ?, regtime = ? where num = ?";
	private String CONTENT_UPDATE_HITS = "update test_content set hits = ? where num = ?";
	private String CONTENT_DELETE = "delete from test_content where num = ?";

	
	//게시판 전체 목록 조회
	public List<ContentDTO> getContentList() {
		List<ContentDTO> list = new ArrayList<>();
		
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(CONTENT_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				ContentDTO dto = new ContentDTO(rs.getInt("num"), rs.getString("writer"),
						rs.getString("title"), rs.getString("content"),
						rs.getString("regtime"), rs.getInt("hits"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return list;
	}

	// 게시판 등록
		public void insertContent(ContentDTO dto) {
			conn = JDBCUtil.getConnection();
			try {
				// 현재 시간 가져오기
		        LocalDateTime now = LocalDateTime.now();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		        String nowFormatted = now.format(formatter);
		        
				stmt = conn.prepareStatement(CONTENT_INSERT);
				stmt.setString(1, dto.getWriter());
				stmt.setString(2, dto.getTitle());
				stmt.setString(3, dto.getContent());
				stmt.setString(4, nowFormatted);
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(stmt, conn);
			}
		}
	
	// 수정
	public void getUpdate(ContentDTO dto) {
		conn = JDBCUtil.getConnection();
		try {
			// 현재 시간 가져오기
	        LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String nowFormatted = now.format(formatter);
	        
			stmt = conn.prepareStatement(CONTENT_UPDATE);
			stmt.setString(1, dto.getWriter());
			stmt.setString(2, dto.getTitle());
			stmt.setString(3, dto.getContent());
			stmt.setString(4, nowFormatted);
			stmt.setInt(5, dto.getNum());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
		
	// 게시판 조회
	public ContentDTO getOne(int num) {
		ContentDTO dto = null;
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(CONTENT_ONE);
			stmt.setInt(1, num);
			rs = stmt.executeQuery();
			while (rs.next()) {
				dto = new ContentDTO(rs.getInt("num"), rs.getString("writer"),
						rs.getString("title"), rs.getString("content"),
						rs.getString("regtime"), rs.getInt("hits"));
			}
			stmt = conn.prepareStatement(CONTENT_UPDATE_HITS);
			stmt.setInt(1, dto.getHits()+1);
			stmt.setInt(2, dto.getNum());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return dto;
	}
	
	// 목록 삭제
	public void getDelete(ContentDTO dto) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(CONTENT_DELETE);
			stmt.setInt(1, dto.getNum());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}	
	
	
}
