package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17069_파이프옮기기2 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N;
	private static long [][][]dp;
	private static int [][]map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		map=new int[N+1][N+1];
		dp=new long[N+1][N+1][3];
		
		for(int r=1;r<=N;r++) {
			st=new StringTokenizer(bf.readLine());
			for(int c=1;c<=N;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		// 입력 확인
//		for(int []r:map) {
//			for(int c:r) System.out.print(c+ " ");
//			System.out.println();
//		}
		
		dp[1][2][0]=1;
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) {
				if(r==1 && c==1) continue;
				// 가로
				if(isIn(r,c+1) && map[r][c+1]==0) {
					dp[r][c+1][0]=dp[r][c][0]+dp[r][c][2];
				}
				// 세로
				if(isIn(r+1,c) && map[r+1][c]==0) {
					dp[r+1][c][1]=dp[r][c][1]+dp[r][c][2];
				}
				// 대각선
				if(isIn(r+1,c+1) && map[r+1][c]==0 && map[r][c+1]==0 && map[r+1][c+1]==0) {
					dp[r+1][c+1][2]=dp[r][c][0]+dp[r][c][1]+dp[r][c][2];
				}
			}
		}
		long result=dp[N][N][0]+dp[N][N][1]+dp[N][N][2];
		System.out.println(result);
	}
	
	public static boolean isIn(int r, int c) {
		return r>0 && r<=N && c>0 && c<=N;
	}
}
