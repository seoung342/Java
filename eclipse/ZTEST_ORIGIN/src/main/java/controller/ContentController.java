package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.Content;
import service.ContentService;

public class ContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContentService contentService;
	
    public ContentController() {
        super();
        contentService = new ContentService();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String view = null;
		
		// URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
        String uri = request.getRequestURI();
        String conPath = request.getContextPath();
        String com = uri.substring(conPath.length());
        System.out.println(uri);
        System.out.println(conPath);
        System.out.println(com);
        
        // 주어진 URL에 따라 지정된 동작 수행
        if (com.equals("/HOMEPAGE/content")) {
        	List<Content> content = contentService.getAllContents();
            request.setAttribute("content", content);
            view = "content.jsp";
        }else if(com.equals("/HOMEPAGE/content_view")) {
			int num = Integer.parseInt(request.getParameter("num"));
			Content content = contentService.getContentByNum(num);
			contentService.updateHits(num, content.getHits()+1);
			request.setAttribute("content", content);
			view = "content_view.jsp";			
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
            String user_id = request.getParameter("user_id");
            Content newContent = new Content(0,writer,title,content,"0",0,user_id);
            contentService.insertContent(newContent);
            response.sendRedirect(request.getContextPath() + "/HOMEPAGE/content");
		}else if (action.equals("update")) {
			int num = Integer.parseInt(request.getParameter("num"));
            String newTitle = request.getParameter("title");
            String newContent = request.getParameter("content");
            String user_id = request.getParameter("user_id");
            Content updatedContent = new Content(num, null, newTitle, newContent, null, 0,user_id);
            contentService.updateContent(updatedContent);
            response.sendRedirect(request.getContextPath() + "/HOMEPAGE/content_view?num=" + num);
		}else if(action.equals("delete")) {
			 int delNum = Integer.parseInt(request.getParameter("num"));
             contentService.deleteContent(delNum);
             response.sendRedirect(request.getContextPath() + "/HOMEPAGE/content");
		}else if(action.equals("fix")) {
	        int num = Integer.parseInt(request.getParameter("num"));
	        Content content = contentService.getContentByNum(num);
	        request.setAttribute("content", content);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("content_fix.jsp?num=" + num);
	        dispatcher.forward(request, response);
	    }else {
			doGet(request, response);
		}
	}

}