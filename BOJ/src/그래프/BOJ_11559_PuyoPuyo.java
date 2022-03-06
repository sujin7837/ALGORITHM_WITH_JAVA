package 그래프;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11559_PuyoPuyo {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static char [][] map;
	private static int [] dx = {-1,1,0,0};
	private static int [] dy = {0,0,-1,1};
	private static List<Point> list=new ArrayList<>();
	private static boolean [][] visited=new boolean[12][6];
	private static boolean [][] visited2=new boolean[12][6];
	public static void main(String[] args) throws IOException {

		map=new char[12][6];
		bf=new BufferedReader(new InputStreamReader(System.in));
		for(int r=0;r<12;r++) {
			st=new StringTokenizer(bf.readLine());
			map[r]=st.nextToken().toCharArray();
		}
		
		// 입력 확인
//		for(char []r:map) {
//			for(char c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		int result=0;
		while(true) {
			visited=new boolean[12][6];
			List<Point> can=new ArrayList<>();
			for(int r=0;r<12;r++) {
				for(int c=0;c<6;c++) {
					if(map[r][c]!='.' && !visited[r][c]) {
						if(bfs(r,c)) can.add(new Point(r, c));
					}
				}
			}
			if(can.size()==0) break;
			for(int i=0;i<can.size();i++) {
				visited=new boolean[12][6];
				bfs2(can.get(i).x, can.get(i).y);
				
				makeMap();
			}
			result++;
		}

		System.out.println(result);
	}

	public static boolean bfs(int r, int c) {
		Queue<Point> queue=new LinkedList<>();
		queue.add(new Point(r, c));
		list.add(new Point(r, c));
		
//		boolean [][] visited2=new boolean[12][6];
		visited[r][c]=true;
		
		int cnt=1;
		while(!queue.isEmpty()) {
			Point p=queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				
				if(isIn(nx, ny) && !visited[nx][ny] && map[nx][ny]==map[r][c]) {
					visited[nx][ny]=true;
					cnt++;
					queue.add(new Point(nx, ny));
					list.add(new Point(nx, ny));
				}
			}
		}
		
		if(cnt>=4) return true;
		else return false;
	}
	
	public static void bfs2(int r, int c) {
		Queue<Point> queue=new LinkedList<>();
		queue.add(new Point(r, c));
		
		visited[r][c]=true;
		while(!queue.isEmpty()) {
			Point p=queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				
				if(isIn(nx, ny) && !visited[nx][ny] && map[nx][ny]==map[r][c]) {
					visited[nx][ny]=true;
					map[nx][ny]='.';
					queue.add(new Point(nx, ny));
				}
			}
		}
		map[r][c]='.';
		return;
	}
	
	public static void makeMap() {
		int [] tmp=new int[6];
		for(int i=0;i<6;i++) tmp[i]=11;
		for(int c=0;c<6;c++) {
			for(int r=11;r>=0;r--) {
				if(map[r][c]!='.') {
//					System.out.println("r: "+r+" c: "+c+" tmp[c]: "+tmp[c]);
					if(r==tmp[c]) {
						tmp[c]--;
						continue;
					}
					map[tmp[c]][c]=map[r][c];
					map[r][c]='.';
					tmp[c]--;
				}
			}
		}
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && r<12 && c>=0 && c<6;
	}
}
