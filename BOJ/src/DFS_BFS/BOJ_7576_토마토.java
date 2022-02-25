package DFS_BFS;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int M, N, depth=0;
	private static int [][] tomatoes;
	private static int [] dx = {-1,1,0,0};
	private static int [] dy = {0,0,-1,1};
	private static boolean [][] visited;
	private static Queue<Point> queue=new LinkedList<>();
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		tomatoes=new int[N][M];
		visited=new boolean[N][M];
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(bf.readLine());
			for(int c=0;c<M;c++) {
				tomatoes[r][c]=Integer.parseInt(st.nextToken());
				if(tomatoes[r][c]==1) queue.offer(new Point(r, c));
			}
		}
		
		// 입력 확인
//		for(int []r:tomatoes) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		bfs();
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				if(tomatoes[r][c]==0) depth=-1;
			}
		}
		if(depth==-1) System.out.println(depth);
		else System.out.println(depth-1);
	}

	public static void bfs() {
		while(!queue.isEmpty()) {
			int size=queue.size();
			depth++;
			while(size-->0) {
				Point p=queue.poll();
				for(int i=0;i<4;i++) {
					int nx=p.x+dx[i];
					int ny=p.y+dy[i];
					
					if(isIn(nx, ny) && tomatoes[nx][ny]==0) {
						tomatoes[nx][ny]=1;
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
