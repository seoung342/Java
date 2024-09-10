package mvc.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class ErrorBackHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("error", "오류 발생");
		return "/WEB-INF/view/errorBack.jsp";
	}

}
