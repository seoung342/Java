package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.Notice;
import service.NoticeService;


@WebServlet("/HOMEPAGE/notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;
	
    public NoticeController() {
        super();
        noticeService = new NoticeService();
    }//response.getWriter().append("Served at: ").append(request.getContextPath());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		
		// URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
        String uri = request.getRequestURI();
        String conPath = request.getContextPath();
        String com = uri.substring(conPath.length());
        System.out.println(uri);
        System.out.println(conPath);
        System.out.println(com);
        
     // 주어진 URL에 따라 지정된 동작 수행
        if (com.equals("/HOMEPAGE/notice")) {
        	 List<Notice> notices = noticeService.getAllNotices();
             request.setAttribute("notices", notices);
            view = "notice.jsp";
        }else {
        	 view = "error.jsp";
        }
     // view에 담긴 문자열에 따라 포워딩 또는 리다이렉팅
        if (view.startsWith("redirect:")) {
            response.sendRedirect(view.substring(9));
        } else {
            request.getRequestDispatcher(view).forward(request, response);
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if(action.equals("insert")) {
			String writer = request.getParameter("writer");
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            Notice newNotice = new Notice(0, writer, title, content, "0", 0);
            noticeService.insertNotice(newNotice);
            response.sendRedirect("notice");
		}else if (action.equals("update")) {
			int num = Integer.parseInt(request.getParameter("num"));
            String newTitle = request.getParameter("title");
            String newContent = request.getParameter("content");
            Notice updatedNotice = new Notice(num, null, newTitle, newContent, null, 0);
            noticeService.updateNotice(updatedNotice);
            response.sendRedirect("notice_view.jsp?num=" + num);
		}else if(action.equals("delete")) {
			 int delNum = Integer.parseInt(request.getParameter("num"));
             noticeService.deleteNotice(delNum);
             response.sendRedirect("notice");
		}else if(action.equals("fix")) {
			int num = Integer.parseInt(request.getParameter("num"));
			
			response.sendRedirect("notice_view.jsp?num=" + num);
		}else {
			doGet(request, response);
		}
	}

}
