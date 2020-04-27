package swing102.component;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*	컴포넌트 (Component)
 	
	프레임에 컴포넌트 붙이기
	프레임으로부터 컨텐트팬(Content Pane) 객체를 얻어와서  컴포넌트를 단다
	
	프레임의 컨텐트팬 (Contnet Pane) 가져오기 : getContentPane()  --> Container 객체 리턴
	컨텐트팬 에 컴포넌트 달기 :  Contenter 의 add(컴포넌트)
	프레임의 컨텐트팬 변경 : setContentPane(컨텐트팬)
*/


public class MainWindow {

	public static void main(String[] args) {
		
		new NUllContainerFrame();
		
		System.out.println("\n main() 종료");
	} // end main()
} // end class


class MyFrame extends JFrame{
	public MyFrame() {
		setTitle("컴포넌트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료(X버튼) 클릭시 응용프로그램 완전 종료(쓰레드 종료) 시키는 코드임.
		
		// 프레임의 content pane 가져오기
		Container c = getContentPane(); // JFrame 의 container 객체 가져오라는 것
		c.setBackground(Color.ORANGE); // 배경색 지정
		c.setLayout(new FlowLayout()); // 레이아웃 지정컨 (화면 줄이고 늘릴 때 알아서 버튼들 알아서 가운데 정렬 맞춰준다)          이 컨테이너 안에 들어갈 레이아웃들 설정해보자
		
		// 컴포넌트 추가 
		// 버튼 (JButton) 
		JButton button1 = new JButton("OK"); // -> container 에 달기
		c.add(button1);
		c.add(new JButton("Cancle"));
		c.add(new JButton("Ignore"));
		
		
		setSize(500,500);
		setVisible(true);
		
		
	} // end main
}// end class


class NUllContainerFrame extends JFrame{
	public NUllContainerFrame() {
		setTitle("NullContainer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null); // 컨테이너의 LayoutManager 제거
		
		// label 컴포넌트 -> 글자 표현하기 위한 객체
		JLabel lbl= new JLabel("Hello, Press Buttons");
		lbl.setLocation(130, 50); // 컴포넌트의 위치 지정 가능!
		lbl.setSize(200, 20); // 크기 지정
		
		c.add(lbl); // 이 컴포넌트를 컨테이너에 추가! 그 메소드가 add 메소드.
		
		
		setLocation(150, 150);
		setSize(400 ,200);
		setVisible(true);
		
		// 좌측 우측 150 떨어진 위치에, 가로 400, 세로 200 사이즈로 만들어지고~     가로에서 130, 세로 50 떨어진 위치에서 가로 세로 200 20 의 레이블이 하나 만들어질 것.  => 이걸 main 에서호출해보자.
	}
}
















