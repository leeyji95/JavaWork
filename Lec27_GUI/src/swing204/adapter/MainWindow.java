package swing204.adapter;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

/* 어댑터(Adapter) 클래스
	
	이벤트 리스너 구현에 따른 부담 발생 (직전 예제)
	리스너 작성시 추상 메소드들을 모두 구현해야 하는 부담
	마우스 리스너에서 마우스가 눌러지는 경우(mousePressed())만 처리하고자 하는 경우에도 
	나머지 4 개의 메소드를 모두 구현해야 하는 부담
	
	어댑터 클래스
	리스너의 모든 메소드가 단순 리턴하도록 구현해 놓은 클래스

	단! 추상 메소드가 하나뿐인 리스너는 어댑터 클래스 없음
		ex) ActionAdapter, ItemAdapter 클래스는 어댑터클래스 존재하지 않음
 */
public class MainWindow extends JFrame {

	private JLabel lbl = new JLabel("Hello");

	public static void main(String[] args) {
		new MainWindow();	
	} // end main
		
	public MainWindow() {
		setTitle("MouseAdapter 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		// 컨테이너에 마우스 이벤트 
		// TODO
		
		c.setLayout(null);
		
		// 레이블의 최초 위치
		lbl.setSize(50, 20);
		lbl.setLocation(30, 30);
		c.add(lbl);
		
		
		setSize(450, 250);
		setVisible(true);
	} // end 생성자

	
	// MouseAdapter 클래스 정의
	// TODO

} // end class
