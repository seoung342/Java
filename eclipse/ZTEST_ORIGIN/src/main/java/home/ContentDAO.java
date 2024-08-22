package home;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class ContentDAO {

	// SqlSessionFactory를 SqlMapConfig를 통하여 생성한다.
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;

	public ContentDAO() {
		// SqlSessionFactory에서 session을 할당받는다.
		// 이 때 openSession에 true를 주어야 자동 커밋이 된다.
		// default는 false이다.
		session = sqlsession_f.openSession(true);
	}

	public List<Content> getAllContent() {
		return session.selectList("ContentMapper.selectAllContent");
	}

	public void insertContent(Content content) {
		session.insert("ContentMapper.insertContent", content);
	}

	public Content getContentByNum(int num) {
		return session.selectOne("ContentMapper.selectContentOne", num);
	}

	public void updateContent(Content content) {
		session.update("ContentMapper.updateContent", content);
	}

	public void updateHits(int num, int hits) {
		Content content = new Content();
		content.setNum(num);
		content.setHits(hits);
		session.update("ContentMapper.updateHits", content);
	}

	public void deleteContent(int num) {
		session.delete("ContentMapper.deleteContent", num);
	}
	
	public void deleteContentByUser(String user_id) {
		session.delete("ContentMapper.deleteContentByUser",user_id);
	}


}
