package project1;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NewPage extends JFrame {
	JLabel lb1 = new JLabel("티커");
	JTextField jt1 = new JTextField();
	JLabel lb2 = new JLabel("가격");
	JTextField jt2 = new JTextField();
	JLabel lb3 = new JLabel("갯수");
	JTextField jt3 = new JTextField();
	JButton jb1 = new JButton("추가");
	JButton jb2 = new JButton("제거");
	JButton jb3 = new JButton("현황 보기");
	JButton jb4 = new JButton("종료");
	JTextArea ta = new JTextArea();
	Stock[] stock = new Stock[30];
	int x, total;
	
	public NewPage() {
		
		try(FileInputStream fis = new FileInputStream("c:\\_dev\\eclipse\\Practice\\src\\project1\\Stock.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			stock = (Stock[]) ois.readObject();
			System.out.println("파일에서 객체를 가져왔습니다.");
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
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
		
		// 추가 버튼
		jb1.setLocation(20,  350);
		jb1.setSize(100, 30);
		con.add(jb1);
		
		// 제거 버튼
		jb2.setLocation(140,  350);
		jb2.setSize(100, 30);
		con.add(jb2);
		
		// 현황 보기
		jb3.setLocation(260,  350);
		jb3.setSize(100, 30);
		con.add(jb3);
		
		// 종료
		jb4.setLocation(380,  350);
		jb4.setSize(100, 30);
		con.add(jb4);
		
		jb1.addActionListener(new AddListener());
		jb2.addActionListener(new SubListener());
		jb3.addActionListener(new ShowListener());
		jb4.addActionListener(new ExitListener());
		
		this.setTitle("안녕 스윙");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(700,  300);
		this.setSize(900, 500);
		this.setVisible(true);
	}
	class AddListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String ticker = jt1.getText(); // 비밀번호
			String price = jt2.getText();//패스워드
			String amount = jt3.getText();	// 전화번호
			
			for(int i =0; i < 30; i++) {
				if (stock[i] == null) {
			        stock[i] = new Stock();
			        x = i;
			        break;
			    }
			}
			stock[x].setTicker(ticker);
			stock[x].setAmount(Double.parseDouble(amount));
			stock[x].setPrice(Double.parseDouble(price));
			
			jt1.setText(null);
			jt2.setText(null);
			jt3.setText(null);
			
		}
	}
	
	class SubListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String ticker = jt1.getText(); 
			
			for(int i = 0; i < 30; i++) {
				if(stock[i].getTicker().equals(ticker)) {
					stock[i] = null;
					break;
				}
			}
			
			jt1.setText(null);
			
		}
	}
	
	class ShowListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			StringBuilder sb = new StringBuilder();
			sb.append("티커\t 가격\t 갯수\n");
			for(int i = 0; i < 30; i++) {
				if(stock[i] != null) {
					sb.append(stock[i].getTicker()).append("\t")
	                  .append(stock[i].getPrice()).append("\t")
	                  .append(stock[i].getAmount()).append("\n");
	                total += stock[i].getPrice() * stock[i].getAmount();
	            }
	        }
			sb.append("\n 총 매수 금액 : ").append(total).append("\n");
	        ta.setText(sb.toString());
		}
	}
	
	class ExitListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try(FileOutputStream fos = new FileOutputStream("c:\\_dev\\eclipse\\Practice\\src\\project1\\Stock.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos)){
				
				oos.writeObject(stock);
				System.out.println("객체를 파일에 저장했습니다.");
				dispose(); // 화면 종료
				
			}catch(IOException i) {
				i.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		new NewPage();
	}
}
