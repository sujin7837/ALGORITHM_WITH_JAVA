package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15992_123더하기7 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int T, N, M;
	private static long [][]dp=new long[1001][1001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			
			dp[1][1]=1;
			dp[2][1]=1;
			dp[2][2]=1;
			dp[3][1]=1;
			dp[3][2]=2;
			dp[3][3]=1;
			for(int i=4;i<=N;i++) {
				for(int j=1;j<=i;j++) {
					dp[i][j]=(dp[i-1][j-1]+dp[i-2][j-1]+dp[i-3][j-1])%1000000009;
				}
			}
			
			System.out.println(dp[N][M]);
		}
	}

}
