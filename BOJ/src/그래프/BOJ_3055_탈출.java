package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055_탈출 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int R, C;
	private static char [][]map;
	private static int []dx= {-1,1,0,0};
	private static int []dy= {0,0,-1,1};
	private static Point hedgehog;
	private static List<Point> list;
	
	static class Point {
		int r, c, time;
		char [][]map;
		
		public Point(int r, int c, int time, char[][] map) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
			this.map = map;
		}
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", time=" + time + ", map=" + Arrays.toString(map) + "]";
		}

	}
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		
		for(int r=0;r<R;r++) {
			String s=br.readLine();
			for(int c=0;c<C;c++) {
				map[r][c]=s.charAt(c);
				if(map[r][c]=='S') hedgehog=new Point(r, c, 0, new char[R][C]);
			}
		}
		
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) hedgehog.map[r][c]=map[r][c];
		}
		
		
		int result=bfs();
		if(result==-1) System.out.println("KAKTUS");
		else System.out.println(result);
	}

	private static int bfs() {
		Queue<Point> queue=new LinkedList<>();
		queue.add(hedgehog);
		
		boolean [][]visited=new boolean[R][C];
		visited[hedgehog.r][hedgehog.c]=true;
		
		while(!queue.isEmpty()) {
			
			Point p=queue.poll();
//			for(int r=0;r<R;r++) {
//				for(int c=0;c<C;c++) System.out.print(p.map[r][c]);
//				System.out.println();
//			}
			
//			if(p.map[p.r][p.r]=='D') return p.time;
			list=new LinkedList<>();
			WaterSpread(p.map);
			for(int i=0;i<4;i++) {
				char [][]tmp=new char[R][C];
				copyMap(p.map, tmp);
				tmp[p.r][p.c]='.';
				
				int nx=p.r+dx[i];
				int ny=p.c+dy[i];
				
				if(isIn(nx, ny) && !visited[nx][ny]) {
					if(tmp[nx][ny]=='.') {
						visited[nx][ny]=true;
						tmp[nx][ny]='S';
						queue.add(new Point(nx, ny, p.time+1, tmp));
					} else if(tmp[nx][ny]=='D') return p.time+1;
				}
			}
		}
		
		return -1;
	}
	
	private static void WaterSpread(char [][]map) {
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(map[r][c]=='*') {
					for(int i=0;i<4;i++) {
						int nx=r+dx[i];
						int ny=c+dy[i];
						
						if(isIn(nx, ny) && map[nx][ny]=='.') {
							list.add(new Point(nx, ny, 0, null));
						}
					}
				}
			}
		}
		
		for(Point p:list) {
			map[p.r][p.c]='*';
		}
	}
	
	private static void copyMap(char[][] map, char[][]tmp) {
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) tmp[r][c]=map[r][c];
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
	
}
