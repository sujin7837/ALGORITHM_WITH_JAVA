package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int K, W, H;
	private static int[][] graph;
	private static int[] horseX = { -1, -2, -2, -1, 1, 2, 2, 1 };
	private static int[] horseY = { -2, -1, 1, 2, 2, 1, -1, -2 };
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	static class Monkey {
		int r, c, k, cnt;

		public Monkey(int r, int c, int k, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Monkey [r=" + r + ", c=" + c + ", k=" + k + ", cnt=" + cnt + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		bf = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		graph = new int[H][W];

		for (int r = 0; r < H; r++) {
			st = new StringTokenizer(bf.readLine());
			for (int c = 0; c < W; c++) {
				graph[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// 입력 확인
//		for(int []r:graph) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}

		bfs();
	}

	public static void bfs() {
		Queue<Monkey> queue=new LinkedList<>();
		queue.add(new Monkey(0, 0, K, 0));
				
		boolean [][][]visited=new boolean[K+1][H][W];
		
		while(!queue.isEmpty()) {
			Monkey p=queue.poll();

			// 정답
			if(p.r==H-1 && p.c==W-1) {
				System.out.println(p.cnt);
				return;
			}
			
			if(!isIn(p.r, p.c)) continue;
			if(graph[p.r][p.c]==1) continue;
			if(visited[p.k][p.r][p.c]) continue;
			visited[p.k][p.r][p.c]=true;
			
			// 원숭이
			for(int i=0;i<4;i++) {
				int nx=p.r+dx[i];
				int ny=p.c+dy[i];
//				if(p.r==3 && p.c==2) System.out.println(nx+" : "+ny);
				queue.add(new Monkey(nx, ny, p.k, p.cnt+1));
			}
			
			// 말
			if(p.k==0) continue;
			for(int i=0;i<8;i++) {
				int nx=p.r+horseX[i];
				int ny=p.c+horseY[i];
				
				queue.add(new Monkey(nx, ny, p.k-1, p.cnt+1));
			}
		}
		System.out.println(-1);
		return;
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}
}
