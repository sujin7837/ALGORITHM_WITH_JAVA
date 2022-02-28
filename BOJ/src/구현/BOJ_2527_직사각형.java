package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2527_직사각형 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int startX, startY, endX, endY;
	private static Square [] square;

	static class Square implements Comparable<Square> {
		int sX, sY, eX, eY;

		public Square(int sX, int sY, int eX, int eY) {
			super();
			this.sX = sX;
			this.sY = sY;
			this.eX = eX;
			this.eY = eY;
		}

		@Override
		public String toString() {
			return "Square [sX=" + sX + ", sY=" + sY + ", eX=" + eX + ", eY=" + eY + "]";
		}

		@Override
		public int compareTo(Square o) {
			if(this.sX==o.sX) {
				if(this.eX==o.eX) return Integer.compare(this.sY, o.sY);
				else return Integer.compare(this.eX, o.eX);
			}
			return Integer.compare(this.sX, o.sX);
		}

	}

	public static void main(String[] args) throws IOException {

		bf = new BufferedReader(new InputStreamReader(System.in));
		for(int t=0;t<4;t++) {
			square=new Square[2];
			st = new StringTokenizer(bf.readLine());
			for(int i=0;i<2;i++) {
				startX=Integer.parseInt(st.nextToken());
				startY=Integer.parseInt(st.nextToken());
				endX=Integer.parseInt(st.nextToken());
				endY=Integer.parseInt(st.nextToken());
				square[i]=new Square(startX, startY, endX, endY);
			}
			Arrays.sort(square);
			
			// 입력 확인
//			System.out.println(Arrays.toString(square));
			
			String s=null;
			if(square[0].eX<square[1].sX) s="d";
			else if(square[0].eX==square[1].sX) {
				if(square[0].sY>square[1].eY || square[0].eY<square[1].sY) s="d";
				else if(square[0].sY==square[1].eY || square[0].eY==square[1].sY) s="c";
				else s="b";
			} else {
				if(square[0].sY>square[1].eY || square[0].eY<square[1].sY) s="d";
				else if(square[0].sY==square[1].eY || square[0].eY==square[1].sY) s="b";
				else s="a";
			}
			
			System.out.println(s);
		}

	}

}
