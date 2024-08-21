package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import home.Account;
import home.Content;
import home.Notice;
import service.AccountService;
import service.ContentService;
import service.NoticeService;

@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContentService contentService;
	private NoticeService noticeService;
	private AccountService accountService;
	
    public Controller() {
        super();
        contentService = new ContentService();
        noticeService = new NoticeService();
        accountService = new AccountService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String view = null;
		
		// URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
        String uri = request.getRequestURI();
        String conPath = request.getContextPath();
        String com = uri.substring(conPath.length());
        System.out.println("uri : " + uri);
        System.out.println("conPath : " + conPath);
        System.out.println("com : " + com);
        
        // 주어진 URL에 따라 지정된 동작 수행
        if (com.equals("/")) {
        	view= "/HOMEPAGE/main.jsp";
        }else if(com.equals("/main")) {
        	view="/HOMEPAGE/main.jsp";
        }
        else if (com.equals("/content")) {
        	List<Content> content = contentService.getAllContents();
            request.setAttribute("content", content);
            view = "/HOMEPAGE/content.jsp";
        }else if(com.equals("/content_view")) {
			int num = Integer.parseInt(request.getParameter("num"));
			Content content = contentService.getContentByNum(num);
			contentService.updateHits(num, content.getHits()+1);
			request.setAttribute("content", content);
			view = "/HOMEPAGE/content_view.jsp";			
		}else if(com.equals("/content_write")){
			view = "/HOMEPAGE/content_write.jsp";
		}else if (com.equals("/notice")) {
			List<Notice> notices = noticeService.getAllNotices();
			request.setAttribute("noticeList", notices);
			view = "/HOMEPAGE/notice.jsp";
		}else if(com.equals("/notice_view")) {
			int num = Integer.parseInt(request.getParameter("num"));
			Notice notice = noticeService.getNoticeByNum(num);
			noticeService.updateHits(num, notice.getHits()+1);
			request.setAttribute("notice", notice);
			view = "/HOMEPAGE/notice_view.jsp";			
		}else if(com.equals("/notice_write")) {
			view = "/HOMEPAGE/notice_write.jsp";			
		}else if(com.equals("/login")) {
        	view= "/HOMEPAGE/login.jsp";
        }else if(com.equals("/logout")) {
        	HttpSession session = request.getSession();
        	session.invalidate();
        	view = "/HOMEPAGE/main.jsp";
        }else if(com.equals("/location")) {
        	view = "/HOMEPAGE/location.jsp";
        }else if(com.equals("/register_modify")) {
        	List<Account> list = accountService.getAllAccount();
        	request.setAttribute("accountList", list);
        	view = "/HOMEPAGE/register_modify.jsp";
        }else if(com.equals("/register")) {
        	view = "/HOMEPAGE/register.jsp";
        }else if(com.equals("/myinfo")) {
        	view = "/HOMEPAGE/myinfo.jsp";
        }
		
		else {
        	view = "error.jsp";
        }
        
        // view에 담긴 문자열에 따라 포워딩 또는 리다이렉팅
        if (view.startsWith("redirect:")) {
            response.sendRedirect(view.substring(9));
        } else {
            request.getRequestDispatcher(view).forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if(action.equals("content_insert")) {
			String writer = request.getParameter("writer");
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String user_id = request.getParameter("user_id");
            Content newContent = new Content(0,writer,title,content,"0",0,user_id);
            contentService.insertContent(newContent);
            response.sendRedirect(request.getContextPath() + "/content");
		}else if (action.equals("content_update")) {
			int num = Integer.parseInt(request.getParameter("num"));
            String newTitle = request.getParameter("title");
            String newContent = request.getParameter("content");
            String user_id = request.getParameter("user_id");
            Content updatedContent = new Content(num, null, newTitle, newContent, null, 0,user_id);
            contentService.updateContent(updatedContent);
            response.sendRedirect(request.getContextPath() + "/content_view?num=" + num);
		}else if(action.equals("content_delete")) {
			 int delNum = Integer.parseInt(request.getParameter("num"));
             contentService.deleteContent(delNum);
             response.sendRedirect(request.getContextPath() + "/content");
		}else if(action.equals("content_fix")) {
	        int num = Integer.parseInt(request.getParameter("num"));
	        Content content = contentService.getContentByNum(num);
	        request.setAttribute("content", content);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/HOMEPAGE/content_fix.jsp");
	        dispatcher.forward(request, response);
	    }else if(action.equals("notice_insert")) {
			String writer = request.getParameter("writer");
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            Notice newNotice = new Notice(0, writer, title, content, "0", 0);
            noticeService.insertNotice(newNotice);
            response.sendRedirect(request.getContextPath() + "/notice");
		}else if (action.equals("notice_update")) {
			int num = Integer.parseInt(request.getParameter("num"));
            String newTitle = request.getParameter("title");
            String newContent = request.getParameter("content");
            Notice updatedNotice = new Notice(num, null, newTitle, newContent, null, 0);
            noticeService.updateNotice(updatedNotice);
            response.sendRedirect(request.getContextPath() + "/notice_view?num=" + num);
		}else if(action.equals("notice_delete")) {
			 int delNum = Integer.parseInt(request.getParameter("num"));
             noticeService.deleteNotice(delNum);
             response.sendRedirect(request.getContextPath() + "/notice");
		}else if(action.equals("notice_fix")) {
	        int num = Integer.parseInt(request.getParameter("num"));
	        Notice notice = noticeService.getNoticeByNum(num);
	        request.setAttribute("notice", notice);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/HOMEPAGE/notice_fix.jsp");
	        dispatcher.forward(request, response);
	    }else if(action.equals("login")) {
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
			    response.sendRedirect(request.getContextPath() + "/");
		    }else {
		    	response.sendRedirect(request.getContextPath() + "/login");
		    }
	    }else if(action.equals("registerProcess")) {
	    	String id = request.getParameter("id");
	    	String pw = request.getParameter("pw");
	    	String name = request.getParameter("name");
	    	String tel = request.getParameter("tel");
	    	Account account = new Account(0,id,pw,name,tel);
	    	boolean flag = accountService.getAccountCheck(id);
	    	if(flag) {
	    		response.sendRedirect(request.getContextPath() + "/register");
	    	}else {
	    		accountService.insertAccount(account);
	    		response.sendRedirect(request.getContextPath() + "/");
	    	}
	    }else if(action.equals("register_modify_delete")) {
	    	String num = request.getParameter("num");
	    	if(num != null) {
	    		accountService.deleteAccount(num);
	    		response.sendRedirect(request.getContextPath() + "/register_modify");
	    	}
	    }else if(action.equals("myinfoProcess")) {
	    	String id = request.getParameter("id");
	    	String pw = request.getParameter("pw");
	    	String name = request.getParameter("name");
	    	String tel = request.getParameter("tel");
	    	
	    	Account account = new Account(0, id, pw, name, tel);
	    	accountService.updateAccount(account);
	    	HttpSession session = request.getSession();
	    	session.setAttribute("num", account.getNum());
	    	session.setAttribute("id", id);
	        session.setAttribute("pw", pw);
	        session.setAttribute("name", account.getName());
	        session.setAttribute("tel", account.getTel());
	        response.sendRedirect(request.getContextPath() + "/main");	
	    }
	    
	    
	    
	    
	    
	    
	    else {
			doGet(request, response);
		}
	}

}