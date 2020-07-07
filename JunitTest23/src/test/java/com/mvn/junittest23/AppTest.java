package com.mvn.junittest23;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	private App app = new App();
	public static final String TEST_DIR = "TEST";
	public static final String TEST_FILE = "report.txt";
	public static final String FILEPATH = "TEST/report.txt";

	// 실습 1
	@Test
	public void test1() {

//		int[] arr1 = { 3, 4, 5, 1, 2 };
//		int[] arr2 = { 1, 4, 2, 5, 3 };
//		int[] arr3 = { 5, 3, 1, 2, 4 };
//		int[] arr4 = { 3, 5, 4, 1, 2 };
//		int[] arr5 = { 2, 5, 3, 4, 1 };

//		app.sortArr(arr1);
//		app.sortArr(arr2);
//		app.sortArr(arr3);
//		app.sortArr(arr4);
//		app.sortArr(arr5);

		int[] arr = new int[] { 34, 55, 2, 13, 67 };
		boolean asc = false;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1])
				asc = true;
		}

		if (asc) {
			app.sortArr(arr);
			System.out.println("테스트 통과 !!");
		} else {
			System.out.println("테스트 실패..");
		}	
	}

	// 실습 2
	@Test
	public void test2() {
		String path = System.getProperty("user.dir") + File.separator + TEST_DIR; // "/TEST"
		System.out.println("절대경로: " + path);

//----------------------- 폴더 생성 ------------------------------------------
		File f = new File(path);
		if (!f.exists()) {
			if (f.mkdir()) {
				System.out.println("폴더 생성 성공!");
			} else {
				System.out.println("폴더 생성 실패..");
			}
		} else {
			System.out.println("폴더가 이미 존재합니다!");
		}
//----------------------- 파일 txt 생성 ------------------------------------------
		// 파일 생성 : createNewFile()
		File f2 = new File(f, TEST_FILE);
		System.out.println(f2.getAbsolutePath());

		if (!f2.exists()) { // 파일이 존재하는지부터 체크
			try {
				if (f2.createNewFile()) {
					System.out.println("파일 생성 성공!");
				} else {
					System.out.println("파일 생성 실패..");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("파일이 이미 존재합니다");
		}

//------------------------ 파일에 저장하기 ------------------------
		FileWriter fw = null;
		PrintWriter out = null;
		BufferedWriter bw = null;

		int[] arr1 = { 13, 45, 56, 23, 11 };
		int[] arr2 = { 5, -3, 20, 22, 55 };
		int[] arr3 = { 4, -8, 1, 0, 8 };

		int max1 = app.max(arr1);
		int min1 = app.min(arr1);

		int max2 = app.max(arr2);
		int min2 = app.min(arr2);

		int max3 = app.max(arr3);
		int min3 = app.min(arr3);

		try {
			// 데이터 저장하기
			out = new PrintWriter(new BufferedWriter(new FileWriter(FILEPATH)));
			out.println("최대값1: " + max1 + "| 최소값 1: " + min1);
			out.println("최대값2: " + max2 + "| 최소값 2: " + min2);
			out.println("최대값3: " + max3 + "| 최소값 3: " + min3);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}

	} // end test2()
} // end AppTest
