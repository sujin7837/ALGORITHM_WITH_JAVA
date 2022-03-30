package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int N, M;
	private static int[][] map;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	static class Point {
		int r, c, wall, dist;

		public Point(int r, int c, int wall, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.wall = wall;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", wall=" + wall + ", dist=" + dist + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int r = 0; r < N; r++) {
			String s = bf.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = s.charAt(c) - '0';
			}
		}

		// 입력 확인
//		for(int []r:map) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}

		if(N==1 && M==1) System.out.println(1);
		else bfs(0, 0);
	}

	public static void bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r, c, 0, 1));

		boolean[][][] visited = new boolean[N][M][2];
		visited[r][c][0] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.r + dx[i];
				int ny = p.c + dy[i];

				if(nx==N-1 && ny==M-1) {
					System.out.println(p.dist+1);
					return;
				}
				if (isIn(nx, ny)) {
					// 벽 x
					if (map[nx][ny] == 0 && !visited[nx][ny][p.wall]) {
						visited[nx][ny][p.wall] = true;
						queue.add(new Point(nx, ny, p.wall, p.dist+1));
					}

					// 벽 o
					if (p.wall == 1)
						continue;
					if (map[nx][ny] == 1 && !visited[nx][ny][p.wall + 1]) {
						visited[nx][ny][p.wall + 1] = true;
						queue.add(new Point(nx, ny, p.wall + 1, p.dist+1));
					}
				}
			}
		}
		System.out.println(-1);
		return;
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
