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
	
	JLabel la = new JLabel("계산기"); // 레이블 생성 및 초기화
	JTextField jt1 = new JTextField(15); // 텍스트 필드 생성 및 초기화
	JTextField jt2 = new JTextField(15); // 텍스트 필드 생성 및 초기화
	JButton[] jb = new JButton[20]; // 버튼 배열 생성
	JPanel[] jp = new JPanel[3]; // 패널 배열 생성
	String[] list = {"C","%","/","<==",
						"7","8","9","*",
						"4","5","6","-",
						"1","2","3","+",
						"+/-","0",".","="}; // 버튼 라벨 배열 생성
	
	String num1, num2, mark; // 계산에 사용할 변수들
	double result = 0.0; // 계산 결과
	boolean dotClicked = false; // 소수점 클릭 여부를 저장하는 변수
	
	public Main() {
		// 컨테이너 설정
		OptionContainer();
		// 버튼 클릭 이벤트 설정
		ButtonClick();
		
	}
	// 컨테이너 설정 메소드
	private void OptionContainer() {
		
		Container con = this.getContentPane(); // 프레임의 컨텐트 팬을 가져옴
		con.setLayout(new BorderLayout()); // 프레임의 레이아웃을 BorderLayout으로 설정
		
		for (int i = 0; i < 3; i++) {
			jp[i] = new JPanel(); // 패널 배열 초기화
		}
		
		jp[0].setLayout(new FlowLayout()); // 첫 번째 패널을 FlowLayout으로 설정
		jp[1].setLayout(new GridLayout(2,1)); // 두 번째 패널을 2x1의 GridLayout으로 설정
		jp[2].setLayout(new GridLayout(5,4,2,2)); // 세 번째 패널을 5x4의 GridLayout으로 설정
		con.add(jp[0], BorderLayout.NORTH); // 첫 번째 패널을 프레임의 북쪽에 추가
		con.add(jp[1], BorderLayout.CENTER); // 두 번째 패널을 프레임의 중앙에 추가
		con.add(jp[2], BorderLayout.SOUTH); // 세 번째 패널을 프레임의 남쪽에 추가
		
		jp[0].add(la); // 첫 번째 패널에 레이블 추가
		jp[1].add(jt1); // 두 번째 패널에 첫 번째 텍스트 필드 추가
		jp[1].add(jt2); // 두 번째 패널에 두 번째 텍스트 필드 추가
		jt1.setHorizontalAlignment(JTextField.RIGHT); // 첫 번째 텍스트 필드의 정렬을 오른쪽으로 설정
		jt2.setHorizontalAlignment(JTextField.RIGHT); // 두 번째 텍스트 필드의 정렬을 오른쪽으로 설정
		
		// 세 번째 패널에 버튼 추가
		for(int i = 0; i < 20; i++) {
			jb[i] = new JButton(list[i]);
			jp[2].add(jb[i]);
		}
		
		this.setTitle("계산기"); // 프레임 제목 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 동작 설정
		this.setLocation(700,  300); // 프레임의 위치 설정
		this.setSize(250, 300); // 프레임의 크기 설정
		this.setVisible(true); // 프레임을 화면에 표시
	}
	// 버튼 클릭 이벤트 설정 메소드
	private void ButtonClick() {
		for(int i = 0; i < 20; i++) {
			jb[i].addActionListener(new ClickEvent()); // 버튼에 클릭 이벤트 리스너 연결
		}
	}
	// 버튼 클릭 이벤트 처리를 위한 내부 클래스
	class ClickEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
				case "0": jt2.setText(jt2.getText()+"0"); break; // 숫자 0 버튼 클릭 시 텍스트 필드에 0 추가
				case "1": jt2.setText(jt2.getText()+"1"); break; // 숫자 1 버튼 클릭 시 텍스트 필드에 1 추가
				case "2": jt2.setText(jt2.getText()+"2"); break; // 숫자 2 버튼 클릭 시 텍스트 필드에 2 추가
				case "3": jt2.setText(jt2.getText()+"3"); break; // 숫자 3 버튼 클릭 시 텍스트 필드에 3 추가
				case "4": jt2.setText(jt2.getText()+"4"); break; // 숫자 4 버튼 클릭 시 텍스트 필드에 4 추가
				case "5": jt2.setText(jt2.getText()+"5"); break; // 숫자 5 버튼 클릭 시 텍스트 필드에 5 추가
				case "6": jt2.setText(jt2.getText()+"6"); break; // 숫자 6 버튼 클릭 시 텍스트 필드에 6 추가
				case "7": jt2.setText(jt2.getText()+"7"); break; // 숫자 7 버튼 클릭 시 텍스트 필드에 7 추가
				case "8": jt2.setText(jt2.getText()+"8"); break; // 숫자 8 버튼 클릭 시 텍스트 필드에 8 추가
				case "9": jt2.setText(jt2.getText()+"9"); break; // 숫자 9 버튼 클릭 시 텍스트 필드에 9 추가
				case "C": jt1.setText(null); jt2.setText(null); dotClicked = false; break; // 'C' 버튼 클릭 시 모든 필드 초기화
				case "%": num1 = jt2.getText(); mark = "%"; jt1.setText(jt2.getText() + " % "); jt2.setText(null); dotClicked = false; break; // '%' 버튼 클릭 시 num1에 숫자 저장 후 화면에 표시
				case "/": num1 = jt2.getText(); mark = "/"; jt1.setText(jt2.getText() + " / "); jt2.setText(null); dotClicked = false; break; // '/' 버튼 클릭 시 num1에 숫자 저장 후 화면에 표시
				case "*": num1 = jt2.getText(); mark = "*"; jt1.setText(jt2.getText() + " * "); jt2.setText(null); dotClicked = false; break; // '*' 버튼 클릭 시 num1에 숫자 저장 후 화면에 표시
				case "-": num1 = jt2.getText(); mark = "-"; jt1.setText(jt2.getText() + " - "); jt2.setText(null); dotClicked = false; break; // '-' 버튼 클릭 시 num1에 숫자 저장 후 화면에 표시
				case "+": num1 = jt2.getText(); mark = "+"; jt1.setText(jt2.getText() + " + "); jt2.setText(null); dotClicked = false; break; // '+' 버튼 클릭 시 num1에 숫자 저장 후 화면에 표시
				case ".": 
					if (!dotClicked) {
                    jt2.setText(jt2.getText() + ".");
                    dotClicked = true;
                }
                break; // '.' 버튼 클릭 시 소수점 추가
				case "=": 
					num2 = jt2.getText(); 
					jt1.setText(jt1.getText() + jt2.getText());
					Calculation(); // '=' 버튼 클릭 시 계산 실행
					jt2.setText(String.valueOf(result)); // 계산 결과를 텍스트 필드에 표시
					dotClicked = false; // 소수점 초기화
					break;
				case "+/-":
					String currentText = jt2.getText();
	                if (currentText.startsWith("-")) {
	                    jt2.setText(currentText.substring(1));
	                } else {
	                    jt2.setText("-" + currentText);
	                }
	                break; // '+/-' 버튼 클릭 시 양수/음수 전환
				case "<==":
					 String text = jt2.getText();
	                    if (text.length() > 0) {
	                    	jt2.setText(text.substring(0, text.length() - 1));
	                    }
	                    break; // '<==' 버튼 클릭 시 마지막 한 글자 삭제
			}
		}
	}
	// 사칙 연산을 수행하는 메소드
	private void Calculation() {
		switch(mark) {
		case "%":
			result = Double.parseDouble(num1) % Double.parseDouble(num2);
			break; // '%' 연산 수행
		case "/":
			result = Double.parseDouble(num1) / Double.parseDouble(num2);
			break; // '/' 연산 수행
		case "*":
			result = Double.parseDouble(num1) * Double.parseDouble(num2);
			break; // '*' 연산 수행
		case "-":
			result = Double.parseDouble(num1) - Double.parseDouble(num2);
			break; // '-' 연산 수행
		case "+":
			result = Double.parseDouble(num1) + Double.parseDouble(num2);
			break; // '+' 연산 수행
		}
	}
	
	public static void main(String[] args) {
		new Main(); // 계산기 애플리케이션 실행
	}
}