package 구현;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578_빙고 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int [][] map=new int[5][5];
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		for(int r=0;r<5;r++) {
			st=new StringTokenizer(bf.readLine());
			for(int c=0;c<5;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		// 입력 확인
//		for(int []r:map) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		int result=0;
		int bin=0;
		outer : for(int i=0;i<5;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<5;j++) {
				int now=Integer.parseInt(st.nextToken());
				int row=find(now).x;
				int col=find(now).y;
//				System.out.println(now+" : "+row+" : "+col);
				map[row][col]=0;
				result++;
				
//				for(int []r:map) {
//					for(int c:r) System.out.print(c+" ");
//					System.out.println();
//				}
//				System.out.println();
				
				
				bin+=bingo(row, col);
				if(bin>=3) break outer;
			}
		}
		
		System.out.println(result);
	}

	public static Point find(int num) {
		for(int r=0;r<5;r++) {
			for(int c=0;c<5;c++) {
				if(map[r][c]==num) return new Point(r, c);
			}
		}
		return null;
	}
	
	public static int bingo(int r, int c) {
		boolean one=true;
		boolean two=true;
		boolean three=true;
		boolean four=true;
		int get=0;
		
		// 가로
		for(int i=0;i<5;i++) {
			if(map[r][i]!=0) one=false;
		}
		
		// 세로
		for(int i=0;i<5;i++) {
			if(map[i][c]!=0) two=false;
		}
		
		// 우하향 대각선
		if(r==c) {
			for(int i=0;i<5;i++) {
				if(map[i][i]!=0) three=false;
			}
		} else three=false;
		
		// 우상향 대각선
		if(r+c==4) {
			for(int i=0;i<5;i++) {
				if(map[4-i][i]!=0) four=false; 
			}
		} else four=false;
		
		if(one) get++;
		if(two) get++;
		if(three) get++;
		if(four) get++;
		return get;
	}
}
