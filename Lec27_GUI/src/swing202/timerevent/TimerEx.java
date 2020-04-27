package swing202.timerevent;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/* javax.swing.Timer 객체 
 * 일정 시간 간격으로 등록된 ActionListener 의 actionPerformed() 실행
 */
public class TimerEx {
	public static void main(String[] args) {
		new MainWindow();		
	} // end main
} // end class

class MainWindow extends JFrame{
	
	ActionListener timerListener;
	JLabel lbl = new JLabel();
	JButton btn = new JButton("클릭");
	
	// javax.swing.Timer 객체 
	// TODO
	
	public MainWindow() {
		setTitle("Timer 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
	
		lbl.setFont(new Font("Verdana", Font.BOLD, 30));
		c.add(lbl, BorderLayout.CENTER);
		c.add(btn, BorderLayout.SOUTH);
		
		// 1초 간격으로 동작하는 Timer 설정 : 시간 표시
		// TODO

		
		
		// 버튼 누르면 5초뒤 창이 켜지게 하자
		// TODO

		

		setSize(450, 250);
		setVisible(true);
	} // end 생성자
	
	class SubWindow extends JFrame{
		public SubWindow() {
			setTitle("타이머");
			Container c = getContentPane();
			
			c.add(new JLabel("짜잔"));
			
			setSize(450, 250);
			setLocation(500, 50); // 시작 위치
			setVisible(true);
			

			// TODO
			
		} // end 생성자
	} // end SubWindow
	
} // end MainWindow
