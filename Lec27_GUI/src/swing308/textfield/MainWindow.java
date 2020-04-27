package swing308.textfield;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/* JTextField 텍스트필드 컴포넌트
	한 줄 짜리 텍스트(문자열) 입력 창을 구현한 컴포넌트
	텍스트 입력 도중 <Enter>키가 입력되면 Action 이벤트 발생
	입력 가능한 문자 개수와 입력 창의 크기는 서로 다름
	
	생성자
		JTextField() 빈 텍스트 필드
		JTextField(int cols)  입력 창의 열의 개수가 cols 개인 텍스트 필드 
		JTextField(String)  문자열로 초기화된 텍스트필드
		JTextField(String, int cols)   입력창 열의 개수는 cols 이고, 문자열로 초기화된 텍스트 필드
		
	주요 메소드
		setEditable(false) : 문자열 편집 불가능하게 하기
		setText("hello") : 입력창에 문자열 출력
		setFont(new Font("고딕체", Font.ITALIC, 20) : 문자열의 폰트 지정
	
 */
public class MainWindow extends JFrame {

	public MainWindow() {
		setTitle("텍스트필드 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		// TODO

		setSize(300,200);
		setVisible(true);
	} // end 생성자
	
	public static void main(String [] args) {
		new MainWindow();
	} // end main()
} // end class
