package practice.stddev;
	/*
	정수 5개를 담는 배열을 생성하고
	1 ~ 100 사이의 임의의 자연수로 초기화되게 하고,
	생성된 배열원소들을 출력하고
	
	그  배열원소의  평균, 분산, 표준편차를 구하라
	
	 */
public class StdDev {

	public static void main(String[] args) {

		int[] arr = new int[5]; // 5개의 정수를 담을 배열 생성
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100 + 1); // 1 ~ 100  사이 임의의 자연수 5개 출력
			System.out.print(arr[i] + " ");
		}
		
		System.out.println("\n평균 : " + calcAvg(arr)
						  + "\n분산 : " + calcVariance(arr)
					      + "\n표준편차 : " + calcStdDev(arr));
	} // end main

	
	/**
	 * 메소드 이름 : calcAvg
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '평균값' 리턴
	 */
	public static double calcAvg(int[] arr) {
		
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		return total / arr.length; 
	}
	
	
	/**
	 * 메소드 이름 : calcVariance
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '분산값' 리턴
	 */
	public static double calcVariance(int[] arr) {
		
		double diff = 0, diffSum = 0;
		for(int i = 0; i < arr.length; i++) {
			diff = (arr[i] - calcAvg(arr)); // 편차
			diffSum += Math.pow(diff, 2); // 편차 제곱의 합
		}
		return  diffSum / arr.length; // 편차 제곱의 평균
	}
	
	/**
	 * 메소드 이름 : calcStdDev
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '표준편차' 리턴
	 */
	public static double calcStdDev(int[] arr) {
		
		return Math.sqrt(calcVariance(arr)); // 분산의 제곱근
	}
	
	// Math.pow(calcVariance(arr), 1.0/2.0);  -> 제곱근 표현하는 다른 표현 
	

} // end class
