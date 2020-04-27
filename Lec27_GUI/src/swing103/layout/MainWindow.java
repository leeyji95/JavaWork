package swing103.layout;

/* 레이아웃 (layout)
 	
 	컨테이너마다 LayoutManager 가 존재.
 	: add 되는 컴포넌트의 '위치'와 '크기' 결정하고 '배치'함.
 	
 	컨테이너의 크기가 변하면 내부 컴포넌트들의 위치와 크기를 모두 재조정, 재배치
 	
 	LayoutManager (I)
	 	└─FlowLayout  :  왼쪽에서 오른쪽으로, 위에서 아래로 배치
	 	└─BorderLayout : 
	 	└─GridLayout
	 	└─CardLayout

 	
 	컨테이너의 디폴트 LayoutManager
 	AWT , Swing        │    디폴트 LayoutManager   
 	───────────────────┴───────────────────────────
 	Window, JWindow         BorderLayout
 	Frame, JFrame			BorderLayout
 	Dialog, JDialog			BorderLayout
 	Panel, JPanel			FlowLayout
 	Applet, JApplet			FlowLayout
 	
 	
 	컨테이너의 layout manager 설정 --> setLayout()
 	
 	
 */

public class MainWindow {
	public static void main(String[] args) {
		
		
	} // end main()
} // end class

