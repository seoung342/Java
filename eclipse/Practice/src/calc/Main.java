package calc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame{
	
	JLabel la = new JLabel("계산기");
	JTextField jt1 = new JTextField(15);
	JTextField jt2 = new JTextField(15);
	JButton[] jb = new JButton[20];
	JPanel[] jp = new JPanel[3];
	String[] list = {"C","%","/","<==",
						"7","8","9","*",
						"4","5","6","-",
						"1","2","3","+",
						"+/-","0",".","="};
	
	String num1, num2, mark;
	double result = 0.0;
	boolean dotClicked = false;
	
	public Main() {
		// 컨테이너 설정
		OptionContainer();
		// 버튼 연결
		ButtonClick();
		
	}
	// 컨테이너 설정
	private void OptionContainer() {
		
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		
		for (int i = 0; i < 3; i++) {
			jp[i] = new JPanel();
		}
		
		jp[0].setLayout(new FlowLayout());
		jp[1].setLayout(new GridLayout(2,1));
		jp[2].setLayout(new GridLayout(5,4,2,2));
		con.add(jp[0], BorderLayout.NORTH);
		con.add(jp[1], BorderLayout.CENTER);
		con.add(jp[2], BorderLayout.SOUTH);
		
		jp[0].add(la);	// 판넬에 레이블 넣기
		jp[1].add(jt1);// 판넬에 텍스트 필드 넣기
		jp[1].add(jt2);	// 판넬에 텍스트 필드 넣기
		jt1.setHorizontalAlignment(JTextField.RIGHT);
		jt2.setHorizontalAlignment(JTextField.RIGHT);
		
		// 판낼에 버튼 넣기
		for(int i = 0; i <20; i++) {
			jb[i] = new JButton(list[i]);
			jp[2].add(jb[i]);
		}
		
		this.setTitle("계산기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(700,  300);
		this.setSize(250, 300);
		this.setVisible(true);
	}
	// 버튼 모음
	private void ButtonClick() {
		for(int i = 0; i < 20; i++) {
			jb[i].addActionListener(new ClickEvent());
		}
	}
	// 버튼 클릭 이벤트 
	class ClickEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
				case "0": jt2.setText(jt2.getText()+"0"); break;
				case "1": jt2.setText(jt2.getText()+"1"); break;
				case "2": jt2.setText(jt2.getText()+"2"); break;
				case "3": jt2.setText(jt2.getText()+"3"); break;
				case "4": jt2.setText(jt2.getText()+"4"); break;
				case "5": jt2.setText(jt2.getText()+"5"); break;
				case "6": jt2.setText(jt2.getText()+"6"); break;
				case "7": jt2.setText(jt2.getText()+"7"); break;
				case "8": jt2.setText(jt2.getText()+"8"); break;
				case "9": jt2.setText(jt2.getText()+"9"); break;
				case "C": jt1.setText(null); jt2.setText(null); dotClicked = false; break;
				case "%": num1 = jt2.getText(); mark = "%"; jt1.setText(jt2.getText() + " % "); jt2.setText(null); dotClicked = false; break;
				case "/": num1 = jt2.getText(); mark = "/"; jt1.setText(jt2.getText() + " / "); jt2.setText(null); dotClicked = false; break;
				case "*": num1 = jt2.getText(); mark = "*"; jt1.setText(jt2.getText() + " * "); jt2.setText(null); dotClicked = false; break;
				case "-": num1 = jt2.getText(); mark = "-"; jt1.setText(jt2.getText() + " - "); jt2.setText(null); dotClicked = false; break;
				case "+": num1 = jt2.getText(); mark = "+"; jt1.setText(jt2.getText() + " + "); jt2.setText(null); dotClicked = false; break;
				case ".": 
					if (!dotClicked) {
                    jt2.setText(jt2.getText() + ".");
                    dotClicked = true;
                }
                break;
				case "=": 
					num2 = jt2.getText(); 
					jt1.setText(jt1.getText() + jt2.getText());
					Calculation();
					jt2.setText(String.valueOf(result));
					dotClicked = false;
					break;
				case "+/-":
					String currentText = jt2.getText();
	                if (currentText.startsWith("-")) {
	                    jt2.setText(currentText.substring(1));
	                } else {
	                    jt2.setText("-" + currentText);
	                }
	                break;
				case "<==":
					 String text = jt2.getText();
	                    if (text.length() > 0) {
	                        jt2.setText(text.substring(0, text.length() - 1));
	                    }
	                    break;
			}
			
		}
	}
	// 사칙 연산
	private void Calculation() {
		switch(mark) {
		case "%":
			result = Double.parseDouble(num1) % Double.parseDouble(num2);
			break;
		case "/":
			result = Double.parseDouble(num1) / Double.parseDouble(num2);
			break;
		case "*":
			result = Double.parseDouble(num1) * Double.parseDouble(num2);
			break;
		case "-":
			result = Double.parseDouble(num1) - Double.parseDouble(num2);
			break;
		case "+":
			result = Double.parseDouble(num1) + Double.parseDouble(num2);
			break;
		}
	}
	
	
	public static void main(String[] args) {
		new Main();
	}
}
