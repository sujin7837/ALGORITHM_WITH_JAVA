package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_24481_알고리즘수업_깊이우선탐색3 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, M, R;
	private static int []depth;
	private static List<Integer> []list;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		
		list=new ArrayList[N+1];
		for(int i=1;i<=N;i++) list[i]=new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		for(int i=1;i<=N;i++) Collections.sort(list[i]);
		
		boolean []visited=new boolean[N+1];
		visited[R]=true;
		
		depth=new int[N+1];
		for(int i=1;i<=N;i++) depth[i]=-1;
		depth[R]=0;
		dfs(R, visited, 1);
		
		for(int i=1;i<=N;i++) System.out.println(depth[i]);
	}

	private static void dfs(int x, boolean []visited, int cnt) {
		if(list[x].size()==0) return;
		
		for(int i:list[x]) {
			if(!visited[i]) {
				visited[i]=true;
				depth[i]=cnt;
				dfs(i, visited, cnt+1);
			}
		}
	}
}
