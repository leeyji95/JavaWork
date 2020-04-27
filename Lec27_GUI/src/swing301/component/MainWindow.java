package swing301.component;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/* 기본적인 컴포넌트 :

	GUI를 구성하는 2 가지 방법
		1. 컴포넌트 기반 GUI 프로그래밍
			스윙 패키지에 주어진 GUI 컴포넌트 이용
			GUI 구성이 쉽다.
			자바 패키지에 제공하는 GUI 컴포넌트 한계
			일반적인 GUI 프로그램에 적합
		2. 그래픽 기반 GUI 프로그래밍
			선, 원, 도형, 이미지를 직접 그려는 그래픽 화면 구성
			개발자의 작업 부담 높음
			자바 패키지에 없는 독특한 GUI 구성 가능
			게임 등 자유로운 GUI

	기초적인 스윙 컴포넌트와 상속 관계 (*ppt)
	
	스윙 컴포넌트 의 공통 메소드들 (JComponent 의 메소드)  (*ppt)
 */
public class MainWindow extends JFrame {

	public MainWindow() {
		super("JComponent의 공통 메소드 예제");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// TODO
		
		
		setSize(450,300);
		setVisible(true);
	} // end 생성자
	
	public static void main(String[] args) {
		new MainWindow();
	} // end main()
	
} // end class
