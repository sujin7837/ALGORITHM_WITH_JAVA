package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15989_123더하기4 {

	private static BufferedReader br;
	
	private static int T, N;
	private static int [][]dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N=Integer.parseInt(br.readLine());
			dp=new int[N+1][4];
			dp[1][1]=1;
			if(N>=2) {
				dp[2][1]=1;
				dp[2][2]=1;
			}
			if(N>=3) {
				dp[3][1]=1;
				dp[3][2]=1;
				dp[3][3]=1;
			}
			
			for(int i=4;i<=N;i++) {
				dp[i][1]=dp[i-1][1];
				dp[i][2]=dp[i-2][1]+dp[i-2][2];
				dp[i][3]=dp[i-3][1]+dp[i-3][2]+dp[i-3][3];
			}
			
			System.out.println(dp[N][1]+dp[N][2]+dp[N][3]);
		}
		
	}

}
