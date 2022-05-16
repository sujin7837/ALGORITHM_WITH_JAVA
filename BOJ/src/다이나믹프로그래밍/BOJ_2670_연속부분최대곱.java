package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2670_연속부분최대곱 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N;
	private static double []arr, dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new double[N];
		dp=new double[N];
		
		for(int i=0;i<N;i++) arr[i]=Double.parseDouble(br.readLine());
		dp[0]=arr[0];
		
		double result=0.0;
		for(int i=1;i<N;i++) {
			dp[i]=Math.max(arr[i], dp[i-1]*arr[i]);
			if(dp[i]>result) result=dp[i];
		}
		
		System.out.printf("%.3f", result);
	}

}
