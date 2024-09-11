package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;
import mvjsp.chap17.board.model.Article;
import mvjsp.chap17.board.service.ReplyArticleService;
import mvjsp.chap17.board.service.ReplyingRequest;

public class ReplyHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) {
		
		String name = request.getParameter("writerName");
		String title = request.getParameter("title");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		int parentId = Integer.parseInt(request.getParameter("parentArticleId"));
		
		ReplyingRequest replyingRequest = new ReplyingRequest(parentId, name, password, title, content);
		
		String viewPage = null;
		try {
			Article postedArticle = ReplyArticleService.getInstance().
					reply(replyingRequest);
			request.setAttribute("postedArticle", postedArticle);
			viewPage = "/WEB-INF/view/reply_success.jsp";
		} catch(Exception ex) {
			viewPage = "/WEB-INF/view/reply_error.jsp";
			request.setAttribute("replyException", ex);
		}
		return viewPage;
	}

}
