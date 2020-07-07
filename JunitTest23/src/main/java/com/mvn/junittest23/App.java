package com.mvn.junittest23;

import java.util.Arrays;
import java.util.regex.Pattern;

public class App {

	// 실습 1
	public void sortArr(int[] arr) {
		
		Arrays.sort(arr); // 오름차순으로 정렬
		System.out.println(Arrays.toString(arr));
		
	}

	// 실습 2 
	public int max(int[] arr) {

		int max = arr[0];
		for (int i = 1; i < arr.length; i++) { // 여기서 int i = """"1 """ 부터....!! 데이터 5개니까
			if (max < arr[i])
				max = arr[i];
		}
		return max;
	}

	public int min(int[] arr) {

		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (min > arr[i])
				min = arr[i];
		}
		return min;
	}

	// 실습 3
	public String toNumber(String str) {

		String regex = "^01([0|1|6|7|8|9]?)[-]?([0-9]{3,4})[-]?([0-9]{4})$";

		if (Pattern.compile(regex).matcher(str).matches()) { 
			System.out.println("매칭 O");
			str = str.replace("-", "");
		} else {
			System.out.println("매칭 X");
		}
		
		return str;
	}

}
