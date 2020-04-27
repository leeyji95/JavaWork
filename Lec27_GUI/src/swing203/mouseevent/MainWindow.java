package swing203.mouseevent;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

/* 마우스 이벤트 연습
	마우스로 문자열 이동시키기 
	컨텐트팬의 아무 위치에 마우스 버튼을 누르면 
	마우스 포인트가 있는 위치로 "hello" 문자열을 옮기는 스윙 응용프로그램을 작성하라.
 */
public class MainWindow extends JFrame{

	private JLabel lbl = new JLabel("Hello");
	
	public static void main(String[] args) {
		new MainWindow();
	} // end main
	
	public MainWindow() {
		setTitle("Mouse 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		// 컨테이너에 마우스 이벤트 추가
		// TODO
		
		c.setLayout(null);
		
		// 레이블의 최초 위치
		lbl.setSize(50, 20);
		lbl.setLocation(30, 30);
		c.add(lbl);
		
		setSize(450, 250);
		setVisible(true);
	} // end 생성자

	
	// 마우스 리스너 클래스 정의
	// TODO
	

} // end class
