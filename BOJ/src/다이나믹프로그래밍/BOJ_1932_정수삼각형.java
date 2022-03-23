package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932_정수삼각형 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, result=0;
	private static int [][]arr, dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		arr=new int[N][N];
		dp=new int[N][N];
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(bf.readLine());
			for(int c=0;c<=r;c++) {
				arr[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		// 입력 확인
//		for(int []r:arr) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		dp[0][0]=arr[0][0];
		for(int r=1;r<N;r++) {
			for(int c=0;c<=r;c++) {
				if(c==0) dp[r][c]=dp[r-1][c]+arr[r][c];
				else if(c==r) dp[r][c]=dp[r-1][c-1]+arr[r][c];
				else dp[r][c]=Math.max(dp[r-1][c-1], dp[r-1][c])+arr[r][c];
			}
		}
		
		for(int i=0;i<N;i++) {
			result=Math.max(result, dp[N-1][i]);
		}
		System.out.println(result);
	}

}
