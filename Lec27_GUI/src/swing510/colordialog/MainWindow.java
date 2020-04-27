package swing510.colordialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

/* 컬러 다이얼로그  JColorChooser
	색상 팔레트를 제공하는 모달 다이얼로그

	생성과정
		1. JColorChooser 객체 생성
		2. 컬러 다이얼로그 출력:  showDialog()
		3. 사용자가 색을 선택하였는지 확인: selectedColor



*/
public class MainWindow extends JFrame {
	Container c;

	public MainWindow() {
		setTitle("JColorChooser 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();

		// TODO
		
		
		setSize(250, 200);
		setVisible(true);
	} // end 생성자

	public static void main(String[] args) {
		new MainWindow();
	} // end main
	
} // end class
