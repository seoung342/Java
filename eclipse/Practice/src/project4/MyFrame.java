package project4;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	JLabel la1 = new JLabel("아이디");
	JLabel la2 = new JLabel("ssn");
	JLabel la3 = new JLabel("전화번호");
	JTextField tf1 = new JTextField(5);
	JTextField tf2 = new JTextField(5);
	JTextField tf3 = new JTextField(10);
	JTextArea ta = new JTextArea(20,50);
	JButton jb1 = new JButton("로그인");
	JButton jb2 = new JButton("회원가입");
	JButton jb3 = new JButton("예금");
	JButton jb4 = new JButton("출금");
	JButton jb5 = new JButton("잔고 확인");
	JButton jb6 = new JButton("종료");
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	List<Member> list;
	Member member; // 로그인 된 현재 사용자
	
	MyFrame(){
		// GUI 모양
		OptionContainer();
		
		// 파일 불러오기
		LoadFile();
		
		// 버튼 클릭 이벤트
		ClickEvent();
		
	}
	// swing 모양 설정
	private void OptionContainer() {
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add(jp1, BorderLayout.NORTH);
		con.add(jp2, BorderLayout.CENTER);
		con.add(jp3, BorderLayout.SOUTH);
		
		jp1.setLayout(new FlowLayout());
		jp1.add(la1);jp1.add(tf1);jp1.add(la2);jp1.add(tf2);jp1.add(la3);jp1.add(tf3);
		
		
		jp2.setLayout(new FlowLayout());
		jp2.add(ta);
			
		jp3.setLayout(new FlowLayout());
		jp3.add(jb1);jp3.add(jb2);jp3.add(jb3);jp3.add(jb4);jp3.add(jb5);jp3.add(jb6);
		
		
		this.setBounds(800, 100, 600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	// 파일 불러오기
	public void LoadFile(){
		try (FileInputStream fis = new FileInputStream("c:\\_dev\\eclipse\\Practice\\src\\project4\\members.dat");
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
	}
	// 파일 저장
	public void SaveFile() {
		Member[] list2 = list.toArray(new Member[list.size()]); // ArrayList를 배열로
		try (FileOutputStream fos = new FileOutputStream("c:\\_dev\\eclipse\\Practice\\src\\project4\\members.dat");
	             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			 oos.writeObject(list2);
	         System.out.println("객체를 파일에 저장했습니다.");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 버튼 클릭 이벤트
	public void ClickEvent() {
		jb1.addActionListener(new LoginAction());	// 로그인 버튼
		jb2.addActionListener(new JoinAction());	// 회원가입 버튼
		jb3.addActionListener(new AddMoneyAction());// 예금 버튼
		jb4.addActionListener(new SubMoneyAction());// 출금 버튼
		jb5.addActionListener(new NowMoneyAction());// 잔고 확인 버튼
		jb6.addActionListener(new ExitAction());	// 종료 버튼
	}
	// 로그인 
	class LoginAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			StringBuilder sb = new StringBuilder();
			String name = tf1.getText();
			String strPassword = tf2.getText();
			for (Member member2 : list) {
				if (member2.getName().equals(name) && member2.getSsn().equals(strPassword)) {
					member = member2;
					
					sb.append("이름\t비밀번호\t전화번호\t잔고\n").append(member.getName()+"\t").append(member.getSsn()+"\t")
					.append(member.getPhone()+"\t").append(member.getBalance()+"\n");
					ta.setText(sb.toString());
					
					la1.setText("금액");
					tf1.setColumns(10);
					tf1.setHorizontalAlignment(JTextField.RIGHT);
					la2.setVisible(false);
					la3.setVisible(false);
					tf2.setVisible(false);
					tf3.setVisible(false);
					break;
				}else if(member2.getName().equals(name) && !member2.getSsn().equals(strPassword)){
					ta.setText("비밀 번호를 다시 입력하세요");
				}
				else if(!member2.getName().equals(name) && member2.getSsn().equals(strPassword)){
					ta.setText("아이디를 다시 입력하세요");
				}else {
					ta.setText("다시 로그인 하세요.");
				}
			}
			
			tf1.setText("");
			tf2.setText("");
			
		}
	}
	// 회원 가입
	class JoinAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			StringBuilder sb = new StringBuilder();
			String name = tf1.getText();
			String ssn = tf2.getText();
			String phone = tf3.getText();
			
			if(tf1.getText().isBlank()) {
				ta.setText("아이디를 입력하세요");
			}else if(tf2.getText().isBlank()) {
				ta.setText("비밀번호를 입력하세요");
			}else if(tf3.getText().isBlank()) {
				ta.setText("전화번호를 입력하세요");
			}else {
				list.add(new Member(name, ssn, phone));
				sb.append("< 회원 가입 성공 >\n").append(" 1. 이름 : "+name+"\n")
				.append(" 1. 주민번호 앞 6자리 : "+ssn+"\n").append(" 3. 전화번호 : "+phone+"\n");
				ta.setText(sb.toString());
				tf1.setText(null);
				tf2.setText(null);
				tf3.setText(null);
			}
		}
	}
	// 예금
	class AddMoneyAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!tf1.getText().isBlank()) {
				member.deposit(Integer.parseInt(tf1.getText()));
				ta.setText(tf1.getText()+"원을 예금했습니다.");
				tf1.setText(null);
			}
			
		}
	}
	// 출금
	class SubMoneyAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!tf1.getText().isBlank()) {
				member.withdraw(Integer.parseInt(tf1.getText()));
				ta.setText(tf1.getText()+"원을 출금했습니다.");
				tf1.setText(null);
			}
			
		}
	}
	// 잔고 확인
	class NowMoneyAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			StringBuilder sb = new StringBuilder();
			sb.append("< 잔고 확인 >\n").append(" 잔고 : "+member.getBalance()+"\n");
			ta.setText(sb.toString());	
		}
	}
	// 종료
	class ExitAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			SaveFile();
			dispose();
		}
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
