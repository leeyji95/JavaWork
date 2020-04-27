package swing104.panel;
/*
 * 각각의 영역에 컴포넌트를 몰아넣을 수 있는데, 
 * 
 * 프레임 객체 안에 레이이웃.
 * 두 개의 별도 패널.
 * 
 * 레이아웃 안에 레이아웃 잡는 것 -> 을 패널 이라고 함.
 * 큰 패널 만들고  그 안에 패널 만들고,  
 *  그 안에 필요한 것들 배치.
 * 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* JPanel : 컨테이너 역할을 하는 클래스
 	
 	다른 컨테이들처럼 컴포넌트들을 담을수 있다.
 	JPanel 내의 디폴트 레이아웃은 FlowLayout,  레이아웃 변경 가능
 	
 	프레임에 panel 들을 컴포넌트처럼 배치하고
 	각 panel 안에  또다시 panel 을 배치함으로 
 	복잡한 레이아웃 (중첩 레이아웃) 구성 가능.
 */
public class MainWindow {
	public static void main(String[] args) {
		new PanelFrame1();
	} // end main
} // end class

class PanelFrame1 extends JFrame {

	public PanelFrame1() {
		setTitle("panel 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//1. panel 생성
		JPanel p = new JPanel();
		p.setBounds(40 , 80, 200, 200); // 부모(프레임) 에 대한 상대위치, 크기
		p.setBackground(Color.GRAY);
		
		
		//4. 컴포넌트들 생성
		JButton b1 = new JButton("Button 1");
		b1.setBounds(50, 100, 80, 30);
		b1.setBackground(Color.YELLOW);
		
		JButton b2 = new JButton("Button 2");
		b2.setBounds(100, 100, 80, 30);
		b2.setBackground(Color.GREEN);
		
		JTextField t1 = new JTextField("0", 10); // (최초 문자열, 입력 column 수)  // --> 사용자로부터 텍스트 입력 받음
		t1.setBounds(50, 10, 80, 30);
		t1.setHorizontalAlignment(JTextField.RIGHT);

		
		//5. 컴포넌트들을 panel 에 추가
		p.setLayout(null);
		p.add(b1);
		p.add(b2);
		p.add(t1);
		
		
		//2. panel 을 프레임에 추가
		add(p);  // -> 위에서 내가 만든 패널을 프레임에 추가하는 메소드.
		
		setLayout(null);    
		setSize(400,400);    
		
		//3. 사이즈 조정 못하게 설정 가능
		setResizable(false);
		
		
        setVisible(true);
	} // end 생성자

} // end Frame
