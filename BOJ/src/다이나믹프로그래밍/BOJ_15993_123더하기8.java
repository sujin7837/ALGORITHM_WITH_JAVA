package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15993_123더하기8 {

	private static BufferedReader br;
	
	private static int T, N;
	private static long [][]dp=new long[100001][2];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N=Integer.parseInt(br.readLine());
			dp[1][0]=1;
			dp[2][0]=1;
			dp[2][1]=1;
			dp[3][0]=2;
			dp[3][1]=2;
			for(int i=4;i<=N;i++) {
				dp[i][0]=(dp[i-1][1]+dp[i-2][1]+dp[i-3][1])%1000000009;
				dp[i][1]=(dp[i-1][0]+dp[i-2][0]+dp[i-3][0])%1000000009;
			}
			
			System.out.println(dp[N][0]+" "+dp[N][1]);
		}
	}

}
