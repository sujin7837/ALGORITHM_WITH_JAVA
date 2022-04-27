package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638_치즈 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int N, M, cnt=0;
	private static int[][] graph;
	private static int []dx= {-1,1,0,0};
	private static int []dy= {0,0,-1,1};

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
		graph = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				graph[r][c] = Integer.parseInt(st.nextToken());
				if(graph[r][c]==1) {
					graph[r][c]=-1;
					cnt++;
				}
			}
		}
		int depth=0;
		while(cnt>0) {
			depth++;
			bfs();
//			System.out.println(depth+" "+cnt);
		}
		System.out.println(depth);
	}

	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));

		boolean [][]visited=new boolean[N][M];
		visited[0][0]=true;
		
		while(!queue.isEmpty()) {
//			int size=queue.size();
			
//			while(size-->0) {
				Point p=queue.poll();
				
				for(int d=0;d<4;d++) {
					int nx=p.r+dx[d];
					int ny=p.c+dy[d];
					
					if(isIn(nx, ny)) {
						if(graph[nx][ny]==-1) graph[nx][ny]=1;
						else if(graph[nx][ny]>0) graph[nx][ny]++;
						else {
							if(!visited[nx][ny]) {
								visited[nx][ny]=true;
								queue.add(new Point(nx, ny));
							}
						}
					}
				}
//				System.out.println(queue);
//			}
		}
		melt();
	}
	
	private static void melt() {
//		for(int []pr:graph) {
//			for(int pc:pr) System.out.print(pc+" ");
//			System.out.println();
//		}
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				if(graph[r][c]>=2) {
					graph[r][c]=0;
					cnt--;
				} else if(graph[r][c]==1) graph[r][c]=-1;
			}
		}
	}
	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
