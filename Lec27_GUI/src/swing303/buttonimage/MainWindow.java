package swing303.buttonimage;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/* JButton 컴포넌트
	
	버튼을 선택하면 Action 이벤트 발생

	생성자
		JButton() 
		JButton(Icon)  이미지 버튼
		JButton(String)  문자열 버튼
		JButton(String, Icon) 문자열 + 이미지
	
	하나의 버튼에 3개의 이미지 설정 가능
		1.보통상태 
			생성자에 이미지 아이콘
			setIcon(Icon)
		2.마우스 올라갔을때
			setRolloverIcon(Icon)
		3. 버튼을 누르고 있을때
			setPressedIcon(Icon)
	
	이미지 아이콘 생성
		new ImageIcon(이미지 경로명);

		
	label 과 button 의 정렬(alignment)

		수평 정렬 : 컴포넌트 내에 이미지와 텍스트의 수평 위치
			setHorizontalAlignment(int align)
				align : 
					SwingConstants.LEFT 좌측정렬
					SwingConstants.CENTER 중앙정렬  
					SwingConstants.RIGHT 우측정렬
				           
				
		수직 정렬 : 컴포넌트 내에 이미지와 텍스트의 수직 위치
			setVerticalAlignment(int align)
				align : 
					SwingConstants.TOP 위쪽정렬
					SwingConstants.CENTER 중앙정렬
					SwingConstants.BOTTOM 아래쪽 정렬

 */

public class MainWindow extends JFrame {
	public MainWindow() {
		setTitle("이미지 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// ImageIcon 객체 생성
		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
		ImageIcon rolloverIcon = new ImageIcon("images/rolloverIcon.gif");
		ImageIcon pressedIcon = new ImageIcon("images/pressedIcon.gif");

		JButton btn = new JButton("call~", normalIcon);
		btn.setPressedIcon(pressedIcon); // 마우스가 올라갔을 때
		btn.setRolloverIcon(rolloverIcon); // 마우스가 눌렸을 때
		
		c.add(btn); // 컨테이너에 추가 
		
		//  마우스 커서가 올라갔을 때와 눌렸을 때 테두리 변경해보자. 
		
		
		setSize(250,150);
		setVisible(true);
	} // end 생성자
	
	public static void main(String [] args) {
		new MainWindow();
	} // end main
	
} // end class


























