package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13023_ABCDE {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, M;
	private static int []cnt;
	private static boolean []visited;
	private static boolean isValid;
	private static List<Integer> []list;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		list=new ArrayList[N];
		for(int i=0;i<N;i++) list[i]=new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		cnt=new int[N];
		isValid=false;
		for(int i=0;i<N;i++) {
			visited=new boolean[N];
			visited[i]=true;
			dfs(i, i, 0);
			System.out.println(Arrays.toString(visited));
			if(isValid) break;
		}
		if(isValid) System.out.println(1);
		else System.out.println(0);
	}

	private static void dfs(int start, int x, int cnt) {
		System.out.println(x+" "+cnt);
		if(isValid) return;
		if(cnt>=4) {
			isValid=true;
			return;
		}
		
		for(int i:list[x]) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(start, i, cnt+1);
				visited[i]=false;
			}
		}
	}
}
