package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_13913_숨바꼭질4 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int N, K, T;
	private static int[] time, parent;
	private static int dx[] = { -1, 1 };

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		time = new int[100001];
		parent = new int[100001];

		bfs();
		System.out.println(time[K]);
		int now=K;
		Stack<Integer> stack=new Stack<>();
		while(now!=N) {
			stack.add(now);
			now=parent[now];
		}
		stack.add(now);
		while(!stack.isEmpty()) {
			int get=stack.pop();
			System.out.print(get+" ");
		}
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		time[N]=0;

		while (!queue.isEmpty()) {
			int q = queue.poll();
			if (q == K) return;

			int nx;
			for (int i = 0; i < 3; i++) {
				if (i == 2)
					nx = q * 2;
				else
					nx = q + dx[i];

				if (nx >= 0 && nx <= 100000 && time[nx]==0 ) {
					time[nx]=time[q]+1;
					parent[nx]=q;
					queue.add(nx);
				}
			}
		}
	}
}
