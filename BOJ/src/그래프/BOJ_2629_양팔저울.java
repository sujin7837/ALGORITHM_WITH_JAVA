package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2629_양팔저울 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int num, numMarble;
	private static int []weight, weightMarble;
	private static boolean [][]check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		num=Integer.parseInt(br.readLine());
		weight=new int[num];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<num;i++) {
			weight[i]=Integer.parseInt(st.nextToken());
		}
		
		numMarble=Integer.parseInt(br.readLine());
		weightMarble=new int[numMarble];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<numMarble;i++) {
			weightMarble[i]=Integer.parseInt(st.nextToken());
		}
		
		check=new boolean[num+1][40001];
		subset(0, 0);
//		for(int r=0;r<20;r++) System.out.println(check[r]+" "+r);
		for(int i=0;i<numMarble;i++) {
			if(check[num][weightMarble[i]]) System.out.print("Y ");
			else System.out.print("N ");
		}
	}

	private static void subset(int cnt, int sum) {
		if(check[cnt][sum]) return;
		else check[cnt][sum]=true;
		if(cnt==num) return;
		
		subset(cnt+1, sum+weight[cnt]);	// 재귀
		subset(cnt+1, Math.abs(sum-weight[cnt]));	// 재귀
		subset(cnt+1, sum);	// 재귀
	}
}
