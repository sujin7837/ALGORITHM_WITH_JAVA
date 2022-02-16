package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1992_쿼드트리 {

	private static int N;
	private static String [][] map;
	private static String result="";
	private static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		map=new String[N][N];
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(bf.readLine());
			String []s=st.nextToken().split("");
			for(int c=0;c<N;c++) {
				map[r][c]=s[c];
			}
		}
		
		// 입력 확인
//		for(String []r:map) {
//			for(String c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		
		divide(N, 0, 0);
			
		System.out.println(result);
	}

	public static void divide(int n, int r, int c) {
		if(check(n, r, c)) {
			result+=map[r][c];
			return;
		}
		else {
			result+="(";
			divide(n/2, r, c);
			divide(n/2, r, c+n/2);
			divide(n/2, r+n/2, c);
			divide(n/2, r+n/2, c+n/2);
			result+=")";
		}
	}
	
	public static boolean check(int n, int r, int c) {
		for(int i=r;i<r+n;i++) {
			for(int j=c;j<c+n;j++) {
				if(!map[i][j].equals(map[r][c])) return false;
			}
		}
		return true;
	}
}
