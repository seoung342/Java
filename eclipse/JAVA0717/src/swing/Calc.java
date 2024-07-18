package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calc extends JFrame implements ActionListener{
	
	JLabel la1 = new JLabel("계산기");
	JLabel la2 = new JLabel("계산 결과 : ");
	JTextField jt1 = new JTextField(10);
	JTextField jt2 = new JTextField(10);
	JButton jb1 = new JButton("+");
	JButton jb2 = new JButton("-");
	JButton jb3 = new JButton("*");
	JButton jb4 = new JButton("/");
	
	Calc(){
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		
		jp1.add(la1);
		con.add(jp1, BorderLayout.NORTH);
		con.add(jp2, BorderLayout.CENTER);
		jp2.setLayout(new GridLayout(3,2));
		jp2.add(jt1);jp2.add(jt2);
		jp2.add(jb1);jp2.add(jb2);jp2.add(jb3);jp2.add(jb4);
		jp3.add(la2);
		con.add(jp3, BorderLayout.SOUTH);
		
		this.setTitle("계산기");
		this.setLocation(400, 400);
		this.setSize(200, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		new Calc();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb1) {
			System.out.println("+");
		}else if(e.getSource() == jb2) {
			System.out.println("-");
		}else if(e.getSource() == jb3) {
			System.out.println("*");
		}else if(e.getSource() == jb4) {
			System.out.println("/");
		}
	}

}
