package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17779_게리맨더링 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, min, max, result;
	private static int [][]map, garim;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N+1][N+1];
		
		for(int r=1;r<=N;r++) {
			st=new StringTokenizer(br.readLine());
			for(int c=1;c<=N;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
//		garim=new int[N+1][N+1];
//		garimendering(2,4,2,2);
//		for(int []r:garim) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
//		min=Integer.MAX_VALUE;
//		max=Integer.MIN_VALUE;
//		for(int i=1;i<=5;i++) {
//			int get=population(i);
//			System.out.println(i+" : "+get);
//			min=Math.min(min, get);
//			max=Math.max(max, get);
//		}
		result=Integer.MAX_VALUE;
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) {
				for(int d1=1;d1+r<N;d1++) {
					if(d1+1>c) continue;
					for(int d2=1;d2+d1+r<=N;d2++) {
						if(d2+c>N) continue;
						garim=new int[N+1][N+1];
						garimendering(r, c, d1, d2);
						min=Integer.MAX_VALUE;
						max=Integer.MIN_VALUE;
						for(int i=1;i<=5;i++) {
							int get=population(i);
							min=Math.min(min, get);
							max=Math.max(max, get);
						}
//						System.out.println(r+" :: "+c+" :: "+d1+" :: "+d2+" :: "+min+" "+max+" "+result);
						result=Integer.min(result, max-min);
					}
				}
			}
		}
		
		System.out.println(result);
	}

	private static void garimendering(int x, int y, int d1, int d2) {
		int R=x;
		int C=y;
		while(R<=x+d1) {
			garim[R][C]=5;
			R++;
			C--;
		}
		R=x;
		C=y;
		while(R<=x+d2) {
			garim[R][C]=5;
			R++;
			C++;
		}
		R=x+d1;
		C=y-d1;
		while(R<=x+d1+d2) {
			garim[R][C]=5;
			R++;
			C++;
		}
		R=x+d2+d1;
		C=y+d2-d1;
		while(R>=x+d2) {
			garim[R][C]=5;
			R--;
			C++;
		}

		for(int r=1;r<x+d1;r++) {	// 1
			for(int c=1;c<=y;c++) {
				if(garim[r][c]==0) garim[r][c]=1;
				else break;
			}
		}
		for(int r=1;r<=x+d2;r++) {	// 2
			for(int c=N;c>=y+1;c--) {
				if(garim[r][c]==0) garim[r][c]=2;
				else break;
			}
		}
		for(int r=x+d1;r<=N;r++) {	// 3
			for(int c=1;c<y-d1+d2;c++) {
				if(garim[r][c]==0) garim[r][c]=3;
				else break;
			}
		}
		for(int r=N;r>x+d2;r--) {	// 4
			for(int c=N;c>=y-d1+d2;c--) {
				if(garim[r][c]==0) garim[r][c]=4;
				else break;
			}
		}
		
		for(int r=x;r<=x+d1+d2;r++) {	// 5
			for(int c=y-d1;c<=y+d2;c++) {
				if(garim[r][c]==0) garim[r][c]=5;
			}
		}
	}
	
	private static int population(int x) {	// 선거구 x의 인구 수
		int cnt=0;
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) {
				if(garim[r][c]==x) cnt+=map[r][c];
			}
		}
//		System.out.println(x+" : "+cnt);
		return cnt;
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
