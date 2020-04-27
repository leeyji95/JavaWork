package swing207.keyevent3;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

/* 상, 하, 좌, 우 키를 이용하여 "HELLO" 문자열을 움직이기

	"HELLO" 문자열은 JLabel 컴포넌트로 만들어 컨텐트팬에 부착하고 
	상, 하, 좌, 우 키를 움직이면 키 방향으로 한 번에 10픽셀씩 움직인다. 
	
	이를 위해 컨텐트팬의 배치관리자를 삭제하여야 한다. 
	"HELLO" 문자열을 초기에 (50, 50) 위치에 출력하라.

 */
public class MainWindow extends JFrame{
	
	private final int FLYING_UNIT = 10;  // 10 픽셀씩 이동(상수값 선언)		
	private JLabel lbl = new JLabel("HELLO");

	public MainWindow() {
		setTitle("상,하,좌,우 키를 이용하여 텍스트 움직이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		// 키 리스너 등록
		c.addKeyListener(new MyKeyListener());

		lbl.setLocation(50, 50);
		lbl.setSize(100, 30);
		lbl.setFont(new Font("Serif", Font.PLAIN, 30));
		c.add(lbl);
		
		setSize(500, 500);
		setVisible(true);
		
		c.setFocusable(true);  // 포커스!
		c.requestFocus();

	} // end 생성자

	// KeyListener 의 Adapter 인 KeyAdapter 사용한 클래스 정의
	class MyKeyListener extends KeyAdapter {
		
		// 방향키 눌렸을때 레이블 이동시키기
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			switch(keyCode) {
			case KeyEvent.VK_UP:
				lbl.setLocation(lbl.getX(),lbl.getY() - FLYING_UNIT);
				break;
			case KeyEvent.VK_DOWN:
				lbl.setLocation(lbl.getX(),lbl.getY() + FLYING_UNIT);
				break;
			case KeyEvent.VK_LEFT:
				lbl.setLocation(lbl.getX() - FLYING_UNIT, lbl.getY());
				break;
			case KeyEvent.VK_RIGHT:
				lbl.setLocation(lbl.getX() + FLYING_UNIT, lbl.getY());
				break;
			}
			
			
			
		}
		
		
	} // end MyKeyListener
	
	
	public static void main(String[] args) {
		new MainWindow();
	} // end main()
	
} // end class
