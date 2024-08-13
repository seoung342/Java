package home;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class NoticeDAO {

	// SqlSessionFactory를 SqlMapConfig를 통하여 생성한다.
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;

	public NoticeDAO() {
		// SqlSessionFactory에서 session을 할당받는다.
		// 이 때 openSession에 true를 주어야 자동 커밋이 된다.
		// default는 false이다.
		session = sqlsession_f.openSession(true);
	}

	public List<Notice> getAllNotice() {
		return session.selectList("NoticeMapper.selectAllNotice");
	}

	public void insertNotice(Notice notice) {
		session.insert("NoticeMapper.insertNotice", notice);
	}

	public Notice getNoticeByNum(int num) {
		return session.selectOne("NoticeMapper.selectNoticeOne", num);
	}

	public void updateNotice(Notice notice) {
		session.update("NoticeMapper.updateNotice", notice);
	}
	
	public void updateHits(int num, int hits) {
		Notice notice = new Notice();
        notice.setNum(num);
        notice.setHits(hits);
		session.update("NoticeMapper.updateHits", notice);
	}

	public void deleteNotice(int num) {
		session.delete("NoticeMapper.deleteNotice", num);
	}


}