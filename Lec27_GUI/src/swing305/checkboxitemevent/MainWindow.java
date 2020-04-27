package swing305.checkboxitemevent;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/* JCheckBox에서 Item 이벤트 처리

	Item 이벤트
		체크 박스나 라디오버튼의 선택 상태가 바뀔 발생하는 이벤트
			마우스나 키보드로 체크박스를 선택 상태를 바꾸는 경우
			프로그램에서 선택 상태를 바꾸는 경우 : setSelected(true/false)

	ItemListener 인터페이스
		itemStateChenged(ItemEvent e)  체크박스의 선택/채세 상태가 변할때 호출됨

	ItemEvent의 주요 메소드
		int getStateChange()  :  ItemEvent.SELECTED, 혹은 ItemEvent.DESELECTED 리턴
		Object getItem()  : 이벤트 발생시킨 객체 리턴, 체크박스의 경우 JCheckBox 리턴  
 */

public class MainWindow extends JFrame {

	public MainWindow() {
		setTitle("체크박스와 ItemEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		// TODO
		
		
		setSize(250, 200);
		setVisible(true);
	} // end 생성자

	public static void main(String[] args) {
		new MainWindow();
	} // end main()

} // end class
