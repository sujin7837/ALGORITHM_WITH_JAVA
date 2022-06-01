package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9009_피보나치 {

	private static BufferedReader br;
	
	private static int T, N;
	private static int []dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		dp=new int[47];
		dp[0]=0;
		dp[1]=1;
		for(int t=1;t<=T;t++) {
			N=Integer.parseInt(br.readLine());
			int idx=1;
			for(int i=2;i<=46;i++) {
				if(dp[i-1]>=N) break;
				dp[i]=dp[i-1]+dp[i-2];
				if(dp[i]<=N) idx=i;
			}
//			System.out.println(Arrays.toString(dp));
			int num=N;
			Stack<Integer> stack=new Stack<>();
			while(num>0 && idx>0) {
//				System.out.println(stack);
				if(num-dp[idx]>=0) {
					stack.add(dp[idx]);
					num-=dp[idx];
				}
				idx--;
			}
			while(!stack.isEmpty()) {
				System.out.print(stack.pop()+" ");
			}
			System.out.println();
		}
	}

}
