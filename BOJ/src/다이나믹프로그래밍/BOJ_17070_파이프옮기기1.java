package 다이나믹프로그래밍;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기1 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, cnt=0;
	private static int [][]map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		map=new int[N+1][N+1];
		
		for(int r=1;r<=N;r++) {
			st=new StringTokenizer(bf.readLine());
			for(int c=1;c<=N;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}

		recur(1,2,0);
		System.out.println(cnt);
	}
	
	public static void recur(int r, int c, int dir) {
		if(r==N && c==N) {
			if(map[r][c]!=1) {
				cnt++;
				return;
			}
		}
		
		if(dir==0) {	// 가로
			if(isIn(r, c+1) && map[r][c+1]==0) recur(r, c+1, 0);	// 가로
			if(isIn(r+1, c+1) && map[r+1][c]==0 && map[r][c+1]==0 && map[r+1][c+1]==0) recur(r+1, c+1, 2);	// 대각선
		} else if(dir==1) {	// 세로
			if(isIn(r+1, c) && map[r+1][c]==0) recur(r+1, c, 1);	// 세로
			if(isIn(r+1, c+1) && map[r+1][c]==0 && map[r][c+1]==0 && map[r+1][c+1]==0) recur(r+1, c+1, 2);	// 대각선
		} else if(dir==2){	// 대각선
			if(isIn(r, c+1) && map[r][c+1]==0) recur(r, c+1, 0);	// 가로
			if(isIn(r+1, c) && map[r+1][c]==0) recur(r+1, c, 1);	// 세로
			if(isIn(r+1, c+1) && map[r+1][c]==0 && map[r][c+1]==0 && map[r+1][c+1]==0) recur(r+1, c+1, 2);	// 대각선
		}
	}

	public static boolean isIn(int r, int c) {
		return r>0 && r<=N && c>0 && c<=N;
	}
}
