package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;
import mvjsp.chap17.board.model.Article;
import mvjsp.chap17.board.service.UpdateArticleService;
import mvjsp.chap17.board.service.UpdateRequest;

public class UpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) {
		
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		String title = request.getParameter("title");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		
		UpdateRequest updateRequest = new UpdateRequest(articleId,title, password, content);
		
		String viewPage = null;
		try {
			Article article = UpdateArticleService.getInstance().
					update(updateRequest);
			request.setAttribute("updatedArticle", article);
			viewPage = "/WEB-INF/view/update_success.jsp";
		} catch (Exception ex) {
			request.setAttribute("updateException", ex);
			viewPage = "/WEB-INF/view/update_error.jsp";
		}
		
		return viewPage;
	}

}
