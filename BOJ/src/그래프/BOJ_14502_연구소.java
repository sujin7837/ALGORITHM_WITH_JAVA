package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M, result;
	private static int [][]map;
	private static boolean [][]visitedVirus;
	private static List<Point> point;
	private static int [] dx= {-1,1,0,0};
	private static int [] dy= {0,0,-1,1};
	
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		point=new ArrayList<>();
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(bf.readLine());
			for(int c=0;c<M;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
				if(map[r][c]==0) point.add(new Point(r, c));
			}
		}
		
		// 입력 확인
//		for(int []r:map) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		result=Integer.MIN_VALUE;
		combination(3, new Point[3], 0);
		System.out.println(result);
	}

	private static void combination(int toChoose, Point [] choosed, int start) {
		if(toChoose==0) {
			int [][]newMap=new int[N][M];
			getMap(map, newMap);	// 벽을 세운 새로운 맵
			for(int i=0;i<choosed.length;i++) {
				Point p=choosed[i];
				newMap[p.r][p.c]=1;
			}
			
//			print(newMap);
//			System.out.println();
			
			virus(newMap);	// 바이러스가 퍼진 상태 업데이트
			int res=safeArea(newMap);
			result=Math.max(result, res);
			return;
		}
		
		for(int i=start;i<point.size();i++) {
			choosed[choosed.length-toChoose]=point.get(i);
			combination(toChoose-1, choosed, i+1);
		}
	}
	
//	private static void print(int [][]newMap) {
//		for(int []r:newMap) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
//	}
	
	private static int safeArea(int [][]newMap) {
		int cnt=0;
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				if(newMap[r][c]==0) cnt++;
			}
		}
		
		return cnt;
	}
	
	private static void bfs(Point point, boolean [][]visitedVirus, int [][]newMap) {
		Queue<Point> queue=new LinkedList<>();
		queue.add(point);
		
		while(!queue.isEmpty()) {
			Point p=queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx=p.r+dx[i];
				int ny=p.c+dy[i];
				
				if(isIn(nx, ny) && !visitedVirus[nx][ny] && newMap[nx][ny]==0) {
					visitedVirus[nx][ny]=true;
					newMap[nx][ny]=2;
					queue.add(new Point(nx, ny));
				}
			}
		}
		
	}
	
	private static void virus(int [][]newMap) {
		visitedVirus=new boolean[N][M];
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				if(newMap[r][c]==2 && !visitedVirus[r][c]) {
					visitedVirus[r][c]=true;
					bfs(new Point(r, c), visitedVirus, newMap);
				}
			}
		}
		
	}
	
	
	private static void getMap(int [][]map, int [][]newMap) {	// 벽 3개를 세운 새로운 맵
		for(int r=0;r<N;r++) newMap[r]=map[r].clone();
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
