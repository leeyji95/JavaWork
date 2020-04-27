package swing312.combobox;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;

/* JComboBox<E>, 콤보박스 컴포넌트 
	'텍스트 필드'와 [▼버튼]', 
	    그리고 '드롭다운 리스트'로 구성
	    
	콤보박스 아이템 선택시 Action 이벤트 발생
	    
	생성자
		JComboBox<E>() 빈 콤보박스
		JComboBox<E>(Vector)   벡터로부터 아이템을 공급받는 콤보박스
		JComboBox<E>(Object [])   배열로부터 아이템을 공급받는 콤보박스
 */
public class MainWindow extends JFrame {

	public MainWindow() {
		setTitle("콤보박스 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		// TODO
		
		setSize(300, 300);
		setVisible(true);
	} // end 생성자

	public static void main(String[] args) {
		new MainWindow();
	} // end main()

} // end class
