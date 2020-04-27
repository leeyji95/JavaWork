package swing508.optionpane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/* 팝업 다이얼로그, JOptionPane
	JOptionPane
		간단하고 유용한 팝업 다이얼로그 지원
		간단한 static 메소드 이용. 간단히 다이얼로그 출력 가능
	
	입력 다이얼로그 - 한 줄을 입력 받는 다이얼로그
		String JOptionPane.showInputDialog(String msg)
			msg : 다이얼로그의 객체
			리턴값 : 사용자가 입력한 문자열
			
	확인 다이얼로그 – 사용자로부터 Yes/No 응답을 입력 받는 다이얼로그
		int JOptionPane.showConfirmDialog(Component parentComponent, Object msg, String title, int optionType)
			parentComponent는 다이얼로그가 출력되는 영역의 범위로서 프레임. null 이면 화면 전체의 중앙에 출력
			msg : 다이얼로그에 출력될 객체
			title : 다이얼로그의 타이틀 문자열
			optionType : 다이얼로그의 종류 지정 - YES_ON_OPTION,  YES_NO_CANCEL_OPTION, OK_CANCEL_OPTION
			리턴값 : 사용자가 선택한 옵션 - YES_OPTION, NO_OPTION, CANCEL_OPTION, OK_OPTION, CLOSED_OPTION
			
	메시지 다이얼로그 – 단순 메시지를 출력하는 다이얼로그
		void JOptionPane.showMessageDialog(Component parentComponent, Object msg, String title, int messageType)
			parentComponent, msg, title은 showConfirmDialog() 메소드와 동일
			messageType - ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGGE, QUSTION_MESSAGE, PLAIN_MESSAGE

 */
public class MainWindow extends JFrame {
	
	Container c;

	public MainWindow() {
		setTitle("옵션 팬 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();

		// TODO
		
		setSize(550, 200);
		setVisible(true);
	} // end 생성자

	public static void main(String[] args) {
		new MainWindow();
	} // end main
	
} // end class
