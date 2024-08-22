package service;

import java.util.List;

import home.FileStorage;
import home.FileStorageDAO;

public class FileStorageService {
	private FileStorageDAO fileStroageDAO;
	
	public FileStorageService() {
		fileStroageDAO = new FileStorageDAO();
	}
	
	public List<FileStorage> getAllFileStorage() {
        return fileStroageDAO.selectAllFileStorage();
    }

    public FileStorage getFileStorageByNum(String num) {
        return fileStroageDAO.selectFileStorageOne(num);
    }
    
    public boolean getFileStorageCheck(String num) {
    	return fileStroageDAO.selectFileStorageCheck(num);
    }

    public void insertFileStorage(FileStorage fileStorage) {
    	fileStroageDAO.insertFileStorage(fileStorage);
    }

    public void updateFileStorage(FileStorage fileStorage) {
    	fileStroageDAO.updateFileStorage(fileStorage);
    }
    
    public void updateHits(String num, int hits) {
    	fileStroageDAO.updateHits(num, hits);
    }

    public void deleteFileStorage(String num) {
    	fileStroageDAO.deleteFileStorage(num);
    }
    
    public void deleteFileStorageByUser(String user_id) {
    	fileStroageDAO.deleteFileStorageByUser(user_id);
    }
}