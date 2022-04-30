package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17822_원판돌리기 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int N, M, T, TOTAL;
	private static int[][] circle;
	private static int[][] rotateVar;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

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
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		TOTAL = N * M;
		circle = new int[N + 1][M];
		rotateVar = new int[T][3]; // 0: x(x의 배수 원판), 1: d(방향), 2: k(k칸)
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				circle[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			rotateVar[i][0] = Integer.parseInt(st.nextToken());
			rotateVar[i][1] = Integer.parseInt(st.nextToken());
			rotateVar[i][2] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < T; i++) {
			int x = rotateVar[i][0];
			int d = rotateVar[i][1];
			int k = rotateVar[i][2];
			for (int j = x; j <= N; j += x) {
				rotate(j, d, k);
			}
			remove();
//			print();
		}

		int result = 0;
		for (int r = 1; r <= N; r++) {
			for (int c = 0; c < M; c++) {
				if (circle[r][c] == 0)
					continue;
				result += circle[r][c];
			}
		}
		System.out.println(result);
	}

	private static void print() {
		for (int[] r : circle) {
			for (int c : r)
				System.out.print(c + " ");
			System.out.println();
		}
		System.out.println();
	}

	private static void rotate(int x, int d, int k) {
		int[] tmp = new int[M];
		if (d == 0) { // 시계 방향
			for (int i = 0; i < M; i++) {
				int idx = i + k;
				if (idx >= M)
					idx -= M;
				tmp[idx] = circle[x][i];
			}
			circle[x] = tmp.clone();
		} else { // 반시계 방향
			for (int i = 0; i < M; i++) {
				int idx = i - k;
				if (idx < 0)
					idx += M;
				tmp[idx] = circle[x][i];
			}
			circle[x] = tmp.clone();
		}
	}

	private static void remove() { // 인접하면서 수가 같은 것 찾기
//		print();
		List<Point> tmp = new ArrayList<>();
		for (int r = 1; r <= N; r++) {
			for (int c = 0; c < M; c++) {
				if (circle[r][c] == 0)
					continue;
				for (int d = 0; d < 4; d++) {
					int nx = r + dx[d];
					int ny = c + dy[d];

					if (nx == 0 || nx > N)
						continue;
					if (ny == -1)
						ny = M - 1;
					if (ny == M)
						ny = 0;
					if (circle[r][c] == circle[nx][ny]) {
						tmp.add(new Point(r, c));
					}
				}
			}
		}
		if (tmp.size() == 0) {
			calcAvg();
		} else {
			for (int i = 0; i < tmp.size(); i++) {
				Point p = tmp.get(i);
				circle[p.r][p.c] = 0;
			}
			TOTAL -= tmp.size();
		}
	}

	private static void calcAvg() { // 인접하면서 수가 같은 것이 없는 경우
		int sum = 0;
		int cnt = 0;
		double avg = 0.0;
		for (int r = 1; r <= N; r++) {
			for (int c = 0; c < M; c++) {
				if (circle[r][c] > 0) {
					sum += circle[r][c];
					cnt++;
				}
			}
		}
		avg = 1.0 * sum / cnt;

		for (int r = 1; r <= N; r++) {
			for (int c = 0; c < M; c++) {
				if (circle[r][c] == 0)
					continue;
				if (circle[r][c] > avg)
					circle[r][c] -= 1;
				else if (circle[r][c] < avg)
					circle[r][c] += 1;
			}
		}
	}

}
