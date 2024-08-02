package driver;

import board.BoardDAO;
import board.BoardDTO;

public class Ex01 {

	public static void main(String[] args) {
		BoardDTO dto = new BoardDTO(1, "최하나", "나나나나", "가가가", null, 0);
		BoardDAO dao = new BoardDAO();
		dao.updateBoard(dto);

	}

}
