package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import home.Account;
import service.AccountService;

public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountService accountService;
	
    public AccountController() {
        super();
        accountService = new AccountService();
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
        if (com.equals("/HOMEPAGE/login")) {
        	view= "login.jsp";
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
		if(action.equals("login")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			Account account = accountService.getAccountByNum(new Account(id,pw));
			boolean flag = accountService.getAccountCheck(id);
			if (flag) {
				HttpSession session = request.getSession();
				session.setAttribute("num", account.getNum());
				session.setAttribute("id", id);
			    session.setAttribute("pw", pw);
			    session.setAttribute("name", account.getName());
			    session.setAttribute("tel", account.getTel());
			    response.sendRedirect("main.jsp");
		    }else {
		    	response.sendRedirect("login.jsp");
		    }
	    }else {
			doGet(request, response);
		}
	}

}
