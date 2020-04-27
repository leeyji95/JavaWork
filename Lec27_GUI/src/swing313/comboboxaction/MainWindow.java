package swing313.comboboxaction;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/* JComboBox<E>와 Action 이벤트
	콤보박스의 아이템 선택시 Action 이벤트 발생
	
	현재 선택된 아이템 알아내기
		JComboBox<E>의 다음 메소드 활용
		
		int getSelectexIndex()  선택상태인 아이템의 인덱스 번호 리턴
		Object getSelectedItem()  선택상태인 아이템 객체의 레퍼런스 리턴
 */
public class MainWindow extends JFrame {

	public MainWindow() {
		setTitle("콤보박스 활용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// TODO
		
		
		setSize(300,250);
		setVisible(true);
	} // end 생성자
	
	public static void main(String [] args) {
		new MainWindow();
	} // end main
	
} // end class
