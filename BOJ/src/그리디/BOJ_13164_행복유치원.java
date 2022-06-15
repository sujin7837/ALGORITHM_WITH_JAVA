package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13164_행복유치원 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, K;
	private static int []heights, diffs;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		heights=new int[N];
		diffs=new int[N-1];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) heights[i]=Integer.parseInt(st.nextToken());
		for(int i=0;i<N-1;i++) diffs[i]=heights[i+1]-heights[i];
		Arrays.sort(diffs);
		
		int result=0;
		for(int i=0;i<diffs.length-(K-1);i++) result+=diffs[i];
		System.out.println(result);
	}

}
