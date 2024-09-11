package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;
import mvjsp.chap17.board.model.Article;
import mvjsp.chap17.board.service.IdGenerationFailedException;
import mvjsp.chap17.board.service.WriteArticleService;
import mvjsp.chap17.board.service.WritingRequest;

public class WriteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) {
		
		String name = request.getParameter("writerName");
		String title = request.getParameter("title");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		
		WritingRequest writeRequest = new WritingRequest(name, password, title, content);
	
		Article postedArticle;
		try {
			postedArticle = WriteArticleService.getInstance().write(writeRequest);
			request.setAttribute("postedArticle", postedArticle);
		} catch (IdGenerationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return "/WEB-INF/view/write.jsp";
	}

}
