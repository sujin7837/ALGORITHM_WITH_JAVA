package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953_AB {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int A, B, result;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		
		A=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		result=Integer.MAX_VALUE;
		
		dfs(0, A);
		if(result==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result+1);
	}

	private static void dfs(int cnt, long val) {
		if(cnt>=result) return;
		if(val>B) return;
		if(val==B) {
			result=Math.min(result, cnt);
			return;
		}
		
		dfs(cnt+1, val*2);
		dfs(cnt+1, val*10+1);
	}
}
