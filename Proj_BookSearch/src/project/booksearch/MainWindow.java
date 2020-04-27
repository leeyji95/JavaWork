package project.booksearch;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainWindow {

	private JFrame frame;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JScrollPane scrollPane1, scrollPane2, scrollPane3;
	private JLabel lblDate;

	private static Crawler cr = null; // 크롤러 객체 --- -> main 에서 인스턴스 생성. Crawler.getInstance(); // 크롤러 인스턴스 생성  
	// 가로 80세로 110 으로 모두 통일(썸네일 이미지 크기)
	private static final int ICON_WIDTH = 80;
	private static final int ICON_HEIGHT = 110;
	
	private SearchResult searchResult = null;
	private boolean isCrawlDone = false; // 크롤링 완료 여부(크롤링을 하고 있는지에 대한 여부,  크롤링 할때 조금 시간이 걸리므로)

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();

					// 크롤러 인스턴스 생성
					cr = Crawler.getInstance(); // 크롤러 인스턴스 생성  
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} // end main()

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1078, 745);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmSave = new JMenuItem("Save");
		// 메뉴 선택하면 파일 저장
		mntmSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 데이터 저장하기
				saveData();
				
			}
		});
		mnFile.add(mntmSave);
		
		JMenuItem mnuOpen = new JMenuItem("Open");
		// 메뉴 선택하면 파일 읽기
		mnuOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 데이터 저장하기
				loadData();
				
			}
		});
		
		mnFile.add(mnuOpen);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(24, 10, 397, 61);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("검색어");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림체", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 10, 74, 41);
		panel.add(lblNewLabel);

		tfSearch = new JTextField();
		// 검색어 입력후 Enter 를 눌러도 크롤링
		// 이벤트 리스너 사용
		tfSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 여기에다가 크롤링 하면 됨. 
				crawlStores(tfSearch.getText().trim()); // 3개 북스토어 크롤링
			}
		});

		tfSearch.setText("자바");
		tfSearch.setBounds(98, 10, 116, 42);
		panel.add(tfSearch);
		tfSearch.setColumns(10);

		btnSearch = new JButton("검색");
		
		// [검색] 버튼을 눌러도 크롤링 시작
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				crawlStores(tfSearch.getText().trim()); // 3개 북스토어 크롤링
			}
		});

		btnSearch.setBounds(226, 16, 74, 31);
		panel.add(btnSearch);

		lblDate = new JLabel("");
		lblDate.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblDate.setOpaque(true);
		lblDate.setBackground(Color.LIGHT_GRAY);
		lblDate.setBounds(24, 82, 311, 26);
		frame.getContentPane().add(lblDate);

		JLabel lblStore1 = new JLabel("YES24");
		lblStore1.setHorizontalAlignment(SwingConstants.CENTER);
		lblStore1.setOpaque(true);
		lblStore1.setBackground(Color.YELLOW);
		lblStore1.setFont(new Font("굴림", Font.BOLD, 18));
		lblStore1.setBounds(23, 119, 107, 31);
		frame.getContentPane().add(lblStore1);

		scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(24, 170, 309, 450);
		frame.getContentPane().add(scrollPane1);
		
		JLabel lblStore2 = new JLabel("Aladdin");
		lblStore2.setOpaque(true);
		lblStore2.setHorizontalAlignment(SwingConstants.CENTER);
		lblStore2.setFont(new Font("굴림", Font.BOLD, 18));
		lblStore2.setBackground(Color.YELLOW);
		lblStore2.setBounds(347, 119, 107, 31);
		frame.getContentPane().add(lblStore2);
		
		scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(350, 170, 309, 450);
		frame.getContentPane().add(scrollPane2);
		
		JLabel lblStore3 = new JLabel("Interpark");
		lblStore3.setOpaque(true);
		lblStore3.setHorizontalAlignment(SwingConstants.CENTER);
		lblStore3.setFont(new Font("굴림", Font.BOLD, 18));
		lblStore3.setBackground(Color.YELLOW);
		lblStore3.setBounds(666, 119, 107, 31);
		frame.getContentPane().add(lblStore3);
		
		scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(677, 170, 309, 450);
		frame.getContentPane().add(scrollPane3);
	} // end initialize()

	// 3개 BookStore 클롤링 (크롤링 하는 메소드 만들기)
	private void crawlStores(String search) { // 검색어(search)로 크롤링 시작
		isCrawlDone = false;
		
		Date now = new Date(); // 크롤링 시작 일시
		searchResult = new SearchResult(search, now);
		
		// 크롤링 시작일시 + 검색어는 화면에 표시
		lblDate.setText(search + " : " +  new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(now));
		
		// 크롤링 시작: 각각은 개변적인 쓰레드로 진행
		// Yes24
		Thread th1 = new Thread(new Runnable() {
			public void run() {
				searchResult.setStoreYes24(cr.crawlStore(search, C.YES24, new OnCompleteListener() {
					// yes24 크롤링 완료후 수행코드 
					@Override
					public void complete(InfoStore infoStore) {
						// ScrollPane 업데이트  
						scrollPane1.setViewportView(buildList(infoStore));
					}
				}));
			}
		});
		th1.start();
		
		// Aladdin
		Thread th2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				searchResult.setStoreAladdin(cr.crawlStore(search, C.ALADDIN, new OnCompleteListener() {
					// 크롤링 완료후 수행코드
					@Override
					public void complete(InfoStore infoStore) {
						// ScrollPane2 업데이트
						scrollPane2.setViewportView(buildList(infoStore));
					}
				}));
				
			}
		});
		th2.start();
		
		//Interpark
		Thread th3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				searchResult.setStoreAladdin(cr.crawlStore(search, C.INTERPARK, new OnCompleteListener() {
					// 크롤링 완료후 수행코드
					@Override
					public void complete(InfoStore infoStore) {
						// ScrollPane3 업데이트
						scrollPane3.setViewportView(buildList(infoStore));
					}
				}));
				
			}
		});
		th3.start();
		
		try {
			th1.join();
			th2.join();
			th3.join();
			
			isCrawlDone = true; // 3 개 스토 크롤링 완료후 종료
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		
		// 테스트
		//System.out.println(searchResult);
		
		
	} // ebd crawlStores()
	
	

	// JList를 만들기
	private JList<InfoBook> buildList(InfoStore infoStore){
		// 데이터를 관리하는 모델이 필요함. 그 객체가defaulf~
		DefaultListModel<InfoBook> dlm = new DefaultListModel<InfoBook>();
		
		// JList 생성
				JList<InfoBook> list = new JList<InfoBook>(dlm);
				// 각 리스트 아이템 그리기
				list.setCellRenderer(new ListEntryCellRenderer());
				
				try {			
					for(InfoBook e : infoStore.getList()) {
						ImageIcon icon = resizeImage(new ImageIcon(ImageIO.read(new URL(e.getImgUrl()))));
						e.setThumbnail(icon);
						
						dlm.addElement(e);   // ListModel 에 list entry 추가
					}
					
					// 더블클릭시 브라우저 오픈   
					list.addMouseListener(new MouseAdapter() {

						private void mouseClicked(MouseEvent e) {
							JList<InfoBook> list = (JList<InfoBook>)e.getSource();
							if(e.getClickCount() == 2) { // 더블클릭이면!
								//리스트 상의 몇번째 index 인지
								int index = list.locationToIndex(e.getPoint());
										
								// model 에서 index 번째 데이터 ListEntry 불러와서, 담겨있는 url 추출
								String url = ((InfoBook)list.getModel().getElementAt(index)).getUrl();
								
								// 기본브라우저로 해당 북 상세 페이지 오픈
								// java.awt.Desktop 사용
								// 우선 기본브라우저 존재 여부 체크한 뒤 실행
								if(Desktop.isDesktopSupported() && 
										Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
									
									// 브라우저 오픈
									Desktop.getDesktop().browse(new URL(url));
								}
							}
						}
					});
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				return list;
			}
	
	// ImageIcon 크기(size) 변경하기
	private ImageIcon resizeImage(ImageIcon imageIcon) {
		// 1. ImageIcon --> Image 객체로 변환
		Image img = imageIcon.getImage();
		// 2. Image 크기 변화
		img = img.getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH);
		// 3. Image --> ImageIcon 변환 후 리턴해주면 됨.
		return new ImageIcon(img);
	}
	
	
	
	// 파일 저장하기
	private void saveData() {
		JFileChooser chooser; // 파일 대화상자 열기
		
		if(isCrawlDone) {
			// 기본 저장파일 이름 만들기
			// yyyyMMddhhmmss_검색어.crawl
			String defaultFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(searchResult.getDate()) + "-" + searchResult.getSearch() + ".crawl";
			
			// 대화상자 생성, Current Working Directory  기준으로 대화상자 생성
			chooser  = new JFileChooser(new File(System.getProperty("user,dir")));
			
			chooser.setDialogTitle("결과 저장하기");
			
			// 디폴트 파일명 제시 (자동 파일이름명 적혀져 있어서 나는 오케이만 누르면 되는거)
			chooser.setSelectedFile(new File(new File(System.getProperty("user,dir")), defaultFileName));
			
			// 파일 필터 객체 생성
			FileNameExtensionFilter filter = new FileNameExtensionFilter("크롤링데이터(*.crawl)", "crawl");
			chooser.setFileFilter(filter);
			
			// 저장하기 대화상자 보이기
			int ref = chooser.showSaveDialog(null);
			
			if(ref != JFileChooser.APPROVE_OPTION) { // 파일 선택 안했으면
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			String filePath = chooser.getSelectedFile().getPath();
			if(!filePath.endsWith(".crawl")) {
				filePath += ".crawl";
			}
			
			// 크롤링 결과 저장 
			cr.saveData(filePath, searchResult);
			
			
			JOptionPane.showMessageDialog(null, "저장완료", "완료", JOptionPane.PLAIN_MESSAGE);
			
		}else {
			JOptionPane.showMessageDialog(null, "아직 크롤링 완료 안됨", "경고", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	// 파일 읽어오기  < == 읽고 나서 리스트 까지 업데이트 
	private void loadData() {
		JFileChooser chooser;
		chooser  = new JFileChooser(new File(System.getProperty("user,dir")));
		chooser.setDialogTitle("불러오기");
		
		
		// 파일 필터 객체 생성
		FileNameExtensionFilter filter = new FileNameExtensionFilter("크롤링데이터(*.crawl)", "crawl");
		chooser.setFileFilter(filter);
		
		// 파일 열기 대화상자 보이기
		int ref = chooser.showOpenDialog(null);
				
				// 사용자가 파일 선택 안했으면 
		if(ref != JFileChooser.APPROVE_OPTION) { // 파일 선택 안했으면
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		String filePath = chooser.getSelectedFile().getPath();
		
		cr.loadData(filePath); // 파일 읽어들여오기
		
		// 파일 읽어오기
		searchResult= cr.loadData(filePath);
		
		// 읽어들인 데이터로 화면 업데이트
		String search = searchResult.getSearch();
		Date now = searchResult.getDate();
		lblDate.setText(search + " : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now));  // 이전에 읽어들인 파일
		
		scrollPane1.setViewportView(buildList(searchResult.getStoreYes24()));
		scrollPane2.setViewportView(buildList(searchResult.getStoreAladdin()));
		scrollPane3.setViewportView(buildList(searchResult.getStoreInterpark()));
		
		
	}
	
} // end class


// 각각의 리스트에 있는  ListCellRenderer 객체
// 각 List 아이템들을 보여조기(그려주기) 위한 객체 정의
// JList 의 각 아이템에 보여질 데이터 객체는 InfoBook(이를 list entry 혹운 list item 이라함)

class ListEntryCellRenderer extends JLabel implements ListCellRenderer<InfoBook>{

	@Override
	public Component getListCellRendererComponent(JList<? extends InfoBook> list, InfoBook value, int index,
			boolean isSelected, boolean cellHasFocus) {
		// 리스트의 아이템의 텍스트와 아이콘 설정
//		/ 줄바꿈 하려면 아래와 같이 <html> 태그 사용해야 함
		
		setText("<html>" + value.getBookTitle() + "<br>" + (int)value.getPrice() + "원</html>" +
		setIcon(value.getThumbnail()));
		
		if(isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		}else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		
		setEnabled(list.isEnabled());
		setFont(list.getFont());
		setOpaque(true);
		
		return this;
	}
	
}



