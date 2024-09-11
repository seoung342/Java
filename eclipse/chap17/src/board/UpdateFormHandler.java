package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;
import mvjsp.chap17.board.model.Article;
import mvjsp.chap17.board.service.ArticleNotFoundException;
import mvjsp.chap17.board.service.ReadArticleService;

public class UpdateFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) {
		
		String viewPage = null;
		try {
			int articleId = Integer.parseInt(request.getParameter("articleId"));
			Article article = ReadArticleService.getInsteance().getArticle(articleId);
			viewPage = "/WEB-INF/view/update_form_view.jsp";
			request.setAttribute("article", article);
		} catch (ArticleNotFoundException ex) {
			viewPage = "/WEB-INF/view/article_not_found.jsp";
		}
		
		return viewPage;
	}

}
