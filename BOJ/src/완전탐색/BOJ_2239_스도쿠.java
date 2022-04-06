package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2239_스도쿠 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int [][]map;
	private static List<Point> list;
	
	static class Point {
		int r, c, val;

		public Point(int r, int c, int val) {
			super();
			this.r = r;
			this.c = c;
			this.val = val;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		bf=new BufferedReader(new InputStreamReader(System.in));
		map=new int[9][9];
		list=new ArrayList<>();
		
		for(int r=0;r<9;r++) {
			String s=bf.readLine();
			for(int c=0;c<9;c++) {
				map[r][c]=s.charAt(c)-'0';
				if(map[r][c]==0) list.add(new Point(r, c, 0));
			}
		}
		
		sudocu(0, map);
	}
	
	
	private static boolean sudocu(int count, int [][]map) {
		if(count==list.size()) {
			for(int []r:map) {
				for(int c:r) System.out.print(c);
				System.out.println();
			}
			return true;
		}
		int [][]newMap=new int[9][9];
		copyMap(map, newMap);
		
		Point p=list.get(count);
		for(int i=1;i<=9;i++) {
			if(!check(p.r, p.c, i, newMap)) continue;	// i 못 들어감
			newMap[p.r][p.c]=i;
			if(sudocu(count+1, newMap)) return true;
		}
		
		return false;
	}
	
	private static void copyMap(int [][]map, int [][]newMap) {
		for(int r=0;r<9;r++) newMap[r]=map[r].clone();
	}
	
	private static boolean check(int r, int c, int x, int [][]map) {
		for(int i=0;i<9;i++) {
			if(map[r][i]==x) return false;	// 가로
			if(map[i][c]==x) return false;	// 세로
		}
		
		int startR=r-r%3;
		int startC=c-c%3;
		for(int R=startR;R<startR+3;R++) {	// 3x3
			for(int C=startC;C<startC+3;C++) {
				if(map[R][C]==x) return false;
			}
		}
		return true;
	}

}
