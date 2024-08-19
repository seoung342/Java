package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.Content;
import service.ContentService;

@WebServlet("/HOMEPAGE/content")
public class ContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContentService contentService;
	
    public ContentController() {
        super();
        contentService = new ContentService();
    }
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
        if (com.equals("/HOMEPAGE/content")) {
        	 List<Content> content = contentService.getAllContents();
             request.setAttribute("content", content);
            view = "content.jsp";
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

		doGet(request, response);
	}

}
