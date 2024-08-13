package home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;
import shop.Product;
import util.JDBCUtil;

public class AccountDAO {

	// SqlSessionFactory를 SqlMapConfig를 통하여 생성한다.
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;

	public AccountDAO() {
		// SqlSessionFactory에서 session을 할당받는다.
		// 이 때 openSession에 true를 주어야 자동 커밋이 된다.
		// default는 false이다.
		session = sqlsession_f.openSession(true);
	}

	public List<Account> getAllProducts() {
		// session을 통해 쿼리를 실행하고 값을 받아온다.
		return session.selectList("ProductMapper.selectAllProducts");
	}

	public void addProduct(Account account) {
		session.insert("ProductMapper.insertProduct", account);
	}

	public Account getProductById(int id) {
		return session.selectOne("ProductMapper.selectProductById", id);
	}

	public void updateProduct(Account account) {
		session.update("ProductMapper.updateProduct", account);
	}

	public void deleteProduct(int id) {
		session.delete("ProductMapper.deleteProduct", id);
	}


	// JDBC 관련 변수 
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private String ACCOUNT_LIST = "select * from test_account order by num";
	private String ACCOUNT_ONE = "select * from test_account where id = ? and pw = ?";
	private String ACCOUNT_INSERT = "insert into test_account (id, pw, name, tel) values (?, ?, ?, ?)";
	private String ACCOUNT_UPDATE = "update test_account set pw = ?, name = ?, tel = ? where id = ?";
	private String ACCOUNT_CHECK = "select count(*) from test_account where id = ?";
	private String ACCOUNT_DELETE = "delete from test_account where num = ?";

	// 목록 삭제
	public void getDelete(Account dto) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(ACCOUNT_DELETE);
			stmt.setInt(1, dto.getNum());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}	

	//맴버 하나 조회
	public Account getAccountOne(String id, String pw) {
		Account dto = null;

		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(ACCOUNT_ONE);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			rs = stmt.executeQuery();
			while (rs.next()) {
				dto = new Account(rs.getInt("num"), rs.getString("id"), rs.getString("pw"),
						rs.getString("name"),rs.getString("tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return dto;
	}		

	// 회원 확인
	public boolean getCheck(String id, String pw) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(ACCOUNT_CHECK);
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
	public void insertAccount(Account dto) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(ACCOUNT_INSERT);
			stmt.setString(1, dto.getId());
			stmt.setString(2, dto.getPw());
			stmt.setString(3, dto.getName());
			stmt.setString(4, dto.getTel());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 정보 수정
	public void updateAccount(Account dto) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(ACCOUNT_UPDATE);
			stmt.setString(1, dto.getPw());
			stmt.setString(2, dto.getName());
			stmt.setString(3, dto.getTel());
			stmt.setString(4, dto.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	//회원 전체 목록 조회
	public List<Account> getAccountList() {
		List<Account> list = new ArrayList<>();

		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(ACCOUNT_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Account dto = new Account(rs.getInt("num"), rs.getString("id"), rs.getString("pw"),
						rs.getString("name"),rs.getString("tel"));
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