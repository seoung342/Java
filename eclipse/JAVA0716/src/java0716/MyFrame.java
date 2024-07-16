package java0716;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	JLabel lb1 = new JLabel("아이디");
	JTextField jt1 = new JTextField();
	JLabel lb2 = new JLabel("비밀번호");
	JTextField jt2 = new JTextField();
	JLabel lb3 = new JLabel("전화번호");
	JTextField jt3 = new JTextField();
	JButton jb1 = new JButton("로그인");
	JButton jb2 = new JButton("회원가입");
	JButton jb3 = new JButton("예금");
	JButton jb4 = new JButton("출금");
	JButton jb5 = new JButton("잔고");
	JTextArea ta = new JTextArea();
	
	public MyFrame() {
		Container con = this.getContentPane();
		con.setLayout(null);
		
		con.add(lb1);
		lb1.setLocation(20, 50);
		lb1.setSize(100, 30);
		
		con.add(jt1);
		jt1.setLocation(80, 50);
		jt1.setSize(100, 30);
		
		con.add(lb2);
		lb2.setLocation(220, 50);
		lb2.setSize(100, 30);
		
		con.add(jt2);
		jt2.setLocation(280, 50);
		jt2.setSize(100, 30);
		
		con.add(lb3);
		lb3.setLocation(420, 50);
		lb3.setSize(100, 30);
		
		con.add(jt3);
		jt3.setLocation(480, 50);
		jt3.setSize(100, 30);
		
		con.add(ta);
		ta.setLocation(20,  120);
		ta.setSize(830, 200);
		
		jb1.setLocation(20,  350);
		jb1.setSize(100, 30);
		con.add(jb1);
		jb1.addActionListener(new MyListener());
		
		jb2.setLocation(150,  350);
		jb2.setSize(100, 30);
		con.add(jb2);
		
		jb3.setLocation(280,  350);
		jb3.setSize(100, 30);
		con.add(jb3);
		
		jb4.setLocation(410,  350);
		jb4.setSize(100, 30);
		con.add(jb4);
		
		jb5.setLocation(540,  350);
		jb5.setSize(100, 30);
		con.add(jb5);
		
		this.setTitle("안녕 스윙");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(700,  300);
		this.setSize(900, 500);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame();

	}

}
