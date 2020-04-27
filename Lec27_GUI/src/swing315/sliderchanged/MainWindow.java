package swing315.sliderchanged;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/* JSlider와 Change 이벤트

	Change 이벤트
		JSlider의 값(value)이 바뀌면 발생 
			사용자가 슬라이더의 손잡이를 움직이는 경우
			JSlider의 setValue(int n)를 호출하여 값(value 필드)이 바뀌는 경우

	ChangeListener 리스너
		stateChanged(ChangeEvent)
 */
public class MainWindow extends JFrame {
	
	public MainWindow() {
		setTitle("슬라이더와 ChangeEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// TODO
		
		
		setSize(320,230);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new MainWindow();
	} // end main()
	
} // end class
