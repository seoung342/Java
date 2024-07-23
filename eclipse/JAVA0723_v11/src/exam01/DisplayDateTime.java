package exam01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DisplayDateTime extends JFrame{
	JTextField tf = new JTextField(20);
	JButton bt = new JButton("조회");
	JTextArea ta = new JTextArea(17, 40);
	JLabel jl = new JLabel();
	Connection conn;
	Statement stmt;
	JFrame jf;
	
	DisplayDateTime(){
		Time time = new Time();
		time.start();
		
		jf = this;
		StartDB();
		Option();
				
		bt.addActionListener(new Execute() );
	}
	
	private void StartDB() {
		String url = "jdbc:mysql://localhost:3307/spring5fs";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "mysql");
            stmt = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
	}
	
	private void Option() {
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		JPanel jp1 = new JPanel(new FlowLayout());
		jp1.add(tf); jp1.add(bt);
		con.add(jp1, BorderLayout.NORTH);
		JPanel jp2 = new JPanel(new FlowLayout());
		jp2.add(ta);
		con.add(jp2, BorderLayout.CENTER);
		JPanel jp3 = new JPanel(new FlowLayout());
		jp3.add(jl);
		con.add(jp3, BorderLayout.SOUTH);
		
		this.setTitle("SQL 검색");
		this.setBounds(1200, 200, 500, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class Execute implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			StringBuilder sb = new StringBuilder();
	        String sql = tf.getText();
	        try {
	            ResultSet rs = stmt.executeQuery(sql);
	            ResultSetMetaData rsmd = rs.getMetaData();
	            int columnsNumber = rsmd.getColumnCount();
	            for(int i = 1; i<= columnsNumber; i++) {
            		sb.append(rsmd.getColumnName(i)+"\t");
            	}
	            sb.append("\n");
	           
	            while (rs.next()) {
	            	for (int i = 1; i <= columnsNumber; i++) { 
	                    sb.append(rs.getString(i)+"\t");
	                }
	            	sb.append("\n");
	                ta.setText(sb.toString());
	            }
	        } catch (SQLException e1) {
	        	JOptionPane.showMessageDialog(jf, "쿼리문을 다시 입력하세요","정보",JOptionPane.INFORMATION_MESSAGE);
	            e1.printStackTrace();
	        }
		}
	}
	
	public class Time extends Thread{
		@Override
		public void run() {
			for(;;) {
				LocalTime localTime = LocalTime.now();
				String str = String.valueOf(localTime.getHour())+":"+String.valueOf(localTime.getMinute())+":"+String.valueOf(localTime.getSecond());
				DisplayDateTime.this.jl.setText(str);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	
	public static void main(String[] args) {
		new DisplayDateTime();
	}
}
