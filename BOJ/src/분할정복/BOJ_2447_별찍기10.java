package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2447_별찍기10 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N;
	private static char [][] result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		result=new char[N][N];
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) result[r][c]=' ';
		}
		
		divide(0,0,N);
		StringBuilder sb=new StringBuilder();
		for(char []r:result) {
			for(char c:r) sb.append(c);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void divide(int x, int y, int size) {
		if(size==1) {
			result[x][y]='*';
			return;
		}
		size/=3;
		for(int r=0;r<3;r++) {
			for(int c=0;c<3;c++) {
				if(r==1 && c==1) continue;
				divide(x+r*size, y+c*size, size);
			}
		}
	}
}
