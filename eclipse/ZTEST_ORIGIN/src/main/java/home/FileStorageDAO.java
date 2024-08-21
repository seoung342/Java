package home;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class FileStorageDAO {
	// SqlSessionFactory를 SqlMapConfig를 통하여 생성한다.
	SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
	SqlSession session;

	public FileStorageDAO() {
		// SqlSessionFactory에서 session을 할당받는다.
		// 이 때 openSession에 true를 주어야 자동 커밋이 된다.
		// default는 false이다.
		session = sqlsession_f.openSession(true);
	}

	public List<FileStorage> selectAllFileStorage() {
		return session.selectList("FileStorageMapper.selectAllFileStorage");
	}

	public FileStorage selectFileStorageOne(String num) {
		return session.selectOne("FileStorageMapper.selectFileStorageOne", num);
	}

	public boolean selectFileStorageCheck(String num) {
		return session.selectOne("FileStorageMapper.selectFileStorageCheck", num);
	}

	public void insertFileStorage(FileStorage fileStorage) {
		session.insert("FileStorageMapper.insertFileStorage", fileStorage);
	}

	public void updateFileStorage(FileStorage fileStorage) {
		session.update("FileStorageMapper.updateFileStorage", fileStorage);
	}
	
	public void updateHits(String num, int hits) {
		FileStorage fileStorage = new FileStorage();
        fileStorage.setNum(Integer.parseInt(num));
        fileStorage.setHits(hits);
		session.update("FileStorageMapper.updateHits", fileStorage);
	}

	public void deleteFileStorage(String num) {
		session.delete("FileStorageMapper.deleteFileStorage", num);
	}
}
