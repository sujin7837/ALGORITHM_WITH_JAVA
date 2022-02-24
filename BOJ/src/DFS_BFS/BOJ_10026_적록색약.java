package 그래프;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10026_적록색약 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N;
	private static char [][] arr;
	private static boolean [][]visited;
	private static int [] dx= {-1,1,0,0};
	private static int [] dy= {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		arr=new char[N][N];
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(bf.readLine());
			arr[r]=st.nextToken().toCharArray();
		}
		
		// 입력 확인
//		for(char [] r:arr) {
//			for(char c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		int result1=0;
		visited=new boolean[N][N];
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(!visited[r][c]) {
					result1++;
					bfs(r, c);
				}
			}
		}
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(arr[r][c]=='G') arr[r][c]='R';
			}
		}
		
		int result2=0;
		visited=new boolean[N][N];
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(!visited[r][c]) {
					result2++;
					bfs(r, c);
				}
			}
		}
		
		System.out.print(result1+" "+result2);
	}

	public static void bfs(int r, int c) {
		visited[r][c]=true;
		Queue<Point> queue=new LinkedList<>();
		queue.add(new Point(r, c));
		
		while(!queue.isEmpty()) {
			Point p=queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				
				if(isIn(nx, ny) && !visited[nx][ny] && arr[nx][ny]==arr[p.x][p.y]) {
					visited[nx][ny]=true;
					queue.add(new Point(nx, ny));
				}
			}
		}
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
