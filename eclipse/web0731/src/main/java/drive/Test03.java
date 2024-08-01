package drive;

import board.BoardDAO;

public class Test03 {

	public static void main(String[] args) {
		// select 
		BoardDAO dao = new BoardDAO();
		System.out.println(dao.getOne(1));
	}
}

