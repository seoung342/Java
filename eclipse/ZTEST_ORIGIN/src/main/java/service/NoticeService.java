package service;

import java.util.List;
import home.Notice;
import home.NoticeDAO;

public class NoticeService {
    private NoticeDAO noticeDAO;

    public NoticeService() {
        noticeDAO = new NoticeDAO(); // You might want to use dependency injection in a real application
    }

    public List<Notice> getAllNotices() {
        return noticeDAO.getAllNotice();
    }

    public Notice getNoticeByNum(int num) {
        return noticeDAO.getNoticeByNum(num);
    }

    public void insertNotice(Notice notice) {
        noticeDAO.insertNotice(notice);
    }

    public void updateNotice(Notice notice) {
        noticeDAO.updateNotice(notice);
    }

    public void updateHits(int num, int hits) {
        noticeDAO.updateHits(num, hits);
    }

    public void deleteNotice(int num) {
        noticeDAO.deleteNotice(num);
    }
}
