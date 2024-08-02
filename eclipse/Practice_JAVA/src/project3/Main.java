package project3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame {

	public Main() {
		// 컨테이너 설정
		OptionContainer();
		
	}
	
	// 컨테이너 설정 메소드
	private void OptionContainer() {
			
		Container con = this.getContentPane(); // 프레임의 컨텐트 팬을 가져옴
		con.setLayout(new BorderLayout()); // 프레임의 레이아웃을 BorderLayout으로 설정

		this.setTitle("월급 분배"); // 프레임 제목 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 동작 설정
		this.setLocation(700,  300); // 프레임의 위치 설정
		this.setSize(800, 600); // 프레임의 크기 설정
		this.setVisible(true); // 프레임을 화면에 표시
		}
	
	public static void main(String[] args) {
		new Main();

	}

}
