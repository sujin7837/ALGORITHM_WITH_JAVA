package 그래프;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086_아기상어2 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M, maxVal=0;
	private static int [][] map;
	private static int [][] visited;
	private static Queue<Point> queue=new LinkedList<>();
	private static int [] dx = {-1,-1,-1,1,1,1,0,0};
	private static int [] dy = {-1,0,1,-1,0,1,-1,1};
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		visited=new int[N][M];
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(bf.readLine());
			for(int c=0;c<M;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
				visited[r][c]=Integer.MAX_VALUE;
				if(map[r][c]==1) {
					queue.offer(new Point(r, c));
					visited[r][c]=0;
				}
			}
		}
		
		// 입력 확인
//		for(int []r:map) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		bfs();
		System.out.println(maxVal);
	}
	
	public static void bfs() {
		
		while(!queue.isEmpty()) {
			Point p=queue.poll();
			
			for(int i=0;i<8;i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				
				if(isIn(nx, ny)) {
					if(visited[nx][ny]>visited[p.x][p.y]+1) {
						visited[nx][ny]=visited[p.x][p.y]+1;
						maxVal=Math.max(maxVal, visited[nx][ny]);
						queue.offer(new Point(nx, ny));
					}
				}
			}
		}
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
