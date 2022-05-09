package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_12852_1로만들기2 {

	private static BufferedReader br;

	private static int N;

	static class Number {
		int cnt, val;
		List<Integer> list;

		public Number(int cnt, int val, List<Integer> list) {
			super();
			this.cnt = cnt;
			this.val = val;
			this.list = list;
		}

		@Override
		public String toString() {
			return "Number [cnt=" + cnt + ", val=" + val + ", list=" + list + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		Number result=bfs();
		System.out.println(result.cnt);
		for(int x:result.list) System.out.print(x+" ");
	}

	private static Number bfs() {
		List<Integer> list=new ArrayList<>();
		list.add(N);
		Queue<Number> queue = new LinkedList<>();
		queue.add(new Number(0, N, list));

		boolean[] visited = new boolean[1000001];
		visited[N] = true;

		while (!queue.isEmpty()) {
//			System.out.println(queue);
			int size = queue.size();
			while (size-- > 0) {
				Number q = queue.poll();

				if (q.val == 1)
					return q;
				if (q.val % 3 == 0 && !visited[q.val / 3]) {
					visited[q.val / 3] = true;
					List<Integer> tmp=new ArrayList<>();
					tmp.addAll(q.list);
					tmp.add(q.val/3);
					queue.add(new Number(q.cnt+1, q.val/3, tmp));
				}
				if (q.val % 2 == 0 && !visited[q.val / 2]) {
					visited[q.val / 2] = true;
					List<Integer> tmp=new ArrayList<>();
					tmp.addAll(q.list);
					tmp.add(q.val/2);
					queue.add(new Number(q.cnt+1, q.val/2, tmp));
				}
				if (q.val - 1 >= 1 && !visited[q.val - 1]) {
					visited[q.val - 1] = true;
					List<Integer> tmp=new ArrayList<>();
					tmp.addAll(q.list);
					tmp.add(q.val-1);
					queue.add(new Number(q.cnt+1, q.val-1, tmp));
				}
			}
		}
		return null;
	}
}
