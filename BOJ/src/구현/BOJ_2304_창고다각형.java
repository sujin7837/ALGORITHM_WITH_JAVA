package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2304_창고다각형 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N;
	private static Column [] column;
	private static int [][] map;
	
	static class Column implements Comparable<Column> {
		int position, height;

		public Column(int position, int height) {
			super();
			this.position = position;
			this.height = height;
		}

		@Override
		public String toString() {
			return "Column [position=" + position + ", height=" + height + "]";
		}

		@Override
		public int compareTo(Column o) {
			return Integer.compare(this.position, o.position);
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		column=new Column[N];
		
		int maxH=0, idx=0;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			column[i]=new Column(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			if(column[i].height>maxH) {
				maxH=column[i].height;
				idx=column[i].position;
			}
		}
		Arrays.sort(column);
//		System.out.println(Arrays.toString(column));
		map=new int[maxH+1][column[N-1].position+1];
		
		// 입력 확인
//		for(Column c:column) System.out.println(c);
//		System.out.println(maxH+" : "+idx);
		
		int nowR=column[0].height;
		int nowIdx=0;
		for(int c=column[0].position;c<=idx;c++) {
			if(c==column[nowIdx].position) {
				if(column[nowIdx].height>nowR) nowR=column[nowIdx].height;
				nowIdx++;
			}
			for(int r=0;r<nowR;r++) map[r][c]=1;
		}
		
		nowR=column[N-1].height;
		nowIdx=N-1;
//		System.out.println(nowR+" : "+nowIdx);
		for(int c=column[N-1].position;c>idx;c--) {
			if(c==column[nowIdx].position) {
				if(column[nowIdx].height>nowR) nowR=column[nowIdx].height;
				nowIdx--;
			}
			for(int r=0;r<nowR;r++) {
//				System.out.println("r: "+r+" c: "+c);
				map[r][c]=1;
			}
		}
		
//		for(int []r:map) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		int result=0;
		for(int []r:map) {
			for(int c:r) {
				if(c==1) result++;
			}
		}
		System.out.println(result);
	}

}
