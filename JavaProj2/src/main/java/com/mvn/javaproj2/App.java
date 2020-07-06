package com.mvn.javaproj2;

/**
 * Hello world!
 *
 */
public class App {
	
	// 다음은 테스트와는 구분되어 개발공정 분류상으로 'Production code' 라고 한다.
	
	public String getWelcome() {
		return "welcome";
	}
	
	public String getHello() {
		return "hello";
	}
	
	public String getBye() {
		return "bye";
	}
	
	
    public static void main( String[] args )
    {
        System.out.println( "안녕하세요 JUnit" );
        
        App app = new App();
        String welcome = app.getWelcome();
        String hello = app.getHello();
		String bye = app.getBye();
        
        // 위 메소드들의 동작한 결과값을 검증하려면?  --> 이와 같이 main() 흐름에서 콘솔창 띄어봐야 했다.  
		if("welcome".contentEquals(welcome)) System.out.println(true);
		if("hello".contentEquals(hello)) System.out.println(true);
		if("bye".contentEquals(bye)) System.out.println(true);
		
		// 근데, !! JUnit 을 사용하면 일일히 이렇게 코드를 다 안 써줘도 된다. 조금 더 편하게 테스트 코드를 만들 수 있다. 
    }
}
