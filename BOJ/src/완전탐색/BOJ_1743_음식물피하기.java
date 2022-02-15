package 완전탐색;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743_음식물피하기 {

	private static int N, M, K, tmp=0, maxNum=Integer.MIN_VALUE;
	private static int [][] map;
	private static boolean[][] visited;
	private static int []dx = {-1,1,0,0};
	private static int []dy = {0,0,-1,1};
	private static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[N+1][M+1];
		visited=new boolean[N+1][M+1];
		
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(bf.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			map[x][y]=1;
		}
		
		// 입력 확인
//		for(int []r:map) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		int result=0;
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=M;c++) {
				if(map[r][c]==1 && !visited[r][c]) {
					tmp=0;
					bfs(r, c);
					result=Math.max(result, tmp);
				}
			}
		}
		System.out.println(result);
	}

	public static void bfs(int x, int y) {
//		System.out.println("x: "+x+" y: "+y+" tmp: "+tmp);
		tmp++;
		visited[x][y]=true;
		Queue<Point> queue=new LinkedList<Point>();
		queue.add(new Point(x, y));
		
		while(!queue.isEmpty()) {
			Point p=queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				
				if(isIn(nx, ny) && !visited[nx][ny] && map[nx][ny]==1) {
					visited[nx][ny]=true;
					bfs(nx, ny);
				}
			}
		}
	}
	
	public static boolean isIn(int x, int y) {
		return x>0 && x<=N && y>0 && y<=M;
	}
}
