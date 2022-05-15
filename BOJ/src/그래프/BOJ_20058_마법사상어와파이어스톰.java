package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20058_마법사상어와파이어스톰 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int N, Q, L, size, sizeL, max;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
//	private static int []L;

	static class Ice {
		int r, c;

		public Ice(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Ice [r=" + r + ", c=" + c + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2, N);
		map = new int[size][size];
//		L=new int[Q];

		for (int r = 0; r < size; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < size; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
//			L[i]=Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			sizeL = (int) Math.pow(2, L);
			for (int r = 0; r < size; r += sizeL) { // 회전
				for (int c = 0; c < size; c += sizeL) {
					rotate(r, c, sizeL);
				}
			}

			melt(); // 얼음 양 조정
//			System.out.println(i+" Q= "+L);
//			print();
		}

		int remain = count(); // 남은 얼음 양

		visited = new boolean[size][size];
		for (int r = 0; r < size; r++) { // 큰 덩어리 칸 개수
			for (int c = 0; c < size; c++) {
				if (map[r][c] > 0 && !visited[r][c]) {
					int tmp = bfs(r, c);
					max = Math.max(max, tmp);
				}
			}
		}

//		print();
		System.out.println(remain);
		System.out.println(max);
	}

	private static void print() {
		for(int []r:map) {
			for(int c:r) System.out.print(c+" ");
			System.out.println();
		}
	}
	private static int bfs(int r, int c) {
		Queue<Ice> queue = new LinkedList<>();
		queue.add(new Ice(r, c));

		visited[r][c] = true;

		int cnt = 1;
		while (!queue.isEmpty()) {
			Ice q = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = q.r + dx[d];
				int ny = q.c + dy[d];

				if (isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] > 0) {
					cnt++;
					visited[nx][ny] = true;
					queue.add(new Ice(nx, ny));
				}
			}
		}

		return cnt;
	}

	private static int count() {
		int cnt = 0;
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (map[r][c] > 0)
					cnt+=map[r][c];
			}
		}

		return cnt;
	}

	private static void melt() {
		Queue<Ice> queue=new LinkedList<>();
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (map[r][c] == 0)
					continue;
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nx = r + dx[d];
					int ny = c + dy[d];

					if (isIn(nx, ny) && map[nx][ny] > 0)
						cnt++;
				}
				if (cnt < 3)
					queue.add(new Ice(r, c));
			}
		}
		
		while(!queue.isEmpty()) {
			Ice q=queue.poll();
			
			map[q.r][q.c]--;
		}
	}

	private static void rotate(int R, int C, int s) {
//		System.out.println("start with: " + R + " " + C + " " + s);
		int[][] tmp = new int[size][size];
		for (int r = R; r < R + s; r++) {
			for (int c = C; c < C + s; c++) {
//				System.out.println((c + R - C) + " " + (R + C + s - r - 1));
				tmp[c + R - C][R + C + s - r - 1] = map[r][c];
			}
		}

		for (int r = R; r < R + s; r++) {
			for (int c = C; c < C + s; c++) {
				map[r][c] = tmp[r][c];
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < size && c >= 0 && c < size;
	}
}
