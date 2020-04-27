package swing503.toolbar;
/* JToolBar 툴바
	툴바를 구현한 컴포넌트
		'여러 컴포넌트를 담을' 수 있는 '컨테이너'
	툴바의 모양
		'한 행' 혹은 '한 열'로만 표현
	기능
		버튼이나 이미지 등 '모든 컴포넌트'를 부착하여 이들을 '메뉴'처럼 사용
	툴바가 부착되는 위치
		툴바는 'BorderLayout' 배치 관리자를 가진 컨테이너에만 부착
			상(NORTH), 하(SOUTH), 좌(WEST), 우(EAST) 측의 모서리 중 선택 부착
			사용자의 드래그에 의해 위의 4 가지 위치에 이동 부착 가능
		사용자의 드래그에 의해 독립적인 다이얼로그 형태로 떨어져서 존재할 수 있음
		사용자의 드래그에 의한 이동이 불가능하게 할 수 있음
	(툴바 예시 *ppt참조)
	
	툴바 만드는 과정
		1. JToolBar 객체 생성
		2. 컴포넌트를 JToolBar 컴포넌트에 삽입
		3. JToolBar 컴포넌트를 컨테이너에 배치
			컨테이너는 BorderLayout 배치 관리자
	툴바 제어
		툴바 생성자
			JToolBar()
			JToolBar(String title)
				툴바가 윈도우에서 떨어져 나와 독립적으로 존재할 때 툴바의 타이틀로 title 문자열 설정
		
		툴바 드래그 못하게 고정하는 방법
			JToolBar.setFloatable(boolean b)
				b가 true이면 드래그하여 이동 가능한 툴바, false이면 툴바의 핸들이 없어지며 드래그 불가능(이동 불가능)
		
		툴바에 separator 삽입
			JToolBar.addSeparator()
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class MainWindow extends JFrame {

	public MainWindow() {
		setTitle("툴바 만들기  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// TODO
		
		
		setSize(400, 200);
		setVisible(true);
	} // end 생성자

	public static void main(String[] args) {
		new MainWindow();
	} // end main()
	
} // end class
