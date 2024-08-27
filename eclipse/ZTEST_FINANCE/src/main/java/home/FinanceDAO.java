package home;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class FinanceDAO {
	// SqlSessionFactory를 SqlMapConfig를 통하여 생성한다.
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;

	public FinanceDAO() {
		// SqlSessionFactory에서 session을 할당받는다.
		// 이 때 openSession에 true를 주어야 자동 커밋이 된다.
		// default는 false이다.
		session = sqlsession_f.openSession(true);
	}
	public List<Finance> selectAllChart() {
		return session.selectList("FinanceMapper.selectAllChart");
    }
	
	public List<Finance> selectAllHiredate(){
		return session.selectList("FinanceMapper.selectAllHiredate");
	}
	
}
