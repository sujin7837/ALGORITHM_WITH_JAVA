package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1679_숫자놀이 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int N, K, next;
	private static int[] nums;
	private static boolean[] visited;
	private static List<Integer> []dp;

	static class Number {
		int val, cnt;

		public Number(int val, int cnt) {
			super();
			this.val = val;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Number [val=" + val + ", cnt=" + cnt + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		dp=new ArrayList[N+1];
		for(int i=0;i<=N;i++) dp[i]=new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		visited=new boolean[nums[N-1]*K+2];
		
		dp[0].add(0);
//		dfs(1);
		bfs();
		for(int i=1;i<visited.length;i++) {
			if(!visited[i]) {
				if(i%2==0) System.out.println("holsoon win at "+i);
				else System.out.println("jjaksoon win at "+i);
				break;
			}
		}
	}

	private static void bfs() {
		Queue<Number> queue=new LinkedList<>();
		queue.add(new Number(0,0));
		
		while(!queue.isEmpty()) {
			Number q=queue.poll();
			
			if(q.cnt==K) continue;
			for(int i=0;i<N;i++) {
				int now=q.val+nums[i];
				if(!visited[now]) {
					visited[now]=true;
					queue.add(new Number(now, q.cnt+1));
				}
			}
		}
	}
	private static void dfs(int x) {
		if(x>5) return;
		
		for(int i:dp[x-1]) {
			for(int j=0;j<N;j++) {
				int now=i+nums[j];
				if(!visited[now]) {
					visited[now]=true;
					dp[x-1].add(now);
					dfs(x+1);
				}
			}
		}
	}
}
