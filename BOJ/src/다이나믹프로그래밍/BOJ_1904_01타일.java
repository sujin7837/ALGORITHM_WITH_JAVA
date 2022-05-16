package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1904_01타일 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N;
	private static int []dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		dp=new int[N+1];
		dp[1]=1;
		if(N>=2) dp[2]=2;
		
		for(int i=3;i<=N;i++) dp[i]=(dp[i-1]+dp[i-2])%15746;
		System.out.println(dp[N]);
	}

}
