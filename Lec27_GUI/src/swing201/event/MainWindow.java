package swing201.event;
/*
 * ~할 때(event) 어떻게 동작(event listner)한다.   
 * 동작을 등록시킨다.  
 * 어떻게 동작할 지 코드 작성하는 것을 이벤트 리스너 라고 하고 
 * 우리가 그것을 작성해야 한다. 
 * 
 */
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainWindow {
	
	public static void main(String[] args) {
		
		new MyFrame();
		
	} // end main
} // end class

class MyFrame extends JFrame{
	
	public MyFrame() {
		setTitle("Action 이벤트 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		// 방법1 : 별도의 리스너 작성
		JButton btn1 = new JButton("Action1");
		btn1.addActionListener(new MyListener1()); // Action 리스너 장착   => 이게 바로 버튼 클릭 시 메소드 알아서 호출해주는 동작 소스,
		
		// 방법2 inner class
		JButton btn2 = new JButton("Action2");
		btn2.addActionListener(new MyListner2());

		// 방법3 : 익명 클래스 사용
		JButton btn3 = new JButton("Action3");
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
					System.out.println(e.getActionCommand());
					System.out.println("Event type : " + e.getID());
					
					JButton btn = (JButton)e.getSource(); // 이벤트가 발생한 객체 리턴
					
					if(btn.getText().equals("Action3")){
						btn.setText("액션3");
					} else {
						btn.setText("Action3");	
					}
			}
		});
		
		// 방법4 : 람다식 사용
		JButton btn4 = new JButton("Action4");
		btn4.addActionListener((e)->{
			System.out.println(e.getActionCommand());
			System.out.println("Event type : " + e.getID());
			
			JButton btn = (JButton)e.getSource(); // 이벤트가 발생한 객체 리턴
			
			if(btn.getText().equals("Action4")){
				btn.setText("액션4");
			} else {
				btn.setText("Action4");	
			}
		});
		
		
		c.add(btn1);
		c.add(btn2);
		c.add(btn3);
		c.add(btn4);
		
		setSize(450, 150);
		setVisible(true);	
	} // end 생성자
	
	// 방법2 inner class
	class MyListner2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			System.out.println("Event type : " + e.getID());
			
			JButton btn = (JButton)e.getSource(); // 이벤트가 발생한 객체 리턴
			
			if(btn.getText().equals("Action2")){
				btn.setText("액션2");
			} else {
				btn.setText("Action2");	
			}
			
		}
	}
	
} // end MyFrame


//방법 1 별도의 Listener 클래스 만들어서 사용.
class MyListener1 implements ActionListener{
	
	// 버튼이 클릭 되었을 떄 수행되는 리스너 메소드
	@Override
	public void actionPerformed(ActionEvent e) {  // 얘는 버튼이 눌렸을 때 수행될 것
		System.out.println(e.getActionCommand());
		
		
		
	}
}

