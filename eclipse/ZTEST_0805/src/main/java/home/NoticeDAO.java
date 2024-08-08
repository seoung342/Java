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

public class NoticeDAO {
	// JDBC 관련 변수 
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private String NOTICE_LIST = "select * from test_notice order by num";
	private String NOTICE_ONE = "select * from test_notice where num = ?";
	private String NOTICE_INSERT = "insert into test_notice (writer, title, content, regtime, hits) values (?, ?, ?, ?, 0)";
	private String NOTICE_UPDATE = "update test_notice set writer = ?, title = ?, content = ?, regtime = ? where num = ?";
	private String NOTICE_UPDATE_HITS = "update test_notice set hits = ? where num = ?";
	private String NOTICE_DELETE = "delete from test_notice where num = ?";
	
	//게시판 전체 목록 조회
	public List<NoticeDTO> getNoticeList() {
		List<NoticeDTO> list = new ArrayList<>();
		
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(NOTICE_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				NoticeDTO dto = new NoticeDTO(rs.getInt("num"), rs.getString("writer"),
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
		public void insertNotice(NoticeDTO dto) {
			conn = JDBCUtil.getConnection();
			try {
				// 현재 시간 가져오기
		        LocalDateTime now = LocalDateTime.now();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		        String nowFormatted = now.format(formatter);
		        
				stmt = conn.prepareStatement(NOTICE_INSERT);
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
	public void getUpdate(NoticeDTO dto) {
		conn = JDBCUtil.getConnection();
		try {
			// 현재 시간 가져오기
	        LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String nowFormatted = now.format(formatter);
	        
			stmt = conn.prepareStatement(NOTICE_UPDATE);
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
		
	// 공지사항 조회
	public NoticeDTO getOne(int num) {
		NoticeDTO dto = null;
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(NOTICE_ONE);
			stmt.setInt(1, num);
			rs = stmt.executeQuery();
			while (rs.next()) {
				dto = new NoticeDTO(rs.getInt("num"), rs.getString("writer"),
						rs.getString("title"), rs.getString("content"),
						rs.getString("regtime"), rs.getInt("hits"));
			}
			stmt = conn.prepareStatement(NOTICE_UPDATE_HITS);
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
	public void getDelete(NoticeDTO dto) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(NOTICE_DELETE);
			stmt.setInt(1, dto.getNum());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
}