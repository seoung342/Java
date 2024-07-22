package project3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Problem3 extends JFrame {
	
	JLabel la = new JLabel("선택");
	JTextArea ta = new JTextArea(20,50);
	JButton jb1 = new JButton("Dept 정보");
	JButton jb2 = new JButton("Emp 정보");
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	
	Problem3(){
		Option();
		ClickEvent();
	}
	
	private void Option() {
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add(jp1, BorderLayout.NORTH);
		con.add(jp2, BorderLayout.CENTER);
		
		jp1.setLayout(new FlowLayout());
		jp1.add(la);jp1.add(jb1);jp1.add(jb2);
		
		jp2.setLayout(new FlowLayout());
		jp2.add(ta);
		
		this.setTitle("정보 확인");
		this.setBounds(800, 100, 700, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void ClickEvent() {
		jb1.addActionListener(new LoadDept());
		jb2.addActionListener(new LoadEmp());
	}
	
	class LoadDept implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			StringBuilder sb = new StringBuilder();
			sb.append("DEPTNO"+"\t"+"DNAME"+"\t"+"LOC"+"\n");
			String selectDept = "select * from dept";
			
			String URL = "jdbc:mysql://localhost:3306/spring5fs";
			Connection con = null;
			Statement stmt = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(URL, "spring5", "spring5");
				System.out.println("MySql 접속 성공!!");
				stmt = con.createStatement();

				ResultSet rs1 = stmt.executeQuery(selectDept);
				while(rs1.next()) {
					sb.append(rs1.getString(1)+ "\t").append(rs1.getString(2)+ "\t").append(rs1.getString(3)+ "\n");
				}
				ta.setText(sb.toString());
				
				
			}catch(ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	
	class LoadEmp implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			StringBuilder sb = new StringBuilder();
			sb.append("EMPO"+"\t"+"ENAME"+"\t"+"JOB"+"\t"+"MGR"+"\t"+"HIREDATE"+"\t"+"SAL"+"\t"+"COMM"+"\t"+"DEPTNO"+"\n");
			String selectEmp = "select * from emp";
			
			String URL = "jdbc:mysql://localhost:3306/spring5fs";
			Connection con = null;
			Statement stmt = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(URL, "spring5", "spring5");
				System.out.println("MySql 접속 성공!!");
				stmt = con.createStatement();

				ResultSet rs1 = stmt.executeQuery(selectEmp);
				while(rs1.next()) {
					sb.append(rs1.getString(1)+ "\t").append(rs1.getString(2)+ "\t").append(rs1.getString(3)+ "\t").append(rs1.getString(4)+ "\t")
					.append(rs1.getString(5)+ "\t").append(rs1.getString(6)+ "\t").append(rs1.getString(7)+ "\t").append(rs1.getString(8)+ "\n");
				}
				ta.setText(sb.toString());
				
				
			}catch(ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		new Problem3();
	}
}
