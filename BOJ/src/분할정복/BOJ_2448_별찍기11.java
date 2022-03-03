package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2448_별찍기11 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N;
	private static char [][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		map=new char[N][5*(N/3)+(N/3-1)];
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<5*(N/3)+(N/3-1);c++) {
				map[r][c]=' ';
			}
		}
		divide(0, N-1, N);
		StringBuilder sb=new StringBuilder();
		for(char []r:map) {
			for(char c:r) sb.append(c);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void divide(int x, int y, int height) {
		if(height==3) {
			map[x][y]='*';
			map[x+1][y-1]=map[x+1][y+1]='*';
			for(int i=0;i<5;i++) {
				map[x+2][y-2+i]='*';
			}
			return;
		}
		divide(x, y, height/2);
		divide(x+height/2, y-height/2, height/2);
		divide(x+height/2, y+height/2, height/2);
	}
}
