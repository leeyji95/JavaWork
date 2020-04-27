package com.lec.java.urlgetpath;

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

import com.sun.xml.internal.fastinfoset.Decoder;


public class Practice {
	
	public static final String FILEPATH = "download222"; // 파일경로 

	public static void main(String[] args) throws IOException {

		Practice app = new Practice();
		
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
		
//		System.out.println();
//		for(int i = 0; i < movUrls.length; i++) app.download1(movUrls[i]);
//		
//		System.out.println();
//		for(int i = 0; i < dataUrls.length; i++) app.download2(dataUrls[i]);
		
		System.out.println();
		for(int i = 0; i < imgUrls.length; i++) app.download3(imgUrls[i]);

	}// end main()
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------			
	// 방법1
	// URL 의 openStream()
	// 단순히 byte 스트림으로만 입력 가능
	// 파일 이름, 타입등 의 정보는 알수 없다.
	private void download1(String srcUrl) throws IOException {
		
		URL url = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedOutputStream bout = null;
		BufferedInputStream bin = null;
		
		url = new URL(srcUrl);
		in = url.openStream();
		
		String filename = fileNameFromURL(url); // 파일명 담아주기
		
		out = new FileOutputStream(FILEPATH + File.separator + filename);
		
		bin = new BufferedInputStream(in);
		bout = new BufferedOutputStream(out);
		
		while(true) {
			int data = bin.read(); // 버퍼드인풋스트림으로 읽어들이고, 
			if(data == -1) break;
			bout.write(data); 
		}
		
		bin.close();
		bout.close();
		System.out.println("다운로드: " + srcUrl + " -> " + filename);
		
		
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
	// 방법2
	// HttpURLConnection 객체 사용
	// HttpURLConnection 의 getInputStream()
	// 장점: 파일사이즈, 타입, 이름 등을 미리 알수 있다.   -> 이거에 맞는 버퍼를 사이즈에 맞게 만들 수 있다. 
	
	public void download2(String srcUrl) throws IOException{
		
		URL url = null;
		HttpURLConnection conn = null;
		InputStream in = null;
		BufferedInputStream bin = null;
		FileOutputStream out = null;
		BufferedOutputStream bout = null;
		String dstFile = null;
		
		url = new URL(srcUrl);
		conn = (HttpURLConnection)url.openConnection(); 
		
		int contentLength = conn.getContentLength(); // 파일 크기
		String contentType = conn.getContentType();  // 파일 타입
		
		
		// 파일 이름명 꺼내기!(여기가 핵심...!  URLConnection 클래스의 getHeaderField () 메소드 이용!!3
		String raw = conn.getHeaderField("Content-Disposition");
//		System.out.println(raw);
		
		// 파일이름 저장
		if(raw != null && raw.indexOf("=") != -1) {
			String fileName = raw.split("=")[1].trim();
			dstFile = URLDecoder.decode(fileName, "UTF-8");
		}
		
		
		in = conn.getInputStream();
		bin = new BufferedInputStream(in);
		out = new FileOutputStream(FILEPATH + File.separator + dstFile);
		bout = new BufferedOutputStream(out);
		
		byte [] buf = new byte[contentLength];  // 파일 크기만큼의 버퍼 준비
		int byteImg; // 읽어들인 이미지 바이트 수!
		while((byteImg = bin.read(buf)) != -1) {
			bout.write(buf, 0, byteImg);
		}
		
		bin.close();
		bout.close();
		
		System.out.println("다운로드: " + srcUrl + "\n\t -> " + dstFile);
		System.out.println("\t파일크기: " + contentLength + "bytes \t파일종류: " + contentType);
		
		
		
	}
	
	
// 방법3
// ImageIO 객체 사용
	public void download3(String srcUrl) throws IOException{
		String dstFile = null;
		
		URL url = new URL(srcUrl);
		dstFile = fileNameFromURL(url);
		
		BufferedImage imgData = ImageIO.read(url); // BufferedImage extends ImageIO
		// 특정 url 로부터 이미지 읽어오는 객체, BufferedImage 타입으로 리턴한다.
		
		// 파일 객체 만들어 주기
		File file = new File(FILEPATH + File.separator + dstFile);
		
		ImageIO.write(imgData, "jpg", file);
		System.out.println("다운로드: " + srcUrl + "---→ " + dstFile);
		
		
		
	}
	
	
	// 파일명 메소드 
	public String fileNameFromURL(URL url) {
		return url.getPath().substring(url.getPath().lastIndexOf('/') +1);
	}
	
	

} // end class
