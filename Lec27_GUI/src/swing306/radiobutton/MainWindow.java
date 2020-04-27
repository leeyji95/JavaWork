package swing306.radiobutton;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/* JRadioButton, 라디오버튼 컴포넌트
	
	라디오버튼이란?
		'여러 버튼'으로 '그룹'을 형성하고, '하나만 선택'되는 버튼
		다른 버튼이 선택되면 이전에 선택된 버튼은 자동으로 해제됨
		
	체크박스와의 차이점
		체크 박스는 각 체크박스마다 선택/해제 가능
		라디오 버튼은 그룹에 속한 버튼 중 하나만 선택 상태가 됨
	
	이미지를 가진 라디오버튼의 생성 및 다루기는 체크박스와 완전히 동일
	
	생성자
		JRadioButton() 빈 라디오 버튼
		JRadioButton(Icon)  이미지 라디오 버튼
		JRadioButton(Icon, selected) 이미지 라디오 버튼
		JRadioButton(String) 문자열 라디오 버튼
		JRadioButton(String, selected) 문자열 라디오 버튼
		JRadioButton(String, Icon) 문자열 + 이미지 라디오 버튼
		JRadioButton(String, Icon, selected)  문자열과 이미지를 가진 라디오 버튼
 			*selected : true 이면 '선택상태'로,  false 이면 '비선택 상태'로..
 			
 	라이오 버튼 생성 과정
 		1. ButtonGroup 객체 생성
 		2. JRadioButton 컴포넌트(들) 생성
 		3. ButtonGroup 에 JRadioButton(들) 을 추가 : add() 
 		4. JRadioButton 을 컨테이너에 추가 : add()
 		
 */
public class MainWindow extends JFrame {
	
	public MainWindow() {
		setTitle("라디오버튼 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// TODO
		
		setSize(450,150);
		setVisible(true);
	} // end 생성자
	
	public static void main(String [] args) {
		new MainWindow();
	} // end main()
	
} // end class
