package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_2407_조합 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M;
	private static BigInteger [][]dp;
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		dp=new BigInteger[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<=i;j++) {
				if(i==j || j==0) dp[i][j]=new BigInteger("1");
				else dp[i][j]=dp[i-1][j-1].add(dp[i-1][j]);
			}
		}
		
		System.out.println(dp[N][M]);
	}

}
