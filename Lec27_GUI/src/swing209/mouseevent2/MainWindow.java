package swing209.mouseevent2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

/* 더블클릭 예제
	더블클릭할 때마다 컨텐트팬의 배경색을 랜덤하게 변경
 */
public class MainWindow extends JFrame {

	public MainWindow() {
		setTitle("Click and DoubleClick 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		
		// 마우스 리스너 등록
		c.addMouseListener(new MyMouseListener());
		
		setSize(400, 400);
		setVisible(true);
	} // end 생성자

	// MouseAdapter 사용한 마우스 리스너 클래스 정의
	class MyMouseListener extends MouseAdapter { // Adapter 사용
		// 더블 클릭 처리
		// TODO
	
	} // end Listener

	public static void main(String [] args) {
		new MainWindow();
	} // end main()

} // end class
