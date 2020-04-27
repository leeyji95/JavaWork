package swing311.listchange;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/* 리스트의 아이템 변경
	JList<E>(Vector listData)나 JList<E>(Object [] listData)로 
	리스트가 생성되고 나면 벡터나 배열을 수정해도 리스트 수정 안됨
	
	리스트를 수정하는 간단한 방법
		JList<E>의 setListData()를 호출
		리스트에 수정된 벡터나 배열을 새로 달아주는 방법

 */
public class MainWindow extends JFrame {
	
	private JTextField tf = new JTextField(10);   // 사용자 입력
	private Vector<String> v = new Vector<String>();  // ArrayList 같은 비슷한 것
	private JList<String> nameList = new JList<String>(v);
	
	public MainWindow() {
		setTitle("리스트 변경 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("이름 입력 후 <Enter> 키"));
		c.add(tf);   // textfield  추가
		
		// Vector 에다가 데이터 추가
		
		v.add("박승원");
		v.add("이에지");
		
		nameList.setVisibleRowCount(5);
		nameList.setFixedCellWidth(100);
		c.add(new JScrollPane(nameList));
		
		// 실행 -> 아무것도 반응 없음.  -> 그냥   텍스트 추가 되게끔
		
		// TextField 의 <Enter> 키 처리 
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource(); // 이벤트 리스너는 겟소스 메소드로 뽑고
				v.add(0, t.getText()); // 사용자 텍스트는 t. getText() 로 뽑고, 그걸 벡터에 추가!~!   // 데이터 변경 코드  // 그리고 add 메소드는 입력시 항상 뒤로 가게끔 출력 된다. 앞으로 가게 하려면 ? 0 추가
				t.setText(""); // 입력 후 아무것도 없는 상태로 만들기
				nameList.setListData(v);  // 업데이트된 Vector 를 리스트에 set(갱신)
			}
			
		});
		
		
		
		setSize(300,300);
		setVisible(true);

	} // end 생성자
	
	public static void main(String [] args) {
		new MainWindow();
	} // end main()
	
} // end class
