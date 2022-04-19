package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, L, R, cnt;
	private static int [][]map;
	private static int []dx= {-1,1,0,0};
	private static int []dy= {0,0,-1,1};
	private static boolean [][]visited;
	private static List<Point> list;
	
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
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		boolean have=true;
		cnt=0;
		while(have) {
			have=false;
			visited=new boolean[N][N];
//			print();
//			System.out.println();
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					if(!visited[r][c]) {
						list=new ArrayList<>();
						if(bfs(r, c)) {	// 인구 이동이 발생
							move();
							have=true;
						}
					}
				}
			}
			if(have) cnt++;
		}
		
		System.out.println(cnt);
	}
	
	private static void print() {
		for(int []r:map) {
			for(int c:r) System.out.print(c+" ");
			System.out.println();
		}
	}

	private static boolean bfs(int r, int c) {
		boolean check=false;
		Queue<Point> queue=new LinkedList<>();
		queue.add(new Point(r, c));
		visited[r][c]=true;
		list.add(new Point(r, c));
		
		while(!queue.isEmpty()) {
			Point p=queue.poll();
			
			for(int d=0;d<4;d++) {
				int nx=p.r+dx[d];
				int ny=p.c+dy[d];
				
				if(isIn(nx, ny) && !visited[nx][ny]) {
					int diff=Math.abs(map[nx][ny]-map[p.r][p.c]);
					if(diff<L || diff>R) continue;	// 인구 차이가 범위를 벗어남
//					System.out.println(queue);
					visited[nx][ny]=true;
					queue.add(new Point(nx, ny));
					list.add(new Point(nx, ny));
					check=true;
				}
			}
		}
		return check;
	}
	
	private static void move() {
//		System.out.println(list+" "+list.size());
		int sum=0;
		int count=list.size();
		
		for(int i=0;i<count;i++) {
			Point p=list.get(i);
			sum+=map[p.r][p.c];
		}
		
		sum/=count;
		for(int i=0;i<count;i++) {
			Point p=list.get(i);
			map[p.r][p.c]=sum;
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
