package com.lec.java.crawl06imagedownload;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

import javax.imageio.ImageIO;


// File17 에서 우리는 텍스트로만 구성된 거를 읽어왔었다.  

// 텍스트가 아닌 이미지, 오디오, 비디오 같은 것들은 어떻게 크롤링 할까? 
// 어떠한 타입도 다운도르 받을 수 있도록 코드 짤 수 있다. 


/* 웹에서 이미지와 같은 바이너리 형태 리소스 다운로드 받기
 * 
 * 방법1 : URL의 openStream() → InputStream 
 * 방법2 : HttpURLConnection의 getInputStream() → InputStream
 * 방법3 : ImageIO 객체 사용 : 이미지객체
 * 
 *  <프로젝트에 download 폴더 만들고 진행하세요> 
 * 
 * 예제에 사용한 미디어 출처
 *  https://www.w3schools.com/html/html5_video.asp
 *  https://www.w3schools.com/html/html5_audio.asp
 *  https://www.w3schools.com/howto/howto_css_fullscreen_video.asp
 *  
 * 예제에 사용한 이미지 출처
 * 	https://www.w3schools.com/css/css_image_gallery.asp
 * 
 * 예제에 사용한 데이터 출처
 *   공공데이터 포털 - 파일데이터
 *   https://www.data.go.kr/search/index.do?index=DATA&query=&currentPage=1&countPerPage=10&sortType=VIEW_COUNT
 */

public class Crawl06Main {
	
	public static final String FILEPATH = "download"; // 파일 경로

	public static void main(String[] args) throws IOException {
		System.out.println("웹 리소스 다운로드");
		
		
		Crawl06Main app = new Crawl06Main();
		
		String [] movUrls = { // 파일이름 으로 찢어내서  그 파일명으로 내 컴퓨터에 저장.
				"https://www.w3schools.com/html/movie.mp4",   // 영상
				"https://www.w3schools.com/howto/rain.mp4",
				"https://www.w3schools.com/html/mov_bbb.mp4",
				"https://www.w3schools.com/html/horse.ogg"    // 음성
			};
		
		// 데이터. URL 에 파일명이 없는 형태 // response 안에 파일명이 저장되어 있음(공공데이터의 경우..). 
		String [] dataUrls = { 
				"https://www.data.go.kr/dataset/fileDownload.do?atchFileId=FILE_000000001524257&fileDetailSn=1&publicDataDetailPk=uddi:af2e59b7-9f3a-4624-94ae-9ac9d785b62b", // https://www.data.go.kr/dataset/15007122/fileData.do 건강검진정보  
				"https://www.data.go.kr/dataset/fileDownload.do?atchFileId=FILE_000000001562989&fileDetailSn=1&publicDataDetailPk=uddi:e9317e2f-fb83-43c8-914e-85ac6cca6736_201909101530", // https://www.data.go.kr/dataset/3038489/fileData.do  교통사고통계
				"https://www.data.go.kr/dataset/fileDownload.do?atchFileId=FILE_000000001585803&fileDetailSn=1&publicDataDetailPk=uddi:7a68a482-4e3f-4cf8-851a-d4857fa2bff7"  // https://www.data.go.kr/dataset/3041272/fileData.do 전국산업단지현황통계 
			};

		// 이미지, jpg
		String [] imgUrls = { 
				"https://www.w3schools.com/css/img_5terre.jpg",
				"https://www.w3schools.com/css/img_forest.jpg", 
				"https://www.w3schools.com/css/img_lights.jpg",
				"https://www.w3schools.com/css/img_mountains.jpg"
			};
		
		
//		for(int i = 0; i < movUrls.length; i++) app.download1(movUrls[i]);
		
//		System.out.println();
//		for(int i = 0; i < dataUrls.length; i++) app.download2(dataUrls[i]);
		
		System.out.println();
		for(int i = 0; i < imgUrls.length; i++) app.download3(imgUrls[i]);
			
		
		
		
		System.out.println("\n프로그램 종료");
	}  // end main()

	
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------			
	// 방법1
	// URL 의 openStream()
	// 단순히 byte 스트림으로만 입력 가능
	// 파일 이름, 타입등 의 정보는 알수 없다.
	public void download1(String srcUrl) throws IOException { // 특정 url  매개변수로 받아서, 파일이름 찢어내고, 빨대꽂아서  읽어들이고  내 파일경로에 저장함. 

		URL url = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedOutputStream bout = null;
		BufferedInputStream bin = null;
		String dstFile = null; // 파일명 담기위한 변수 ....   download  폴더 하나 만들어 놓구 여기서 다운로드 받은 것들 다 넣어보자
		
		url = new URL(srcUrl);
		in = url.openStream();   // URL 로부터 -> InputStream 뽑아냄!(빨대꽂음!)  // return openConnection().getInputStream(); (InputStream 타입으로 리턴)
		
		dstFile = fileNameFromURl(url);  // 파일명 찢어내고, dstFile 에 담기
		
		out = new FileOutputStream(FILEPATH + File.separator + dstFile); // 저장할 파일 경로  -> download + / + 파일명
		
		bin = new BufferedInputStream(in);
		bout = new BufferedOutputStream(out);
		
		while(true) {
			int data = bin.read(); // 읽어 들이고
			if(data == -1) break;
			bout.write(data);  // 파일 저장하고
		}
		
		bin.close();
		bout.close();
		
		System.out.println("다운로드: " + srcUrl + " → " + dstFile);
		

	}  // end download1()
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
	
	// 방법2   (공공데이터의 경우 주로 이 방법 사용. 왜?  url 에 기본적으로  파일명이 나와있지 않으므로!)
	// HttpURLConnection 객체 사용
	// HttpURLConnection 의 getInputStream()
	// 장점: 파일사이즈, 타입, 이름 등을 미리 알수 있다.   -> 이거에 맞는 버퍼를 사이즈에 맞게 만들 수 있다. 
	
	public void download2(String srcUrl) throws IOException {
		
		URL url = null;
		HttpURLConnection conn = null;
		InputStream in = null;
		BufferedInputStream bin = null;
		FileOutputStream out = null;
		BufferedOutputStream bout = null;
		String dstFile = null;
		
		
		url = new URL(srcUrl);									// openconnection 은 url 연결 메소드 라고 생각
		conn = (HttpURLConnection)url.openConnection();  // openConnection() 은 URLConnection 타입으로 리턴
		
		// 파일크기와 타입
		int contentLength = conn.getContentLength();  // 파일 크기 알아낼 수 있음.!! (핵심)
		String contentType = conn.getContentType(); // 파일종류 (웹에서 많이 쓰는) MIME-TYPE 확인 가능 // application/octet;charset=utf-8  -->  세미콜론 전으로 보아야함. 이거는 어떤 타입이다... 특별히 정할 수 없는 binary 타입은 'application/octet' 이런식으로 나타냄 (기본값)
		// https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/MIME_types  << MIME 타입 참조 >>
		
//		System.out.println(contentLength + "\t" + contentType);
		
	
		// 다운로드 받는 파일 이름 확인 가능(파일명)
		String raw = conn.getHeaderField("Content-Disposition"); //attachment;filename=%EA%B1%B4%EA%B0%95%EA%B2%80%EC%A7%84%EC%A0%95%EB%B3%B4%282017%29.zip   ~~한글~~  점 zip  -> 아무튼 이게, response 에 담겨있다. 여기서 우리는 파일명만 필요.
//		System.out.println(raw);
		/* conn.getHeaderField("Content-Disposition")  이런식으로 출력됨
attachment;filename=%EA%B1%B4%EA%B0%95%EA%B2%80%EC%A7%84%EC%A0%95%EB%B3%B4%282017%29.zip
attachment;filename=%EB%8F%84%EB%A1%9C%EA%B5%90%ED%86%B5%EA%B3%B5%EB%8B%A8_%EC%9B%94%EB%B3%84_%EC%A3%BC%EC%95%BC%EB%B3%84%20%EA%B5%90%ED%86%B5%EC%82%AC%EA%B3%A0%282013%29_20190910.csv
attachment;filename=%ED%95%9C%EA%B5%AD%EC%82%B0%EC%97%85%EB%8B%A8%EC%A7%80%EA%B3%B5%EB%8B%A8_%EC%A0%84%EA%B5%AD%EC%82%B0%EC%97%85%EB%8B%A8%EC%A7%80%ED%98%84%ED%99%A9%ED%86%B5%EA%B3%84_2019%EB%85%842%EB%B6%84%EA%B8%B0.zip
		 */
		
		if(raw != null && raw.indexOf("=") != -1) { // raw 자체가 null이 아니어야 하고, "=" 을 발견하면(특정문자 발견하지 못하면 -1리턴)  true.
			String fileName = raw.split("=")[1].trim();
			dstFile = URLDecoder.decode(fileName, "UTF-8"); // 디코딩(한글로 바꾸자)
		}
		
		
		in = conn.getInputStream();
		bin = new BufferedInputStream(in);
		out = new FileOutputStream(FILEPATH + File.separator + dstFile); 
		bout = new BufferedOutputStream(out);
		
		byte [] buf = new byte[contentLength]; // 다운로드 받을 파일크기만큼의 버퍼 준비!
		int byteImg;  // 읽어들인 이미지 바이트 수!!
		while((byteImg = bin.read(buf)) != -1) {
			bout.write(buf, 0, byteImg);
		}
		
		bout.close();
		bin.close();
		
		System.out.println("다운로드: "  + srcUrl + "\n\t ----→ " + dstFile);
		System.out.println("\t파일크기: " + contentLength + "bytes \t파일종류:  "+ contentType);
		
	} // end download2()
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------			
	// 방법3
	// ImageIO 객체 사용
	public void download3(String srcUrl) throws IOException {
		
		String dstFile = null;
		
		URL url = new URL(srcUrl);
		dstFile = fileNameFromURl(url);
		
		// URL 객체 생성하고, 파일명 짤라내고 바로 읽고 저장하는 동작! 
		BufferedImage imgData = ImageIO.read(url); // 특정 url 로부터  이미지 주소 읽어옴. // ImageIO 클래스의 read()메소드를 통해 읽어들이고, BufferedImage 타입으로 리턴한다.
		// BufferedImage extends ImageIO
		
		// ImageIO 객체의 write() 메소드로 저장할 떄, 읽어들인 이미지주소를  File 타입으로 저장하기 위해서 만들어줌.
		File file = new File(FILEPATH + File.separator + dstFile);
		ImageIO.write(imgData, "jpg", file);  // 어떤 이미지를? 어떤 형식으로? 어떤 타입으로 저장할거? 
		
		System.out.println("다운로드: " + srcUrl + "---→ " + dstFile);
		System.out.println("\t" + imgData.getWidth() + " x " + imgData.getHeight() );
		
				
	} // end download3()
	
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------				
	
	
	
	
	
	// url 에서 파일명 추출하는 메소드  (파일명만 짤라내는 메소드 만들어주고~)
	public String fileNameFromURl(URL url) {
		return url.getPath().substring(url.getPath().lastIndexOf('/') + 1);
	}
	
	
	
	
} // end class
