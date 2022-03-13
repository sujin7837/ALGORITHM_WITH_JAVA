package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17136_색종이붙이기 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int [][] map;
	private static int [] papers= {0,5,5,5,5,5};
	private static int paperCnt=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		map=new int[10][10];
		
		for(int r=0;r<10;r++) {
			st=new StringTokenizer(bf.readLine());
			for(int c=0;c<10;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,0);
		if(paperCnt==Integer.MAX_VALUE) paperCnt=-1;
		System.out.println(paperCnt);
	}
		
	public static void dfs(int r, int c, int cnt) {
		if(r>=9 && c==10) {
			paperCnt=Math.min(paperCnt, cnt);
			return;
		}
		
		if(cnt>=paperCnt) return;
		if(c==10) {	// 아래줄로 이동
			dfs(r+1,0,cnt);
			return;
		}
		
		if(map[r][c]==1) {
			for(int i=5;i>0;i--) {
				if(papers[i]>0 && coverCheck(r,c,i)) {
					cover(r,c,i, 0);	// 색종이를 붙임
					papers[i]--;
					dfs(r,c+1,cnt+1);
					cover(r,c,i,1);	// 색종이를 뗌
					papers[i]++;
				}
			}
		} else {	// 오른쪽으로 이동
			dfs(r,c+1,cnt);
			return;
		}
	}
	
	
	// n*n 색종이로 덮을 수 있는 지 확인
	public static boolean coverCheck(int r, int c, int n) {
		for(int x=r;x<r+n;x++) {
			for(int y=c;y<c+n;y++) {
				if(!isIn(x,y) || map[x][y]!=1) return false;
			}
		}
		return true;
	}
	
	// 덮기
	public static void cover(int r, int c, int n, int state) {
		for(int x=r;x<r+n;x++) {
			for(int y=c;y<c+n;y++) {
				map[x][y]=state;
			}
		}
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && r<10 && c>=0 && c<10;
	}
}
