package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {

	private static int N, M, V;
	private static int [][] graph;
	private static BufferedReader bf;
	private static StringTokenizer st;
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		V=Integer.parseInt(st.nextToken());
		graph=new int[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(bf.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			graph[a][b]=1;
			graph[b][a]=1;
		}
		
//		for(int []r:graph) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		dfs(new boolean[N+1], V);
		System.out.println();
		bfs(new boolean[N+1], V);
	}

	public static void dfs(boolean [] visited, int current) {
		visited[current]=true;
		System.out.print(current+" ");
		
		for(int i=1;i<=N;i++) {
			if(!visited[i] && graph[current][i]==1) {
				dfs(visited, i);
			}
		}
	}
	
	public static void bfs(boolean [] visited, int start) {
		visited[start]=true;
		Queue<Integer> queue=new LinkedList<>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int current=queue.poll();
			System.out.print(current+" ");
			
			for(int i=1;i<=N;i++) {
				if(!visited[i] && graph[current][i]==1) {
					visited[i]=true;
					queue.add(i);
				}
			}
		}
	}
}
