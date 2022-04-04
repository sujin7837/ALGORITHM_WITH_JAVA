package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1535_안녕 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N;
	private static int []L, J;
	private static int [][]dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		L=new int[N+1];
		J=new int[N+1];
		dp=new int[101][101];
		
		st=new StringTokenizer(bf.readLine());
		for(int i=1;i<=N;i++) L[i]=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(bf.readLine());
		for(int i=1;i<=N;i++) J[i]=Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<100;j++) {
				dp[i][j]=dp[i-1][j];
				if(j>=L[i]) dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-L[i]]+J[i]);
			}
		}
		System.out.println(dp[N][99]);
	}

}
