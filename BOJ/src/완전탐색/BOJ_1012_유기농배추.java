package 완전탐색;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {

	private static int T, M, N, K, X, Y, cnt=0;
	private static int [][]map;
	private static int []dx = {-1,1,0,0};
	private static int []dy = {0,0,-1,1};
	private static boolean[][] visited;
	private static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(bf.readLine());
		for(int t=0;t<T;t++) {
			cnt=0;
			st=new StringTokenizer(bf.readLine());
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			map=new int[M][N];
			visited=new boolean[M][N];
			
			for(int i=0;i<K;i++) {
				st=new StringTokenizer(bf.readLine());
				X=Integer.parseInt(st.nextToken());
				Y=Integer.parseInt(st.nextToken());
				map[X][Y]=1;
			}
			
			// 입력 확인
//			for(int []r:map) {
//				for(int c:r) System.out.print(c+" ");
//				System.out.println();
//			}
			
			for(int r=0;r<M;r++) {
				for(int c=0;c<N;c++) {
					if(map[r][c]==1 && !visited[r][c]) {
//						System.out.println("x: "+r+" y: "+c);
						bfs(r,c);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	public static void bfs(int x, int y) {
		visited[x][y]=true;
		Queue<Point> queue=new LinkedList<Point>();
		queue.add(new Point(x,y));
		
		while(!queue.isEmpty()) {
			Point p=queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				
				if(isIn(nx, ny) && !visited[nx][ny] && map[nx][ny]==1) {
					visited[nx][ny]=true;
					queue.add(new Point(nx, ny));
				}
			}
		}
	}
	
	public static boolean isIn(int x, int y) {
		return x>=0 && x<M && y>=0 && y<N;
	}
}
