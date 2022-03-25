package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2293_동전1 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, K;
	private static int [] coins, dp;
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		coins=new int[N];
		dp=new int[K+1];
		dp[0]=1;
		
		for(int i=0;i<N;i++) {
			coins[i]=Integer.parseInt(bf.readLine());
		}
		
		for(int i=0;i<N;i++) {
			for(int k=1;k<=K;k++) {
				if(k>=coins[i]) {
					dp[k]+=dp[k-coins[i]];
				}
			}
		}
		System.out.println(dp[K]);
	}

}
