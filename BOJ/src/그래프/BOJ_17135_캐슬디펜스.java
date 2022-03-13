package 그래프;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬디펜스 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int N, M, D, maxVal = Integer.MIN_VALUE;
	private static int[][] map;
	private static int[][] playmap;
	private static int[] dx = { 0, -1, 0 };
	private static int[] dy = { -1, 0, 1 };
	private static boolean[][] toAttack;

	public static void main(String[] args) throws IOException {

		bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(bf.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		archerComb(3, new int[3], 0);
		System.out.println(maxVal);
	}

	// 궁수 3명 위치 조합 구하기
	public static void archerComb(int toChoose, int[] choosed, int start) {
		if (toChoose == 0) {
//			System.out.println(Arrays.toString(choosed));
			play(choosed);
			return;
		}

		for (int i = start; i < M; i++) {
			choosed[choosed.length - toChoose] = i;
			archerComb(toChoose - 1, choosed, i + 1);
		}
	}

	public static void play(int[] choosed) {
		int killCnt = 0;
		playmap = new int[N + 1][M];
		for (int i = 0; i < N; i++) {
			playmap[i] = Arrays.copyOf(map[i], map[i].length);
		}

		for (int i = 0; i < N; i++) {
			searchEnemy(choosed);
			killCnt += kill(toAttack);
			move();
		}

		maxVal = Math.max(maxVal, killCnt);
	}

	// 가장 가까운 적 구하기
	public static void searchEnemy(int[] choosed) {
		toAttack = new boolean[N][M];

		for (int i : choosed) {
			if (playmap[N - 1][i] == 1) {
				toAttack[N - 1][i] = true;
			} else {
				bfs(new Point(N - 1, i), toAttack);
			}
		}
	}

	public static void bfs(Point point, boolean[][] toAttack) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(point);

		boolean[][] visited = new boolean[N][M];
		visited[point.x][point.y] = true;

		for (int d = 1; d < D; d++) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point p = queue.poll();

				for (int i = 0; i < 3; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];

					if (isIn(nx, ny) && !visited[nx][ny]) {
						if (playmap[nx][ny] == 1) {
							toAttack[nx][ny] = true;
							return;
						}
						visited[nx][ny] = true;
						queue.offer(new Point(nx, ny));
					}
				}
			}
		}
	}

	// 적 죽이기
	public static int kill(boolean[][] toAttack) {
		int killCnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (toAttack[r][c]) {
					playmap[r][c] = 0;
					killCnt++;
				}
			}
		}
		return killCnt;
	}

	// 남은 적 이동하기
	public static void move() {
		for (int r = N - 1; r >= 0; r--) {
			for (int c = 0; c < M; c++) {
				if (playmap[r][c] == 1) {
					playmap[r][c] = 0;
					if (r + 1 < N) {
						playmap[r + 1][c] = 1;
					}
				}
			}
		}

	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
