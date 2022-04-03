package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12100_2048Easy {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, Max=0;
	private static int [][]map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		map=new int[N][N];
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(bf.readLine());
			for(int c=0;c<N;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		// 입력 확인
//		for(int []r:map) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		game(0);
		System.out.println(Max);
	}

	public static void game(int count) {
		if(count==5) {
			getMax();
			return;
		}
		
		int [][]newMap=new int[N][N];
		for(int r=0;r<N;r++) newMap[r]=map[r].clone();
		
		for(int i=0;i<4;i++) {
			move(i);
			game(count+1);
//			for(int []r:map) {
//				for(int c:r) System.out.print(c+" ");
//				System.out.println();
//			}
			for(int r=0;r<N;r++) map[r]=newMap[r].clone();
		}
	}
	
	public static void getMax() {
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				Max=Math.max(Max, map[r][c]);
			}
		}
	}
	
	public static void move(int dir) {
//		System.out.println(dir);
		if(dir==0) {	// 상
			for(int c=0;c<N;c++) {
				int index=0;
				int block=0;
				for(int r=0;r<N;r++) {
					if(map[r][c]!=0) {
						if(block!=map[r][c]) {	// 값이 합쳐지지 않고 이동만 하는 경우
							block=map[r][c];
							map[r][c]=0;
							map[index][c]=block;
							index++;
						} else {	// 값이 합쳐지는 경우
							map[index-1][c]=block*2;
							map[r][c]=0;
							block=0;
						}
					}
				}
			}
		} else if(dir==1) {	// 하
			for(int c=0;c<N;c++) {
				int index=N-1;
				int block=0;
				for(int r=N-1;r>=0;r--) {
					if(map[r][c]!=0) {
						if(block!=map[r][c]) {
							block=map[r][c];
							map[r][c]=0;
							map[index][c]=block;
							index--;
						} else {
							map[index+1][c]=block*2;
							map[r][c]=0;
							block=0;
						}
					}
				}
			}
		} else if(dir==2) {	// 좌
			for(int r=0;r<N;r++) {
				int index=0;
				int block=0;
				for(int c=0;c<N;c++) {
					if(map[r][c]!=0) {
						if(block!=map[r][c]) {
							block=map[r][c];
							map[r][c]=0;
							map[r][index]=block;
							index++;
						} else {
							map[r][index-1]=block*2;
							map[r][c]=0;
							block=0;
						}
					}
				}
			}
		} else if(dir==3){	// 우
			for(int r=0;r<N;r++) {
				int index=N-1;
				int block=0;
				for(int c=N-1;c>=0;c--) {
					if(map[r][c]!=0) {
						if(block!=map[r][c]) {
							block=map[r][c];
							map[r][c]=0;
							map[r][index]=block;
							index--;
						} else {
							map[r][index+1]=block*2;
							map[r][c]=0;
							block=0;
						}
					}
				}
			}
		}
	}
}
