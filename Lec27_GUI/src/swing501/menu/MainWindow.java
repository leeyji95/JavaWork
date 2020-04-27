package swing501.menu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/* 메뉴만들기
 
	메뉴 만들기에 필요한 스윙 컴포넌트   (*ppt 참조)
		JMenuBar : 메뉴바의 기능을 하는 컴포넌트
		JMenu : 파일, 편집 등 하나의 메뉴 기능을 하는 컴포넌트
		JMenuItem : 파일 메뉴 내에 저장 등의 세부 기능을 하는 컴포넌트
		
	메뉴 만드는 과정 (*ppt 참조)
		1. JMenuBar 컴포넌트 생성
		2. JMenu 컴포넌트 생성하여 JMenuBar 에 붙이기
		3. JMenuItem 컴포넌트를 생성하여 JMenu 에 붙이기 
		4. JMenuBar 컴포넌트를 JFrame 에 붙이기
	
 
 */
public class MainWindow extends JFrame {

	public MainWindow() {
		setTitle("Menu 만들기  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createMenu(); // 메뉴 생성
		
		
		setSize(250, 200);
		setVisible(true);
	} // end 생성자
	
	void createMenu() {
		// 1. JMenuBar 생성
		JMenuBar mb = new JMenuBar();
		
		
		
		// 2. JMenu 컴포넌트 생성 -> JMenuNar 붙이기
		JMenu fileMenu = new JMenu("file");
		
		
			// 3. JMenuItem 컴포넌트 생성하여 JMenu에 붙이기
			fileMenu.add(new JMenuItem("Nuew"));
			fileMenu.add(new JMenuItem("Open"));
			fileMenu.addSeparator();  // 구분선
			fileMenu.add(new JMenuItem("Save"));
			fileMenu.add(new JMenuItem("SaveAs"));
		
		mb.add(fileMenu);
		
		mb.add(new JMenu("Edit"));
		mb.add(new JMenu("Source"));
		mb.add(new JMenu("Project"));
		mb.add(new JMenu("Run"));
		
		// 4. JMenuBar 컴포넌트를 JFrame 에 붙이기
		this.setJMenuBar(mb);   // Frame 에다가 메뉴바 붙이기
	}
	
	
	

	public static void main(String[] args) {
		new MainWindow();
	} // end main()
	
} // end class
