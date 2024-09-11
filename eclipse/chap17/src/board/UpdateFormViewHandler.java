package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;

public class UpdateFormViewHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		return "/WEB-INF/view/update_form_view.jsp";
	}

}
