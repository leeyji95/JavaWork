package swing310.list;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/* JList<E>, 리스트 컴포넌트 
	여러 개의 아이템을 리스트 형식으로 보여주고 선택하는 컴포넌트
	JComboBox<E>와 기본적으로 같은 기능
	JScrollPane에 Jlist<E>를 삽입하여 스크롤 가능

	JList<E>
		JDK7부터 제네릭 리스트로 바뀜
		<E>에 지정된 타입의 객체만 저장하는 리스트
		
	생성자 
		JList<E>() 빈 리스트
		JList<E>(Vector)  벡터로부터 아이템 공급 받는 리스트
		JList<E>(Object []) 배열로 부터 아이템 공급 받는 리스트
		
	리스트 생성하는 방법	
		1. 객체 배열로 아이템 제공
		2. Vector로 아이템 제공
		3. 빈 JList 컴포넌트를 생성하고 setListData()로 아이템 제공

 */

public class MainWindow extends JFrame {
	private String[] fruits = { "apple", "banana", "kiwi", "mango", "pear",
			"peach", "berry", "strawberry",	"blackberry" };
	private ImageIcon[] images = { 
			new ImageIcon("images/icon1.png"), 
			new ImageIcon("images/icon2.png"),
			new ImageIcon("images/icon3.png"), 
			new ImageIcon("images/icon4.png")
		};
	

	public MainWindow() {
		setTitle("리스트 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// 문자열 리스트
		JList<String> strList = new JList<String>(fruits); // String 배열 아이템
		c.add(strList);
		
		// 이미지 리스트
		JList<ImageIcon> imageList = new JList<ImageIcon>();
		imageList.setListData(images);
		c.add(imageList);
		
		// 스크롤 가능한 리스트 --> JScrollPane 에 추가해야함
		JList<String> scrollList = new JList<String>(fruits);
		c.add(new JScrollPane(scrollList));
		
		
		

		setSize(300, 300);
		setVisible(true);
	} // end

	public static void main(String[] args) {
		new MainWindow();
	} // end main

} // end class
