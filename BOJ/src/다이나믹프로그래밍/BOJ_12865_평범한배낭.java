package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int N, K, result=0;
	private static int [][]dp;
	private static Knapsack []ks;

	static class Knapsack {
		int weight, val;

		public Knapsack(int weight, int val) {
			super();
			this.weight = weight;
			this.val = val;
		}

		@Override
		public String toString() {
			return "Knapsack [weight=" + weight + ", val=" + val + "]";
		}

		
	}

	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		ks=new Knapsack[N+1];
		dp=new int[N+1][K+1];
//		for(int i=0;i<=N;i++) Arrays.fill(dp[i], Integer.MIN_VALUE);
		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(bf.readLine());
			int weight=Integer.parseInt(st.nextToken());
			int val=Integer.parseInt(st.nextToken());
			ks[i]=new Knapsack(weight, val);
		}
		
		for(int i=1;i<=N;i++) {
			int weight=ks[i].weight;
			int val=ks[i].val;
			for(int k=1;k<=K;k++) {
				dp[i][k]=dp[i-1][k];
				
				if(weight>k) continue;
				dp[i][k]=Math.max(dp[i-1][k], dp[i-1][k-weight]+val);
			}
		}
		System.out.println(dp[N][K]);
	}

}
