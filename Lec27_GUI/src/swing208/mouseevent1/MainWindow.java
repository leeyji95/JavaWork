package swing208.mouseevent1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

/* 마우스 이벤트와 리스너
 	
 	리스너에는 MouseListener 와 MouseMotionListener 두가지가 있다.
 	※ppt 참조※
 	
 	마우스가 눌러진 위치에서 떼어지는 경우 메소드 호출 순서
		mousePressed(), mouseReleased(), mouseClicked()

	마우스가 드래그될 때 호출되는 메소드 호출 순서
		mousePressed(), mouseDragged(), mouseDragged(),..., mouseDragged(), mouseReleased()
		
		
	마우스 리스너 등록
		MouseListener의 5 개의 이벤트를 처리하는 경우
			mouseEntered(), mouseExited(), mousePressed(), mouseReleased(), mouseClicked()
		마우스 리스너 등록
			addMouseListener(MouseListener);

		MouseMotionListener의 이벤트도 함께 처리하고자 하는 경우
			mouseDragged(), mouseMoved()
		마우스 모션 리스너 등록 필요
			addMouseMotionListener(MouseMotionListener);
			
	MouseEvent 객체로부터 얻을 수 있는 정보
		마우스 포인터의 위치
			int getX(), int getY(), 
			Point getPoint()
			
		입력된 마우스 버튼
			int getButton()

		마우스 클릭 횟수
			int getClickCount()  <-- 이 값이 2 이면 더블클릭이다
	
 */
public class MainWindow extends JFrame {
	
	private JLabel lbl = new JLabel("No Mouse Event");
	
	public MainWindow() {
		setTitle("MouseListener와 MouseMotionListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		// MouseListener 와 MoustMotionListener 등록
		// TODO
		
		
		lbl.setSize(100, 30);
		lbl.setFont(new Font("Serif", Font.PLAIN, 30));
		c.add(lbl);

		setSize(400, 400);
		setVisible(true);
	}

	// 마우스 리스너 객체 생성
	// ※ 각 이벤트 상황에 대해 동작하기 위해 Adapter 사용하지 않음
	// TODO
	
	
	
	public static void main(String[] args) {
		new MainWindow();
	} // end main()
	
} // end class
