package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M, result;
	private static int [][]map;
	private static int []dx= {-1,1,0,0};
	private static int []dy= {0,0,-1,1};
	
	static class Point implements Comparable<Point> {
		int r, c, sum, cnt;

		public Point(int r, int c, int sum, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.sum = sum;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", sum=" + sum + ", cnt=" + cnt + "]";
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(o.sum, this.sum);
		}
	}
	
	public static void main(String[] args) throws IOException {
		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(bf.readLine());
			for(int c=0;c<M;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		result=Integer.MIN_VALUE;
		boolean [][]visited=new boolean[N][M];
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
//				System.out.println(r+" : "+c);
				visited[r][c]=true;
				dfs(new Point(r, c, map[r][c], 0), visited);
				visited[r][c]=false;
				another(r, c);
			}
		}
		System.out.println(result);
	}

	private static void dfs(Point point, boolean[][] visited) {
		if(point.cnt==3) {
//			System.out.println(point);
//			System.out.println();
			result=Math.max(result, point.sum);
			return;
		}
//		System.out.println(point);
		for(int d=0;d<4;d++) {
			int nx=point.r+dx[d];
			int ny=point.c+dy[d];
			
			if(isIn(nx, ny) && !visited[nx][ny]) {
				int sum=point.sum+map[nx][ny];
				visited[nx][ny]=true;
				dfs(new Point(nx, ny, sum, point.cnt+1), visited);
				visited[nx][ny]=false;
			}
		}
	}
	
	private static void another(int r, int c) {
		for(int d=0;d<4;d++) {
			int sum=map[r][c];
			for(int i=d;i<d+3;i++) {
				int ni=i;
				if(ni>=4) ni-=4;
				int nx=r+dx[ni];
				int ny=c+dy[ni];
				
				if(!isIn(nx, ny)) {
					sum=0;
					break;
				}
				sum+=map[nx][ny];
			}
			result=Math.max(result, sum);
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
