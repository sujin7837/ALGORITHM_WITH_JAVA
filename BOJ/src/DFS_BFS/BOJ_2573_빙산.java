package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int N, M;
	private static int[][] map, map2;
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
		map = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0, result=0;
		while ((cnt=count())<2) {
			if(cnt==0) {
				result=0;
				break;
			}
			melting();
			result++;
		}
		System.out.println(result);
	}

	private static void melting() {
		map2 = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] > 0) {
					for (int d = 0; d < 4; d++) {
						int nx = r + dx[d];
						int ny = c + dy[d];

						if (isIn(nx, ny) && map[nx][ny] == 0) {
							map2[r][c]++;
						}
					}
				}
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] -= map2[r][c];
				if (map[r][c] < 0)
					map[r][c] = 0;
			}
		}
	}

	private static int count() {
		int count=0;
		boolean[][] bingsan = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] > 0 && !bingsan[r][c]) {
					bfs(r, c, bingsan);
					count++;
				}
			}
		}
		return count;
	}

	private static void bfs(int r, int c, boolean [][]bingsan) {
		Queue<Point> queue=new LinkedList<>();
		queue.add(new Point(r, c));
		
		bingsan[r][c]=true;
		
		while(!queue.isEmpty()) {
			Point p=queue.poll();
			
			for(int d=0;d<4;d++) {
				int nx=p.r+dx[d];
				int ny=p.c+dy[d];
				
				if(isIn(nx, ny) && !bingsan[nx][ny] && map[nx][ny]>0) {
					bingsan[nx][ny]=true;
					queue.add(new Point(nx, ny));
				}
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
