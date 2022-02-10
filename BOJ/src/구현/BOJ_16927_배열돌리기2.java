package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16927_배열돌리기2 {

	private static int N, M, R;
	private static int[][] arr;
//	private static int[] dx= {1,0,-1,0};
//	private static int[] dy= {0,1,0,-1};
	private static int[][] result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s=bf.readLine();
		StringTokenizer st=new StringTokenizer(s, " ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		int cnt=Math.min(N,  M) / 2;
		
		for(int r=0;r<N;r++) {
			s=bf.readLine();
			st=new StringTokenizer(s, " ");
			for(int c=0;c<M;c++) arr[r][c]=Integer.parseInt(st.nextToken());
		}
		
		// input test
//		for(int r[]:arr) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		// start
//		result=new int[N][M];
		
		for(int d=0;d<cnt;d++) {
			int round=(N-1-2*d)*2+(M-1-2*d)*2;
			int Mod=R%round;
			for(int ro=0;ro<Mod;ro++) {
				rotate(d);
			}
		}
		
//		 결과 출력
		for(int[] r:arr) {
			for(int c:r) System.out.print(c+" ");
			System.out.println();
		}
	}
	
	public static void rotate(int d) {
		int keep=arr[d][d];
		for(int c=d+1;c<M-d;c++) {
			arr[d][c-1]=arr[d][c];
		}
		for(int r=d+1;r<N-d;r++) {
			arr[r-1][M-d-1]=arr[r][M-d-1];
		}
		for(int c=M-d-2;c>=d;c--) {
			arr[N-d-1][c+1]=arr[N-d-1][c];
		}
		for(int r=N-d-2;r>=d+1;r--) {
			arr[r+1][d]=arr[r][d];
		}
		arr[d+1][d]=keep;
	}
}
