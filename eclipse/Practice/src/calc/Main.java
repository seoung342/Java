package calc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame{
	
	JLabel la = new JLabel("계산기");
	JTextField jt = new JTextField(10);
	JButton[] jb = new JButton[20];
	JPanel[] jp = new JPanel[3];
	
	public Main() {
		// 컨테이너 설정
		OptionContainer2();
	}
	
	private void OptionContainer1() {
		Container con = this.getContentPane();
		con.setLayout(null);
		
		con.add(la);
		la.setLocation(207, -10);
		la.setSize(100, 100);
		
		con.add(jt);
		jt.setLocation(25, 70);
		jt.setSize(415, 30);
		
		// 버튼 생성
		for (int i =0; i<20; i++) {
			String num = String.valueOf(i);
			jb[i] = new JButton(num);
			System.out.println(jb[i].getText());
			con.add(jb[i]);
		}
		
		// 버튼 위치
		jb[0].setLocation(25,120); // ( x 좌표, y 좌표)
		jb[0].setSize(100,50);
		jb[1].setLocation(130,120); // ( x 좌표, y 좌표)
		jb[1].setSize(100,50);
		jb[2].setLocation(235,120); // ( x 좌표, y 좌표)
		jb[2].setSize(100,50);
		jb[3].setLocation(340,120); // ( x 좌표, y 좌표)
		jb[3].setSize(100,50);
		jb[4].setLocation(25,175); // ( x 좌표, y 좌표)
		jb[4].setSize(100,50);
		jb[5].setLocation(130,175); // ( x 좌표, y 좌표)
		jb[5].setSize(100,50);
		jb[6].setLocation(235,175); // ( x 좌표, y 좌표)
		jb[6].setSize(100,50);
		jb[7].setLocation(340,175); // ( x 좌표, y 좌표)
		jb[7].setSize(100,50);
		jb[8].setLocation(25,230); // ( x 좌표, y 좌표)
		jb[8].setSize(100,50);
		jb[9].setLocation(130,230); // ( x 좌표, y 좌표)
		jb[9].setSize(100,50);
		jb[10].setLocation(235,230); // ( x 좌표, y 좌표)
		jb[10].setSize(100,50);
		jb[11].setLocation(340,230); // ( x 좌표, y 좌표)
		jb[11].setSize(100,50);
		jb[12].setLocation(25,285); // ( x 좌표, y 좌표)
		jb[12].setSize(100,50);
		jb[13].setLocation(130,285); // ( x 좌표, y 좌표)
		jb[13].setSize(100,50);
		jb[14].setLocation(235,285); // ( x 좌표, y 좌표)
		jb[14].setSize(100,50);
		jb[15].setLocation(340,285); // ( x 좌표, y 좌표)
		jb[15].setSize(100,50);
		con.add(jb[16]);
		jb[16].setLocation(25,340); // ( x 좌표, y 좌표)
		jb[16].setSize(100,50);
		con.add(jb[17]);
		jb[17].setLocation(130,340); // ( x 좌표, y 좌표)
		jb[17].setSize(100,50);
		con.add(jb[18]);
		jb[18].setLocation(235,340); // ( x 좌표, y 좌표)
		jb[18].setSize(100,50);
		con.add(jb[19]);
		jb[19].setLocation(340,340); // ( x 좌표, y 좌표)
		jb[19].setSize(100,50);
		
		this.setTitle("안녕 스윙");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(700,  300);
		this.setSize(480, 450);
		this.setVisible(true);
		
	}
	
	private void OptionContainer2() {
		
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		
		for (int i = 0; i < 3; i++) {
			jp[i] = new JPanel();
			jp[i].setLayout(new FlowLayout());
		}
		
		jp[2].setLayout(new GridLayout(5,4,2,2));
		con.add(jp[0], BorderLayout.NORTH);
		con.add(jp[1], BorderLayout.CENTER);
		con.add(jp[2], BorderLayout.SOUTH);
		
		
		jp[0].add(la);
		jp[1].add(jt);
		
		for(int i = 0; i <20; i++) {
			String num = String.valueOf(i);
			jb[i] = new JButton(num);
			jp[2].add(jb[i]);
		}
		
		
		
		this.setTitle("안녕 스윙");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(700,  300);
		this.setSize(250, 300);
		this.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new Main();
	}
	
	
}
