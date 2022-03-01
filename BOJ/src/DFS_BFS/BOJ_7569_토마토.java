package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int N, M, H, depth=0;
	private static int[][][] map;
	private static int[] dx = { -1, 1, 0, 0, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1, 0, 0 };
	private static int[] dz = { 0, 0, 0, 0, -1, 1 };
	private static Queue<Tomatoes> queue;

	static class Tomatoes {
		int r, c, h;

		public Tomatoes(int r, int c, int h) {
			super();
			this.r = r;
			this.c = c;
			this.h = h;
		}

		@Override
		public String toString() {
			return "Tomatoes [r=" + r + ", c=" + c + ", h=" + h + "]";
		}

	}

	public static void main(String[] args) throws IOException {

		bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];
		queue=new LinkedList<>();
		int cnt=0;

		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(bf.readLine());
				for (int c = 0; c < M; c++) {
					map[h][r][c] = Integer.parseInt(st.nextToken());
					if(map[h][r][c]==1) queue.offer(new Tomatoes(r, c, h));
					if(map[h][r][c]==0) cnt++;
				}
			}
		}

		// 입력 확인
//		for(int [][]h:map) {
//			for(int []r:h) {
//				for(int c:r) System.out.print(c+" ");
//				System.out.println();
//			}
//			System.out.println();
//		}

		if(cnt>0) {
			bfs();
			for(int h=0;h<H;h++) {
				for(int r=0;r<N;r++) {
					for(int c=0;c<M;c++) {
						if(map[h][r][c]==0) depth=-1;
					}
				}
			}
		}
		if(depth>0) System.out.println(depth-1);
		else System.out.println(depth);
	}

	public static void bfs() {
		while(!queue.isEmpty()) {
			int size=queue.size();
			depth++;
			while(size-->0) {
				Tomatoes t=queue.poll();
				for(int i=0;i<6;i++) {
					int nx=t.r+dx[i];
					int ny=t.c+dy[i];
					int nz=t.h+dz[i];
					
					if(isIn(nx, ny, nz) && map[nz][nx][ny]==0) {
						map[nz][nx][ny]=1;
						queue.offer(new Tomatoes(nx, ny, nz));
					}
				}
			}
		}
	}

	public static boolean isIn(int r, int c, int h) {
		return r >= 0 && r < N && c >= 0 && c < M && h >= 0 && h < H;
	}
}
