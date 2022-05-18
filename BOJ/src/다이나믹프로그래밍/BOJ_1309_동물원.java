package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1309_동물원 {

	private static BufferedReader br;
	
	private static int N;
	private static int [][]dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		dp=new int[N+1][3];	// 0: 00, 1: 01, 2: 10

		dp[1][0]=1;
		dp[1][1]=1;
		dp[1][2]=1;
		for(int i=2;i<=N;i++) {
			dp[i][0]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%9901;
			dp[i][1]=(dp[i-1][0]+dp[i-1][2])%9901;
			dp[i][2]=(dp[i-1][0]+dp[i-1][1])%9901;
		}
		
		int result=(dp[N][0]+dp[N][1]+dp[N][2])%9901;
		System.out.println(result);
	}

}
