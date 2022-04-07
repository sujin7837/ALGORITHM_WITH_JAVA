package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int N, M;
	private static int[][] map;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	static class Robot {
		int r, c, dir;

		public Robot(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Robot [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}

	}

	public static void main(String[] args) throws IOException {

		bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		st = new StringTokenizer(bf.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		Robot robot = new Robot(R, C, dir);

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(bf.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		clean(robot);

		int cnt = cleanCnt();
		System.out.println(cnt);
	}

	private static void clean(Robot robot) {
		Queue<Robot> queue = new LinkedList<>();
		queue.add(robot);
		map[robot.r][robot.c] = 2;

		while (!queue.isEmpty()) {
			boolean canGo = false;
			Robot rb = queue.poll();
			int R = rb.r;
			int C = rb.c;
			int dir = rb.dir;

			int cnt = 0;
			while (cnt < 4) {
				dir--;
				if (dir == -1)
					dir = 3;
				int nx = R + dx[dir];
				int ny = C + dy[dir];

				if (map[nx][ny] == 0) {
					map[nx][ny] = 2;
					queue.add(new Robot(nx, ny, dir));
					canGo = true;
					break;
				}
				cnt++;
			}
			if (cnt == 4 && !canGo) {
				int nx = R - dx[rb.dir];
				int ny = C - dy[rb.dir];
				if (map[nx][ny] == 1)
					return;
				else if (map[nx][ny] == 2) {
					queue.add(new Robot(nx, ny, rb.dir));
				}
			}
		}

	}

	private static int cleanCnt() {
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 2)
					cnt++;
			}
		}
		return cnt;
	}

}
