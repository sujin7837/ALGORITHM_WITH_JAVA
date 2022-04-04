package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486_퇴사2 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N;
	private static int []T, P, dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		T=new int[N];
		P=new int[N];
		dp=new int[N+1];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			T[i]=Integer.parseInt(st.nextToken());
			P[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=N-1;i>=0;i--) {
			if((N-i)<T[i]) {
				dp[i]=dp[i+1];
				continue;
			}
			if(i+T[i]==N) dp[i]=Math.max(dp[i+1], P[i]);
			else {
//				System.out.println(i+" "+T[i]);
				dp[i]=Math.max(dp[i+1], P[i]+dp[i+T[i]]);
			}
		}
		System.out.println(dp[0]);
	}

}
