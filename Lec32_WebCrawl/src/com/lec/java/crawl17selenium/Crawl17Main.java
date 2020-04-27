package com.lec.java.crawl17selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * Selenium 라이브러리 다운로드 (Java 버젼으로!)
 * 	https://www.seleniumhq.org/download/
 * 
 *  BuildPath 추가
 *  
 * 브라우저 드라이버 다운로드 
 *  http://chromedriver.chromium.org/downloads
 *  
 *  
 */
public class Crawl17Main {

	// WebDriver
	private WebDriver driver;
	private WebElement element;
	private String url;
	
	private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	private static final String WEB_DRIVER_PATH = "D:/JavaApp1/download/chromedriver.exe";
	
	public static void main(String[] args) {
		System.out.println("Selenium 사용");
		
		Crawl17Main app = new Crawl17Main();
		app.init();
		//app.naverLogin();
//		app.likeFacebook();
		
		app.naverRelated("파이썬");
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
	public void init() {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH); // 누군가가 webdriver 찾을때마다 이 경로 참조하겠끔 수정해줌
		
		//Driver setup
		ChromeOptions options = new ChromeOptions();

		// 크롬구동기 가동하기 전에 몇 가지 세팅작업해주는 거임
		options.setCapability("ignoreProtectedModeSettings", true);
		driver = new ChromeDriver(options); // 제어되는 브라우저 가동!
		//driver 를 통해서 브라우저 제어 
		
		
		
	}
	
	public void naverLogin() {
		String url = "https://nid.naver.com/nidlogin.login"; // 네이버 로그인 화면
		driver.get(url);  // url 주소로 이동 
		
		// 아이디 입력
		// 아이디 입력하는 엘리먼트 찾아야함.  입력해야 하기 때문에 
		element = driver.findElement(By.id("id"));
		//System.out.println(element.getSize());	
		element.sendKeys("leeyji95"); // 나의 아이디 넣기  // 키보드 타이핑
		
		// 패스워드 입력
		element = driver.findElement(By.id("pw")); //
		element.sendKeys("789456132");
		
		// 로그인 버튼 클릭 
		element = driver.findElement(By.className("btn_global")); // 버튼 엘리먼트가 담김
		element.click();  // 클릭 수행 
		
	}
	
	
	// Facebook 좋아요 클릭
	public void likeFacebook() {
		String url = "https://www.facebook.com/";
		driver.get(url);
		
		driver.findElement(By.id("email")).sendKeys("leeyji95@naver.com");
		driver.findElement(By.id("pass")).sendKeys("tlzk15070622!");
		driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		url = "https://www.facebook.com/%ED%8C%8C%EC%9D%B4%EC%8D%AC-150315075024307/";
		driver.get(url);  // 게시물로 이동
		
		// 좋아요 element 찾기
		
		
		// 종아용 element 클릭하기
		
		
		// 브라우저 제어 나 로그인이 필요한 경우 셀레니움으로 들어가야 한다. 
		
	}
		
	//query
	public void naverRelated(String keyword) {
		driver.get("https://www.naver.com");
		driver.findElement(By.id("query")).sendKeys(keyword);
		driver.findElement(By.id("query")).sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<WebElement> list = driver.findElements(By.cssSelector("._related_keyword_ul li"));
		System.out.println(list.size() + "개");
		
		for(WebElement e : list) {
			System.out.println(e.findElement(By.tagName("a")).getText().trim());
			
			
		}
		
		
		// 특별한 경우, 자동화 해야할 경우에만 사용한다. 셀레니윰은! 
		
	}
	
	

} // end class






























