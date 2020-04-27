package swing304.checkbox;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

/* JCheckBox 체크박스 컴포넌트 
	선택(selected)과 비선택(deselected)의 두 상태만 가지는 체크 버튼
	
	생성자
		JCheckBox() 빈 체크박스
		JCheckBox(String)  문자열 체크박스
		JCheckBox(String, boolean selected)  문자열 체크박스
		JCheckBox(Icon)  이미지 체크박스
		JCheckBox(Icon, boolean selected) 이미지 체크박스
		JCheckBox(String, Icon)   문자열 + 이미지를 가진 체크박스
		JCheckBox(String, Icon, boolean selected)   문자열 + 이미지를 가진 체크박스
 			*selected : true 이면 '선택상태'로,  false 이면 '비선택 상태'로..
 	
 	이미지 체크박스의 경우
 		체크박스 모양 □ 이 출력되지 않음
 		'선택상태' 를 표현하는 이미지 아이콘 따로 지정해야 함 : setSelectedIcon() 사용
 		
 */

public class MainWindow extends JFrame {
	public MainWindow() {
		setTitle("체크박스 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// TODO
		
		
		setSize(250,150);
		setVisible(true);
	} // end 생성자
	
	public static void main(String [] args) {
		new MainWindow();
	} // end main()
	
} // end class
