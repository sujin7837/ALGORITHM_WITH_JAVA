package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int T, N, R, C;
	private static List<int[]> list=new ArrayList<>();
	private static String result;
	private static boolean [][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;t++) {
			list=new ArrayList<>();
			N=Integer.parseInt(bf.readLine());
			for(int n=0;n<N+2;n++) {
				st=new StringTokenizer(bf.readLine());
				list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			map=new boolean[N+2][N+2];
			for(int r=0;r<N+2;r++) {
				for(int c=0;c<N+2;c++) {
					if(distance(list.get(r)[0], list.get(r)[1], list.get(c)[0], list.get(c)[1])<=1000) {
						map[r][c]=true;
					}
				}
			}
			
			for(int k=0;k<N+2;k++) {
				for(int r=0;r<N+2;r++) {
					for(int c=0;c<N+2;c++) {
						if(map[r][k] && map[k][c]) map[r][c]=true;
					}
				}
			}
			
			if(map[0][N+1]) System.out.println("happy");
			else System.out.println("sad");
		}
	}

	public static int distance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1-r2)+Math.abs(c1-c2);
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
}
