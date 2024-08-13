package webhard;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class WebhardDAO {
	// SqlSessionFactory를 SqlMapConfig를 통하여 생성한다.
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;

	public WebhardDAO() {
		// SqlSessionFactory에서 session을 할당받는다.
		// 이 때 openSession에 true를 주어야 자동 커밋이 된다.
		// default는 false이다.
		session = sqlsession_f.openSession(true);
	}

	public List<Webhard> getAllWebhard() {
		// session을 통해 쿼리를 실행하고 값을 받아온다.
		return session.selectList("WebhardMapper.selectAllWebhard");
	}
	
	public Webhard selectWebhardByNum(int num) {
		return session.selectOne("WebhardMapper.selectWebhardByNum",num);
	}

	public void insertWebhard(Webhard webhard) {
		session.insert("WebhardMapper.insertWebhard", webhard);
	}
	public void deleteWebhard(int num) {
		session.delete("WebhardMapper.deleteWebhard", num);
	}
}