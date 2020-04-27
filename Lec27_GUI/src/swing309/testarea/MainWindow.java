package swing309.testarea;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/* JTextArea, 텍스트영역 컴포넌트
	여러 줄을 입력할 수 있는 텍스트 입력 창
	JScrollPane 컴포넌트에 삽입하면 스크롤바 지원됨

	생성자
		JTextArea()  빈 생성자 
		JTextArea(int rows, int cols)  입력 창이 rows * cols 개의 문자 크기인 텍스트 영역 
		JTextArea(String)   문자열로 초기화된 텍스트 영역 
		JTextArea(String, rows, cols)  입력 창이 rows * cols 개의 문자 크기 + 문자열 초기화
*/

public class MainWindow extends JFrame {
	
	public MainWindow() {
		setTitle("텍스트영역 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// TODO
		
		
		setSize(450,300);
		setVisible(true);
	} // end 생성자
	
	public static void main(String [] args) {
		new MainWindow();
	} // end main
	
} // end class
