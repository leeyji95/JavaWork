package swing504.tooltip;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/* 툴팁 JToolTip
 	스윙 컴포넌트를 설명하는 팁 문구
		팁 문구는 문자열만 가능
	컴포넌트 위에 마우스를 올리면 잠깐 나타났다가 사라짐

	툴팁 생성
		1. JToolTip 클래스 이용(복잡하므로 권하지 않음)
		2. JComponent.setToolTipText(String msg) 이용 : 권장

 */
public class MainWindow extends JFrame {
	
	public MainWindow() {
		setTitle("툴팁  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// TODO
		
		
		setSize(450,200);
		setVisible(true);
	} // end 생성자

	public static void main(String [] args) {
		new MainWindow();
	} // end main()
	
} // end class
