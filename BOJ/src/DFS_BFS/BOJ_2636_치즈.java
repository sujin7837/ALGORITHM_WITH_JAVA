package DFS_BFS;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int R, C, cnt=0, time=0;
	private static int [][]graph;
	private static int [] dx= {-1,1,0,0};
	private static int [] dy= {0,0,-1,1};
	private static List<Point> list;
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		graph=new int[R][C];
		
		for(int r=0;r<R;r++) {
			st=new StringTokenizer(bf.readLine());
			for(int c=0;c<C;c++) {
				graph[r][c]=Integer.parseInt(st.nextToken());
				if(graph[r][c]==1) cnt++;
			}
		}
		
		while(cnt>0) {
			bfs();
			graphRenew();
			cnt-=list.size();
			time++;
//			System.out.println(cnt+" : "+time);
		}
		System.out.println(time);;
		System.out.println(list.size());
	}
	
	public static void bfs() {
		Queue<Point> queue=new LinkedList<>();
		queue.add(new Point(0,0));
		
		boolean [][]visited=new boolean[R][C];
		visited[0][0]=true;
		
		list=new ArrayList<>();
		
		while(!queue.isEmpty()) {
			Point p=queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				
				if(isIn(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny]=true;
					if(graph[nx][ny]==0) queue.add(new Point(nx, ny));
					else list.add(new Point(nx, ny));
				}
			}
		}
	}
	
	public static void graphRenew() {
		for(int i=0;i<list.size();i++) {
			int x=list.get(i).x;
			int y=list.get(i).y;
			
			graph[x][y]=0;
		}
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
}
