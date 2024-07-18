package project2Swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	JButton jb6 = new JButton("종료");
	JTextArea ta = new JTextArea();
	List<Member> list;
	Member member; // 로그인 된 현재 사용자
	
	public MyFrame() {
		
		try (FileInputStream fis = new FileInputStream("c:\\_dev\\eclipse\\JAVA0716\\src\\project2Swing\\members.dat");
	             ObjectInputStream ois = new ObjectInputStream(fis)) {
			Member[] list2 = (Member[]) ois.readObject();
			list = new ArrayList<>(Arrays.asList(list2));   // 배열을 ArrayList로
			System.out.println("파일에서 객체를 가져왔습니다.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		for (Member member : list) {
			System.out.println(member);
		}
		System.out.println("총회원수:"+list.size());
		
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
		
		// 로그인 버튼
		jb1.setLocation(20,  350);
		jb1.setSize(100, 30);
		con.add(jb1);
		jb1.addActionListener(new LoginListener());
		
		// 회원가입 버튼
		jb2.setLocation(140,  350);
		jb2.setSize(100, 30);
		con.add(jb2);
		
		// 예금
		jb3.setLocation(260,  350);
		jb3.setSize(100, 30);
		con.add(jb3);
		
		// 출금
		jb4.setLocation(380,  350);
		jb4.setSize(100, 30);
		con.add(jb4);
		
		// 잔고
		jb5.setLocation(500,  350);
		jb5.setSize(100, 30);
		con.add(jb5);
		
		// 종료
		jb6.setLocation(620,  350);
		jb6.setSize(100, 30);
		con.add(jb6);
		
		this.setTitle("안녕 스윙");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(700,  300);
		this.setSize(900, 500);
		this.setVisible(true);
	}

	// 로그인
	class LoginListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = jt1.getText(); // 비밀번호
			String strPassword = jt2.getText();//패스워드
			String phone = jt3.getText();	// 전화번호
			
			// 로그인
			for (Member member2 : list) {
				if (member2.getName().equals(name) && member2.getSsn().equals(strPassword)) {
					member = member2;
					ta.setText("로그인 성공 \n"+member.toString());
					jt1.setText("");
					jt2.setText("");
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new MyFrame();

	}

}
