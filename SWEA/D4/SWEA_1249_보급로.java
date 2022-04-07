package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1249_보급로 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int T, N;
	private static int[][] map;
	private static int[][] d;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	static class Point implements Comparable<Point> {
		int r, c, dist;

		public Point(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.dist, o.dist);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(bf.readLine());
			map = new int[N][N];
			d = new int[N][N];

			for(int r=0;r<N;r++) {
				String s=bf.readLine();
				for(int c=0;c<N;c++) {
					map[r][c]=s.charAt(c)-'0';
				}
			}
			
			path();
//			for(int []r:d) {
//				for(int c:r) System.out.print(c+" ");
//				System.out.println();
//			}
			System.out.println("#" + t + " " + d[N-1][N-1]);
		}

	}

	private static void path() {
		PriorityQueue<Point> pq=new PriorityQueue<>();
		pq.add(new Point(0,0,0));
		
		for(int r=0;r<N;r++) Arrays.fill(d[r], Integer.MAX_VALUE);
		d[0][0]=0;
		
		while(!pq.isEmpty()) {
			Point p=pq.poll();
			int R=p.r;
			int C=p.c;
			int dist=p.dist;
			
			if(d[R][C]<dist) continue;
			for(int i=0;i<4;i++) {
				int nx=R+dx[i];
				int ny=C+dy[i];
				
				if(isIn(nx, ny) && d[nx][ny]>d[R][C]+map[nx][ny]) {
					d[nx][ny]=d[R][C]+map[nx][ny];
					pq.add(new Point(nx, ny, d[nx][ny]));
				}
			}
			
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
