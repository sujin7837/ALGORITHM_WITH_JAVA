package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9658_돌게임4 {

	private static BufferedReader br;
	
	private static int N;
	private static boolean []dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		dp=new boolean[N+1];
		
		dp[1]=false;
		if(N>=2) dp[2]=true;
		if(N>=3) dp[3]=false;
		if(N>=4) dp[4]=true;
		
		for(int i=5;i<=N;i++) {
			if(!dp[i-1] || !dp[i-3] || !dp[i-4]) dp[i]=true;
		}
		
		if(dp[N]) System.out.println("SK");
		else System.out.println("CY");
	}

}
