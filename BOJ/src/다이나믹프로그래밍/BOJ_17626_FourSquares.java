package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17626_FourSquares {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N;
	private static int []dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		dp=new int[N+1];
		
		for(int i=1;i<=N;i++) dp[i]=i;
		for(int i=1;i<=N;i++) {
			for(int j=1;j*j<=i;j++) {
				dp[i]=Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		
		System.out.println(dp[N]);
	}

}
