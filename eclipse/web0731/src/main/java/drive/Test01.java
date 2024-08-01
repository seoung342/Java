package drive;

import java.util.List;

import board.BoardDAO;
import board.BoardDTO;

public class Test01 {

	public static void main(String[] args) {
		// select 
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.getBoardList();
		for(BoardDTO dto : list) {
			System.out.println(dto);
		}
	}

}
