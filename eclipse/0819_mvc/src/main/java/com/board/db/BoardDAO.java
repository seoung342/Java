package com.board.db;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BoardDAO {

	// SqlSessionFactory를 SqlMapConfig를 통하여 생성한다.
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;

	public BoardDAO() {
		// SqlSessionFactory에서 session을 할당받는다.
		// 이 때 openSession에 true를 주어야 자동 커밋이 된다.
		// default는 false이다.
		session = sqlsession_f.openSession(true);
	}
	
	

	public List<BoardDto> getAllProducts() {
		// session을 통해 쿼리를 실행하고 값을 받아온다.
		return session.selectList("BoardMapper.selectAllProducts");
	}

	public void addProduct(BoardDto board) {
		session.insert("BoardMapper.insertProduct", board);
	}

	public BoardDto selectOne(int id) {
		return session.selectOne("BoardMapper.selectProductById", id);
	}

	public void updateProduct(BoardDto board) {
		session.update("BoardMapper.updateProduct", board);
	}

	public boolean deleteProduct(int id) {
		try {
			session.update("BoardMapper.deleteProduct", id);
		} catch(Exception e) {
			System.out.println("여기!!!");
			//e.printStackTrace();
			return true;
		}
		return false;
		
	}
	
	public void decreaseStock(int id) {
		session.update("BoardMapper.decreaseStock", id);
	}
	
	public int countProducts(int id) {
		return session.selectOne("BoardMapper.countProducts", id);
	}
}