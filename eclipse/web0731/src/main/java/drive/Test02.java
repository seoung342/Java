package drive;

import java.util.List;

import board.BoardDAO;
import board.BoardDTO;

public class Test02 {

	public static void main(String[] args) {
		// select 
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO(0, "홍수박", "끝?>??>", "아직 많이 남았다", "", 0);
		dao.insertBoard(dto);
		System.out.println("입력 성공");
	}
}

