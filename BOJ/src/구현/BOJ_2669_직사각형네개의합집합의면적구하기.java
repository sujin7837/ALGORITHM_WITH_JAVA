package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2669_직사각형네개의합집합의면적구하기 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int sX, sY, eX, eY;
	private static int [][] map;

	static class Rectangle {
		int startX, startY, endX, endY;

		public Rectangle(int startX, int startY, int endX, int endY) {
			super();
			this.startX = startX;
			this.startY = startY;
			this.endX = endX;
			this.endY = endY;
		}

		@Override
		public String toString() {
			return "Rectangle [startX=" + startX + ", startY=" + startY + ", endX=" + endX + ", endY=" + endY + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		Rectangle [] rectangle=new Rectangle[4];
		bf=new BufferedReader(new InputStreamReader(System.in));
		int maxVal=0;
		for(int i=0;i<4;i++) {
			st=new StringTokenizer(bf.readLine());
			sX=Integer.parseInt(st.nextToken());
			sY=Integer.parseInt(st.nextToken());
			eX=Integer.parseInt(st.nextToken());
			eY=Integer.parseInt(st.nextToken());
			maxVal=Math.max(maxVal, eX);
			maxVal=Math.max(maxVal, eY);
			rectangle[i]=new Rectangle(sX, sY, eX, eY);
		}
		
		map=new int[maxVal][maxVal];
		for(int i=0;i<4;i++) {
			for(int r=rectangle[i].startX;r<rectangle[i].endX;r++) {
				for(int c=rectangle[i].startY;c<rectangle[i].endY;c++) {
					map[r][c]=1;
				}
			}
		}
		
		int result=0;
		for(int r=0;r<maxVal;r++) {
			for(int c=0;c<maxVal;c++) {
				if(map[r][c]==1) result++;
			}
		}
		
		System.out.println(result);
	}

}
