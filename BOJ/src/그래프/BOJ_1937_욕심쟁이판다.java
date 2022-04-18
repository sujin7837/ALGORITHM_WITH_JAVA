package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1937_욕심쟁이판다 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, result=Integer.MIN_VALUE;
	private static int [][]map;
	private static int [][]dp;
	private static int []dx= {-1,1,0,0};
	private static int []dy= {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		dp=new int[N][N];	// startR, startE, endR, endE
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) dp[r][c]=-1;
			}
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				int cnt=dfs(r, c);
				result=Math.max(result, cnt);
			}
		}
		
		System.out.println(result);
	}

	private static int dfs(int r, int c) {
		if(dp[r][c]!=-1) return dp[r][c];
		
		dp[r][c]=1;
		for(int d=0;d<4;d++) {
			int nx=r+dx[d];
			int ny=c+dy[d];
			
			if(isIn(nx, ny) && map[nx][ny]>map[r][c]) {
				dp[r][c]=Math.max(dp[r][c], dfs(nx, ny)+1);
			}
		}
		
		return dp[r][c];
	}
	
	
	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
