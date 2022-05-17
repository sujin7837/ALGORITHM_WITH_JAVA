package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1890_점프 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int N;
	private static int[][] map;
	private static long [][]dp;
	private static int[] dx = { 0, 1 };
	private static int[] dy = { 1, 0 };

	static class Path {
		int r, c;

		public Path(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Path [r=" + r + ", c=" + c + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new long[N][N];
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) dp[r][c]=-1;
		}

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dfs(0,0));
	}

	private static long dfs(int r, int c) {
		if(r==N-1 && c==N-1) return 1;
		if(dp[r][c]!=-1) return dp[r][c];
		if(map[r][c]==0) return 0;
		
		dp[r][c]=0;
		if(c+map[r][c]<N) dp[r][c]+=dfs(r, c+map[r][c]);
		if(r+map[r][c]<N) dp[r][c]+=dfs(r+map[r][c], c);
		return dp[r][c];
	}
}
