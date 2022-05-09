package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6118_숨바꼭질 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, M;
	private static int []depth;
	private static List<Integer> []list;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		list=new ArrayList[N+1];
		for(int i=1;i<=N;i++) list[i]=new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		depth=new int[N+1];
		bfs();
		int max=0;
		for(int i=1;i<=N;i++) {
			if(depth[i]>max) {
				max=depth[i];
			}
		}
		int num=-1;
		int dist=max;
		int cnt=0;
		for(int i=1;i<=N;i++) {
			if(depth[i]==max) {
				if(num==-1) num=i;
				cnt++;
			}
		}
		System.out.println(num+" "+dist+" "+cnt);
	}

	private static void bfs() {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(1);
		
		boolean []visited=new boolean[N+1];
		visited[1]=true;
		depth[1]=0;
		
		int dep=1;
		while(!queue.isEmpty()) {
			int size=queue.size();
			
			while(size-->0) {
				int q=queue.poll();
				
				for(int i:list[q]) {
					if(!visited[i]) {
						visited[i]=true;
						depth[i]=dep;
						queue.add(i);
					}
				}
			}
			dep++;
		}
	}
}
