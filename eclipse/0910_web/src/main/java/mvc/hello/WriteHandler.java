package mvc.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDto;
import board.BoardService;
import mvc.command.CommandHandler;

public class WriteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse res) {
		String tmp = request.getParameter("num");
        int num = (tmp != null && tmp.length() > 0)
                ? Integer.parseInt(tmp) : 0;

        BoardDto dto = new BoardDto();
        String action = "insert";

        if (num > 0) {
            dto = new BoardService().getMsgForWrite(num);
            action = "update?num=" + num;
        }

        request.setAttribute("msg", dto);
        request.setAttribute("action", action);
		return "/WEB-INF/view/write.jsp";
	}

}
