package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14716_현수막 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int M, N, cnt;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];

		for (int r = 0; r < M; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		cnt = 0;
		visited = new boolean[M][N];
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1 && !visited[r][c]) {
					cnt++;
					bfs(r, c);
				}
			}
		}
		System.out.println(cnt);
	}

	private static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r, c));

		visited[r][c] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int d = 0; d < 8; d++) {
				int nx = p.r + dx[d];
				int ny = p.c + dy[d];

				if (isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.add(new Point(nx, ny));
				}
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < M && c >= 0 && c < N;
	}
}
