package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int T, L, srcX, srcY, destX, destY;
	private static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	private static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	private static Night night;
	private static int [][] map;
	
	static class Night {
		int r, c;

		public Night(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Night [r=" + r + ", c=" + c + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= T; t++) {
			L = Integer.parseInt(bf.readLine());
			map=new int[L][L];
			st = new StringTokenizer(bf.readLine());
			srcX = Integer.parseInt(st.nextToken());
			srcY = Integer.parseInt(st.nextToken());
			night=new Night(srcX, srcY);
			st = new StringTokenizer(bf.readLine());
			destX = Integer.parseInt(st.nextToken());
			destY = Integer.parseInt(st.nextToken());
			bfs(night);
			System.out.println(map[destX][destY]);
		}

	}

	public static void bfs(Night night) {
		Queue<Night> queue=new LinkedList<>();
		queue.offer(night);
		
		boolean visited[][] = new boolean[L][L];
		visited[night.r][night.c]=true;
		
		while(!queue.isEmpty()) {
			Night n=queue.poll();
			for(int i=0;i<8;i++) {
				int nx=n.r+dx[i];
				int ny=n.c+dy[i];
				
				if(isIn(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny]=true;
					map[nx][ny]=map[n.r][n.c]+1;
					if(nx==destX && ny==destY) return;
					queue.offer(new Night(nx, ny));
				}
			}
		}
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && r < L && c >= 0 && c < L;
	}
}
