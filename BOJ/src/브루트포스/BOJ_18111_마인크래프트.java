package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111_마인크래프트 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M, B;
	private static int [][] map;
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(bf.readLine());
			for(int c=0;c<M;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		// 입력 확인
//		for(int []r:map) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		int resultT=Integer.MAX_VALUE, resultH=0;
		for(int h=0;h<=256;h++) {
			int remove=0, inven=0;
			for(int r=0;r<N;r++) {
				for(int c=0;c<M;c++) {
					if(map[r][c]<h) inven+=h-map[r][c];
					if(map[r][c]>h) remove+=map[r][c]-h;
				}
 			}
			if(remove+B>=inven) {
				int tmp=2*remove+inven;
				if(tmp<=resultT) {
					resultT=tmp;
					resultH=h;
				}
			}
		}
		
		System.out.println(resultT+" "+resultH);
	}

}
