package java0716;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	JButton jb = new JButton("테스트");
	public MyFrame() {
		Container con = this.getContentPane();
		con.setLayout(null);
		con.add(jb);
		jb.setLocation(200,  300);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료
		this.setTitle("안녕 스윙"); // 제목
		this.setLocation(500, 500); // 창 위치
		this.setSize(300, 300); // 창 크기
		this.setVisible(true);	// 생성
	}
	
	public static void main(String[] args) {
		new MyFrame();

	}

}
