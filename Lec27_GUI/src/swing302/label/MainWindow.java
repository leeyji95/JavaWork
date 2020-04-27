package swing302.label;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/* JLabel 컴포넌트
	문자열이나 이미지를 컴포넌트화 하여 출력하기 위한 목적

	생성자
		JLabel() 빈 레이블
		JLabel(Icon)    이미지 레이블
		JLabel(String)   문자열 레이블
		JLabel(String, Icon, int hAlign)  문자열과 이미지를 모두 가진 레이블
				hAlign 수평 정렬 값,  SwingConstants.LEFT, SwingConstants.RIGHT, SwingConstants.CENTER 중 하나
 
 */
public class MainWindow extends JFrame{

	public MainWindow() {
		setTitle("레이블 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel textLabel = new JLabel("싸랑합니다.");
		ImageIcon beauty = new ImageIcon("images/beauty.jpg");
		JLabel imageLabel = new JLabel(beauty);
		
		
		c.add(textLabel);
		c.add(imageLabel);
		
		
		
		setSize(400,600);
		setVisible(true);
	} // end constructor
	
	public static void main(String [] args) {
		new MainWindow();
	} // end main
	
} // end class
