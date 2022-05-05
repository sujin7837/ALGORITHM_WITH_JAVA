package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11060_점프점프 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int N, jump = 1;
	private static int[] maze;

	static class Jump {
		int idx, cnt;

		public Jump(int idx, int cnt) {
			super();
			this.idx = idx;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Jump [idx=" + idx + ", cnt=" + cnt + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		maze = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			maze[i] = Integer.parseInt(st.nextToken());
		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Jump> queue=new LinkedList<>();
		queue.add(new Jump(0, 0));
		
		boolean []visited=new boolean[N];
		visited[0]=true;
		
		while(!queue.isEmpty()) {
			Jump q=queue.poll();
			
			if(q.idx>=N-1) return q.cnt; 
			for(int i=1;i<=maze[q.idx];i++) {
				if(q.idx+i>=N-1) return q.cnt+1;
				if(!visited[q.idx+i]) {
					visited[q.idx+i]=true;
					queue.add(new Jump(q.idx+i, q.cnt+1));
				}
			}
		}
		return -1;
	}
}
