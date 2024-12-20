package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import home.Account;
import home.Finance;
import service.AccountService;
import service.FinanceService;

@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FinanceService financeService;
	private AccountService accountService;

	public Controller() {
		super();
		financeService = new FinanceService();
		accountService = new AccountService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		if (com.equals("/main") || com.equals("/")) { // 01_main.jsp
			view = "/Finance/01_main.jsp";
		} else if (com.equals("/login")) { // 02_login.jsp
			view = "/Finance/02_login.jsp";
		} else if (com.equals("/register")) {
			view = "/Finance/03_register.jsp";
		} else if (com.equals("/list")){
			List<Finance> finance = financeService.selectAllHiredate();
			request.setAttribute("list", finance);
			view = "/Finance/04_list.jsp";
		} 
		else if (com.equals("/day_money")) {
			view = "/Finance/day_money.jsp";
		} else if (com.equals("/balance")) {
			view = "/Finance/balance.jsp";
		} else if (com.equals("/ratio")) {
			view = "/Finance/ratio.jsp";
		} else if (com.equals("/logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			view = "/Finance/01_main.jsp";
		} else if (com.equals("/finance_chart")) { // 차트 보기
			List<Finance> finance = financeService.selectAllChart();

			// JSON 변환
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(finance);

			request.setAttribute("finance", json);
			view = "/Finance/finance_chart.jsp";
		} else {
			view = "error.jsp";
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
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action.equals("login")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			Account account = accountService.getAccountOne(new Account(id, pw));
			boolean flag = accountService.getAccountCheck(id);
			if (flag) {
				HttpSession session = request.getSession();
				session.setAttribute("num", account.getNum());
				session.setAttribute("id", id);
				session.setAttribute("pw", pw);
				session.setAttribute("name", account.getName());
				session.setAttribute("tel", account.getTel());
				response.sendRedirect(request.getContextPath() + "/main");
			} else {
				response.sendRedirect(request.getContextPath() + "/login");
			}
		} else if (action.equals("registerProcess")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			Account account = new Account(0, id, pw, name, tel);
			boolean flag = accountService.getAccountCheck(id);
			if (flag) {
				response.sendRedirect(request.getContextPath() + "/register");
			} else {
				accountService.insertAccount(account);
				response.sendRedirect(request.getContextPath() + "/");
			}
		} else if (action.equals("listByHiredate")) {
			String hiredate = request.getParameter("hiredate");
	        List<Finance> finance = financeService.selectAllByHiredate(hiredate);
	        
	        ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(finance);
			
			response.setContentType("application/json; charset=UTF-8");
	        response.getWriter().write(objectMapper.writeValueAsString(json));
	        
		}
	}
		
}