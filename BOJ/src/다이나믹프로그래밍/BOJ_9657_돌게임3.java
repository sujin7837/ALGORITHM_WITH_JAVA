package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9657_돌게임3 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N;
	private static boolean []dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		dp=new boolean[N+1];
		
		dp[1]=true;
		dp[2]=false;
		dp[3]=true;
		dp[4]=true;
		for(int i=5;i<=N;i++) {
			if(!dp[i-1] || !dp[i-3] || !dp[i-4]) dp[i]=true;
		}
		
		if(!dp[N]) System.out.println("CY");
		else System.out.println("SK");
	}

}
