package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15991_123더하기6 {

	private static BufferedReader br;
	
	private static int T, N;
	private static long []dp=new long[100001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N=Integer.parseInt(br.readLine());
			dp[0]=1;
			dp[1]=1;
			dp[2]=2;
			dp[3]=2;
			dp[4]=dp[2]+dp[0];
			dp[5]=dp[3]+dp[1];
			for(int i=6;i<=N;i++) {
				dp[i]=(dp[i-2]+dp[i-4]+dp[i-6])%1000000009;
			}
			
			System.out.println((dp[N])%1000000009);
		}
	}

}
