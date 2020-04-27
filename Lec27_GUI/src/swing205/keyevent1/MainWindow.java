package swing205.keyevent1;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.KeyPair;

import javax.swing.JFrame;
import javax.swing.JLabel;

/* Key 이벤트와 포커스
	
	Key 이벤트 등록 : addKeyListener() 사용
	
	키 입력 시, 다음 세 경우에 Key 이벤트 발 생
	KeyListener의 3 개 메소드 제공
		① keyPressed() : 키를 누르는 순간 
		② keyReleased() : 누른 키를 떼는 순간 
		③ keyTyped() : 누른 키를 떼는 순간(Unicode 키의 경우에만)
		
		실행순서는   ①keyPressed → ③keyTyped → ②keyReleased  
		
	키(Key)는 두가지 종류 :  
	    1 'Unicode 키' : 전세계 문자 대한 코드 체계 A~Z, a~z, 0~9, !, @, & 등
		2 'Unicode가 아닌 키' : 문자키가 아닌 키 (제어키)
			<Function>, <Home>, <Up>, <Delete>, <Control>, <Shift>, <Alt>
			정의된 Unicode 없다!
			키마다 키 코드 값('가상 키' 코드 값)이 정의되어 있음
			유니코드 키가 아닌 경우 키 이벤트 호출 순서
				keyPressed(), keyReleased()
				
			가상키 : 유니코드 키든 아니든 모든 키에 자바의 가상 키 코드가 정의되어 있음 (KeyEvent 클래스의 상수)
	
	입력된 키 판별	: 리스너에 전달된 KeyEvent 객체 사용
		getKeyChar() : 유니코드(문자) 알아내기 (문자키인 경우만)
		getKeyCode() : 가상키값 알아내기 (모든키에 대해)
		KeyEvent.getKeyText(int keyCode) (가상 키)에 해당하는 키의 이름 문자열 리턴
			F1 키의 경우 "F1", Shift 키의 경우 "SHIFT" 등의 문자열 리턴
	
	─────────────────────────────────────────────────────────────	
		
	키 이벤트를 받을 수 있는 조건
		모든 컴포넌트 가능하지만, 현재 포커스(focus)를 가진 컴포넌트

	포커스(focus)
		컴포넌트나 응용프로그램이 키 이벤트를 독점하는 권한
		컴포넌트에 포커스 설정 방법 : 다음 2 라인의 코드 필요
		
			컴포넌트.setFocusable(true); // 컴포넌트가 포커스를 받을 수 있도록 설정
			컴포넌트.requestFocus(); // 컴포넌트에 포커스 강제 지정

	자바플랫폼마다 실행 환경의 초기화가 서로 다를 수 있기 때문에 다음 코드가 필요함
		컴포넌트.setFocusable(true); 
		
	스윙 프레임이 만들어질 포커스를 주고자 하는 경우
		JFrame의 setVisible(true) 이후에  포커스를 주어야 함 
			setVisible(true); // 스윙 프레임 출력
			component.setFocusable(true);
			component.requestFocus(); 

	마우스로 컴포넌트를 클릭할 때 포커스 지정하는 방법
		언제든지 필요할 때 포커스 줄 수 있음
		mouseClicked() 호출시 setFocusable 과 requestFocus 지정

 */
public class MainWindow extends JFrame{
	
	// 3개의 레이블 을 담을 배열
	private JLabel [] lblMsg;

	public MainWindow() {
		setTitle("키 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());  // FlowLayout 으로

		// 키 이벤트 리스너 등록
		c.addKeyListener(new MyKeyListener());
		
		lblMsg = new JLabel[3];  // 배열 초기화
		lblMsg[0] = new JLabel(" getKeyCode() ");
		lblMsg[1] = new JLabel(" getKeyChar() ");
		lblMsg[2] = new JLabel(" getKeyText() ");

		for (int i = 0; i < lblMsg.length; i++) {
			c.add(lblMsg[i]);

			// 레이블의 바탕색, 글꼴등  설정 가능
			lblMsg[i].setOpaque(true);  // 배경색이 보이도록 지정
			lblMsg[i].setBackground(Color.YELLOW);
			lblMsg[i].setFont(new Font("궁서", Font.BOLD, 40)	); // (글꼴, style, size)
			
			
		} // end for
		// JDK 에는 기본적으로 아래 5개 폰트 제공
		// 그밖의 폰트는 시스템에 설치된 경우만 사용 가능
		// Serif, SansSerif, Dialog, DialogInput. Monospaced
		
		setSize(450, 350);
		setVisible(true);
		
		//setVisible(true) 이후에  아래와 같이 포커스를 주어야 키입력 받을수 있슴
		c.setFocusable(true);
		c.requestFocus();
		
	} // end 생성자

	// KeyListener 의 Adapter 인 KeyAdapter 사용 클래스
	class MyKeyListener extends KeyAdapter{  // KeyAdapter ->  클래스임. 추상메소드 아니고.
		@Override
		public void keyPressed(KeyEvent e) {

			int keyCode = e.getKeyCode(); // 가상 키값 (모~ 든 키에 대해 가상키값이 있음)
			char keychar = e.getKeyChar(); // 유니코드(문자키에 대해)
			
			lblMsg[0].setText(Integer.toString(keyCode));
			lblMsg[1].setText(Character.toString(keychar));
			lblMsg[2].setText(KeyEvent.getKeyText(keyCode));  // (가상키) 에 해당하는 키의 이름 문자열 리턴
			
		}
		
	}
	
	
	public static void main(String[] args) {
		new MainWindow();
	} // end main()
	
} // end class
