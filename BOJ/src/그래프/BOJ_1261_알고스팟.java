package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int N, M, result=Integer.MAX_VALUE;
	private static int[][] graph, dist;
	private static int[] dx= {-1,1,0,0};
	private static int[] dy= {0,0,-1,1};

	static class Point implements Comparable<Point> {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.cnt, o.cnt);
		}

	}

	public static void main(String[] args) throws IOException {

		bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		dist=new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) dist[i][j]=Integer.MAX_VALUE;
		}

		for (int r = 0; r < N; r++) {
			String s = bf.readLine();
			for (int c = 0; c < M; c++) {
				graph[r][c] = s.charAt(c) - '0';
			}
		}

		// 입력 확인
//		for(int []r:graph) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}

		if(N==1 && M==1) result=0;
		else result=bfs();
		System.out.println(result);
	}

	public static int bfs() {
		for(int i=0;i<N;i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
		PriorityQueue<Point> queue=new PriorityQueue<>();
		queue.add(new Point(0,0,0));
		
		boolean [][]visited=new boolean[N][M];
		visited[0][0]=true;
		dist[0][0]=0;
		
		while(!queue.isEmpty()) {
			
			int size=queue.size();
			while(size-->0) {
				Point p=queue.poll();
//				System.out.println(queue);
				
				for(int i=0;i<4;i++) {
					int nx=p.r+dx[i];
					int ny=p.c+dy[i];
					
					if(nx==N-1 && ny==M-1) {
						result=Math.min(result, p.cnt);
//						System.out.println(result+" : "+nx+" : "+ny);
					}
					
					if(isIn(nx, ny) && !visited[nx][ny]) {
						visited[nx][ny]=true;
						if(graph[nx][ny]==0) {
							dist[nx][ny]=Math.min(dist[nx][ny], dist[p.r][p.c]);
							queue.add(new Point(nx, ny, dist[nx][ny]));
						}
						else {
							dist[nx][ny]=Math.min(dist[nx][ny], dist[p.r][p.c]+1);
							queue.add(new Point(nx, ny, dist[nx][ny]));
						}
					}
				}
			}
		}
		return result;
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
