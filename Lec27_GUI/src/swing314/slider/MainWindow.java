package swing314.slider;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JSlider;

/* JSlider, 슬라이더
	마우스로 움직이면서 값을 선택하는 컴포넌트
	
	구성요소:
		손잡이(handler), track, minimum값, maximum값, 
		majorTickSpacing(큰눈금간격),  minorTickSpacing(작은 눈금 간격) ...
		value (현재값)
		
	Orientation 에 따라 수평(HORIZONTAL) 수직(VERTICAL) 슬라이더 구분
	
	생성자
		JSlider() 디폴트 슬라이더 생성
		JSlider(int orientation)   수평/수직 방향 설정된 슬라이더 생성
		JSlider(int min, int max, int val)   최소,최대, 초깃값 
		JSlider(int orientation, int min, int max, int val)

	슬라이더 방향 설정
		setOrientation(int orientation)
			orientation : JSlider.HORIZONTAL, JSlider.VERTICAL

	최대 최소 값 설정
		setMaximum(int max)
		setMinimum(int min)
	
	label 보이기/감추기
		setPaintLabels(boolean b) b가 true이면 label 출력

	tick 보이기/감추기
		setPaintTicks(boolean b)  b가 true이면 눈금 출력

	track 보이기/감추기
		setPaintTrack(boolean b)  b가 true이면 track 출력

	큰 눈금 간격 지정
		setMajorTickSpacing(int space)
		
	작은 눈금 간격 지정
		setMinorTickSpacing(int space)
		
	슬라이더 값 제어
		setVaule(int n)
		n이 슬라이더의 값이 되며 이에 따라 슬라이더의 손잡이 위치가 변경된다.
 */

public class MainWindow extends JFrame {

	public MainWindow() {
		setTitle("슬라이더 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// TODO
		
		
		setSize(300,200);
		setVisible(true);
	} // end 생성자
	
	public static void main(String [] args) {
		new MainWindow();
	} // end main()
	
} // end class
