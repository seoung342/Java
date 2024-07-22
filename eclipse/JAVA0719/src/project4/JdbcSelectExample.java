package project4;

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
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JdbcSelectExample extends JFrame {
	
	JLabel la = new JLabel("select문 입력");
	JTextField tf = new JTextField(35);
	JButton jb = new JButton("실행");
	JTextArea ta = new JTextArea(20,50);
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	
	JdbcSelectExample(){
		Option();
		jb.addActionListener(new Execute());
	}
	
	private void Option() {
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add(jp1, BorderLayout.NORTH);
		con.add(jp2, BorderLayout.CENTER);
		
		jp1.setLayout(new FlowLayout());
		jp1.add(la);jp1.add(tf);jp1.add(jb);
		
		jp2.setLayout(new FlowLayout());
		jp2.add(ta);
		
		this.setTitle("정보 확인");
		this.setBounds(800, 100, 700, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class Execute implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			StringBuilder sb = new StringBuilder();
	        String sql = tf.getText();

	        String url = "jdbc:mysql://localhost:3306/spring5fs";
	        String user = "root";
	        String password = "1234";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("MySQL JDBC driver loaded successfully.");

	            Connection conn = DriverManager.getConnection(url, user, password);
	            System.out.println("Connected to the MySQL server successfully.");

	            Statement stmt = conn.createStatement();
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

	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (ClassNotFoundException e1) {
	            System.out.println("MySQL JDBC Driver not found.");
	            e1.printStackTrace();
	        } catch (SQLException e2) {
	            System.out.println("Database connection or query execution failed.");
	            e2.printStackTrace();
	        }
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new JdbcSelectExample();

    }
}