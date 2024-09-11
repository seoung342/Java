package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;
import mvjsp.chap17.board.service.DeleteArticleService;
import mvjsp.chap17.board.service.DeleteRequest;

public class DeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) {
		
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		String password = request.getParameter("password");
		
		DeleteRequest deleteRequest = new DeleteRequest(articleId, password);
		
		String viewPage = null;
		try {
			DeleteArticleService.getInstance().deleteArticle(deleteRequest);
			viewPage = "/WEB-INF/view/delete_success.jsp";
		} catch (Exception ex) {
			request.setAttribute("deleteException", ex);
			viewPage = "/WEB-INF/view/delete_error.jsp";
		}
		
		return viewPage;
	}

}
