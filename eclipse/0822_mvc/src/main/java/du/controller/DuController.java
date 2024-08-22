package du.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import du.db.MemberDao;
import du.db.MemberDto;

@WebServlet("/")
public class DuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DuController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String view = null;

		// URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		System.out.println("uri     : " + uri);
		System.out.println("conPath : " + conPath);
		System.out.println("com     : " + com);

		if (com.equals("/")) {
			view = "main.jsp";
		}else if(com.equals("/loginForm")){
			view = "/sign-in/loginForm.jsp";
		}else if(com.equals("/login")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			MemberDto memberDto = new MemberDto(0,"",email,password,"");
			MemberDao memberDao = new MemberDao();
			int login = memberDao.isMember(memberDto);
			System.out.println("login : " + login);
			if(login == 1) {
				memberDto = memberDao.findMember(memberDto);
				HttpSession session = request.getSession();
				session.setAttribute("customInfo", memberDto);
				request.setAttribute("userLoggedIn", true);
				System.out.println("로그인 성공");
			}else {
				System.out.println("로그인 실패");
			}
			view = "main.jsp";
		}

		// view에 담긴 문자열에 따라 포워딩 또는 리다이렉팅
		if (view.startsWith("redirect:")) {
			response.sendRedirect(view.substring(9));
		} else {
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
