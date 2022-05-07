package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325_효율적인해킹 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int N, M;
	private static List<Integer> []list;
	private static int []num;
	private static boolean []visited;


	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list=new ArrayList[N+1];
		for(int i=1;i<=N;i++) list[i]=new ArrayList<>();
		num=new int[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
		}

		for(int i=1;i<=N;i++) {
			visited=new boolean[N+1];
//			bfs(i);
			visited[i]=true;
			dfs(i);
		}
		int max=Integer.MIN_VALUE;
//		System.out.println(Arrays.toString(num));
		for(int i=1;i<=N;i++) max=Math.max(max, num[i]);
		StringBuffer sb=new StringBuffer();
		for(int i=1;i<num.length;i++) {
			if(num[i]==max) sb.append(i+" ");
		}
		System.out.println(sb);
	}

	private static void bfs(int x) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(x);
		
		visited[x]=true;
		
		while(!queue.isEmpty()) {
			int q=queue.poll();
			
			for(int i=0;i<list[q].size();i++) {
				int get=list[q].get(i);
				
				if(!visited[get]) {
					visited[get]=true;
					num[get]++;
					queue.add(get);
				}
			}
		}
	}
	
	private static void dfs(int x) {
		if(list[x].size()==0) return;
		for(int i:list[x]) {
			if(!visited[i]) {
				visited[i]=true;
				num[i]++;
				dfs(i);
			}
		}
	}
}
