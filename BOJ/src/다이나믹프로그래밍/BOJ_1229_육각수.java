package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1229_육각수 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N;
	private static int dp[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		dp=new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		int idx=0;
		int diagram=diagramNum(idx);
		for(int i=1;i<=N;i++) {
			int next=diagramNum(idx+1);
			if(i==next) {
				dp[i]=1;
				continue;
			}
			if(i>next) idx++;
			for(int j=idx;j>=0;j--) {
				diagram=diagramNum(j);
				if(dp[diagram]==Integer.MAX_VALUE) continue;
				dp[i]=Math.min(dp[i-diagram]+dp[diagram], dp[i]);
				
			}
		}
		
		System.out.println(dp[N]);
	}

	public static int diagramNum(int n) {
		if(n<=0) return 0;
		return 2*n*n-n;
	}
}
