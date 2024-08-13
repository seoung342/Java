package home;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

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

	public List<Account> selectAllAccount() {
		return session.selectList("AccountMapper.selectAllAccount");
	}
	
	public Account selectAccountOne(Account account) {
		return session.selectOne("AccountMapper.selectAccountOne",account);
	}
	
	public boolean selectAccountCheck(String id) {
		return session.selectOne("AccountMapper.selectAccountCheck", id);
	}
	
	public void insertAccount(Account account) {
		session.insert("AccountMapper.insertAccount", account);
	}
	
	public void updateAccount(Account account) {
		session.update("AccountMapper.updateAccount", account);
	}
	
	public void deleteAccount(String num) {
		session.delete("AccountMapper.deleteAccount", num);
	}
}