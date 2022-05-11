package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1939_중량제한 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int N, M, A, B;
	private static int max=0;
	private static boolean[] visited;
	private static List<Island>[] list;

	static class Island {
		int num;
		long weight;

		public Island(int num, long weight) {
			super();
			this.num = num;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Island [num=" + num + ", weight=" + weight + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		list=new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			max=Math.max(max, c);
			list[a].add(new Island(b, c));
			list[b].add(new Island(a, c));
		}
		
		st=new StringTokenizer(br.readLine());
		A=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		
		int left=1;
		int right=max;
		while(left<=right) {
			int mid=(left+right)/2;
			visited=new boolean[N+1];
			
			if(bfs(mid)) {
				left=mid+1;
			} else {
				right=mid-1;
			}
		}

		System.out.println(right);
	}


	private static boolean bfs(int mid) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(A);
		
		boolean []visited=new boolean[N+1];
		visited[A]=true;
		
		while(!queue.isEmpty()) {
			int q=queue.poll();
			
			if(q==B) return true;
			for(Island i:list[q]) {
				if(!visited[i.num] && mid<=i.weight) {
					visited[i.num]=true;
					queue.add(i.num);
				}
			}
		}
		
		return false;
	}
}
