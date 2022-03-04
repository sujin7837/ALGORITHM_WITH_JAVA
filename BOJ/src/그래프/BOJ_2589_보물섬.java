package 그래프;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int R, C, maxVal=0, result=0;
	private static char [][] map;
	private static int [] dx = {-1,1,0,0};
	private static int [] dy = {0,0,-1,1};
	private static int [][] visited;
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		visited=new int[R][C];
		
		for(int r=0;r<R;r++) {
			st=new StringTokenizer(bf.readLine());
			map[r]=st.nextToken().toCharArray();
		}
		
		// 입력 확인
//		for(char []r:map) {
//			for(char c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(map[r][c]=='L') {
					visited=new int[R][C];
					maxVal=0;
					bfs(r, c);
					result=Math.max(result, maxVal);
				}
			}
		}
		System.out.println(result-1);
	}

	public static void bfs(int r, int c) {
		Queue<Point> queue=new LinkedList<>();
		queue.offer(new Point(r, c));
		
		visited[r][c]=1;
		
		while(!queue.isEmpty()) {
			Point p=queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				
				if(isIn(nx, ny) && visited[nx][ny]==0 && map[nx][ny]=='L') {
//					System.out.println(cnt+" x: "+nx+" y: "+ny);
					visited[nx][ny]=visited[p.x][p.y]+1;
					maxVal=Math.max(maxVal, visited[nx][ny]);
					queue.add(new Point(nx, ny));
//					list.add(new Point(nx, ny));
				}
			}
		}	
	}
	
	
	public static boolean isIn(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
}
