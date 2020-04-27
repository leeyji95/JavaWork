package swing507.modal;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

/* 모달 다이얼로그와 모달리스 다이얼로그
	모달(modal) 다이얼로그
		사용자 입력을 독점하는 다이얼로그
		닫기 전에는 다른 창에서 작업을 전혀 할 수 없는 다이얼로그
		생성 방법
			JDialog(Frame owner, String title, boolean modal) 생성자에서 modal을 true 값으로 지정
	모달리스 다이얼로그
		다른 창과 독립적으로 작동하는 다이얼로그
 */

public class MainWindow extends JFrame {
	
	public MainWindow() {
		super("DialogEx2 예제 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// TODO
		
		
		setSize(250, 200);
		setVisible(true);
	} // end 생성자

	public static void main(String[] args) {
		new MainWindow();
	} // end main()
	
} // end class
