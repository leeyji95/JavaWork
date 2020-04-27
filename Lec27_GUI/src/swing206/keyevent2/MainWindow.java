package swing206.keyevent2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

/* Key Code 예제
 */
public class MainWindow extends JFrame {

	private JLabel lbl = new JLabel();
	private Container c;
	
	public MainWindow() {
		setTitle("Key Code 예제 : F1키:초록색, % 키 노란색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		
		// 키 리스너 등록
		// TODO
		
		// java.awt.Color 객체 : R,G,B값 색상정의 가능
		// java.awt.Font 객체 : (글꼴, style, size)
		Color color1 = new Color(120,255,255);
		c.setBackground(color1);  // 컨테이너의 배경 : 하늘색

		Font font1 = new Font("Arial", Font.BOLD, 40);
		lbl.setFont(font1); // 레이블의 글꼴
		lbl.setForeground(new Color(146,24,89));  // 레이블의 글자색
		
		
		c.add(lbl);

		setSize(450,250);
		setVisible(true);

		c.setFocusable(true);  // 키입력 받도록 포커스 주기
		c.requestFocus();
	} // end 생성자
	
	// KeyListener 의 Adapter 인 KeyAdapter 사용한 클래스 정의
	// TODO
	
	
	
	public static void main(String[] args) {
		new MainWindow();
	} // end main()

} // end class
