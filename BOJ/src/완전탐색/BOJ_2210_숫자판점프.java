package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2210_숫자판점프 {

	private static int[][] map=new int[5][5];
	private static HashSet<Integer> set=new HashSet<Integer>();
	private static boolean [][] visited=new boolean[5][5];
	private static int [] dx = {-1,1,0,0};
	private static int [] dy = {0,0,-1,1};
	private static int result=0;
	private static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		for(int r=0;r<5;r++) {
			st=new StringTokenizer(bf.readLine());
			for(int c=0;c<5;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		for(int r=0;r<5;r++) {
			for(int c=0;c<5;c++) {
				dfs(r, c, 0, 0);
			}
		}
//		for(int r:set) System.out.println(r);
//		System.out.println();
		System.out.println(set.size());
	}

	public static void dfs(int x, int y, int cnt, int result) {
		if(cnt==6) {
			set.add(result);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(isIn(nx, ny)) dfs(nx, ny, cnt+1, result*10+map[nx][ny]);
		}
	}
	
	public static boolean isIn(int x, int y) {
		return x>=0 && x<5 && y>=0 && y<5;
	}
}
