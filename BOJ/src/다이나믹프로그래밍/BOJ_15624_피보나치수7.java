package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_15624_피보나치수7 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N;
	private static BigInteger []dp;
	private static BigInteger bi=new BigInteger("1000000007");
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		dp=new BigInteger[N+1];
		
		dp[0]=BigInteger.ZERO;
		if(N>=1) dp[1]=BigInteger.ONE;
		
		for(int i=2;i<=N;i++) {
			dp[i]=(dp[i-1].add(dp[i-2])).mod(bi);
		}
		
		System.out.println(dp[N]);
	}

}
