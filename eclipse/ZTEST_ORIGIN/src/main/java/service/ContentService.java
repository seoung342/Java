package service;

import java.util.List;

import home.Content;
import home.ContentDAO;

public class ContentService {
	private ContentDAO contentDAO;

    public ContentService() {
        contentDAO = new ContentDAO();
    }

    public List<Content> getAllContents() {
        return contentDAO.getAllContent();
    }

    public Content getContentByNum(int num) {
        return contentDAO.getContentByNum(num);
    }

    public void insertContent(Content content) {
        contentDAO.insertContent(content);
    }

    public void updateContent(Content content) {
        contentDAO.updateContent(content);
    }

    public void updateHits(int num, int hits) {
        contentDAO.updateHits(num, hits);
    }

    public void deleteContent(int num) {
        contentDAO.deleteContent(num);
    }
    
    public void deleteContentByUser(String user_id) {
        contentDAO.deleteContentByUser(user_id);
    }
}
