package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5557_1학년 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, result;
	private static long answer;
	private static int []nums;
	private static long [][]dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		nums=new int[N-1];
		dp=new long[N-1][21];
		for(int i=0;i<N-1;i++) {
			for(int j=0;j<21;j++) dp[i][j]=-1; 
		}
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N-1;i++) nums[i]=Integer.parseInt(st.nextToken());
		result=Integer.parseInt(st.nextToken());
		
		answer=dfs(nums[0], 0);
		System.out.println(answer);
	}

	private static long dfs(int x, int idx) {
		if(x>20 || x<0) return 0;
		if(idx==N-2) {
			if(x==result) return 1;
			return 0;
		}
		if(dp[idx][x]!=-1) return dp[idx][x]; 
		dp[idx][x]=0;
		dp[idx][x]+=dfs(x+nums[idx+1], idx+1);
		dp[idx][x]+=dfs(x-nums[idx+1], idx+1);
		return dp[idx][x];
	}
}
