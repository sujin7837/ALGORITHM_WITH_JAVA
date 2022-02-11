package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16935_배열돌리기3 {

	private static int N, M, R, bigSize;
	private static int[][] arr;
	private static int[][] arrTmp;
	private static List<Integer> NUM = new ArrayList<Integer>();
	private static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		bigSize=Math.max(N, M);
		arr=new int[bigSize][bigSize];
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(bf.readLine());
			for(int c=0;c<M;c++) {
				arr[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		st=new StringTokenizer(bf.readLine());
		while(st.hasMoreTokens()) {
			NUM.add(Integer.parseInt(st.nextToken()));
		}
		
		// 입력 확인
//		for(int []r:arr) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
//		
//		for(int r:NUM) System.out.print(r+" ");
		
		for(int r:NUM) {
			choice(r);
			
		}
		
		for(int []r:arr) {
			for(int c:r) {
				if(c==0) continue;
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}

	public static void choice(int n) {
		switch(n) {
		case 1:
			op1();
			break;
		case 2:
			op2();
			break;
		case 3:
			op3();
			break;
		case 4:
			op4();
			break;
		case 5:
			op5();
			break;
		case 6:
			op6();
			break;
		default:
			break;
		}
		
				
	}
	// 상하 반전
	public static void op1() {
		for(int c=0;c<M;c++) {
			for(int r=0;r<N/2;r++) {
				int tmp=arr[r][c];
				arr[r][c]=arr[N-1-r][c];
				arr[N-1-r][c]=tmp;
			}
		}
	}
	
	// 좌우 반전
	public static void op2() {
		for(int r=0;r<N;r++) {
			for(int c=0;c<M/2;c++) {
				int tmp=arr[r][c];
				arr[r][c]=arr[r][M-1-c];
				arr[r][M-1-c]=tmp;
			}
		}
	}
	
	// 오른쪽으로 90도
	public static void op3() {
		int tmp=N;
		N=M;
		M=tmp;
		arrTmp=new int[N][M];
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) arrTmp[r][c]=arr[M-c-1][r];
		}
		arr=new int[bigSize][bigSize];
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) arr[r][c]=arrTmp[r][c];
		}
	}
	
	// 왼쪽으로 90도
	public static void op4() {
		int tmp=N;
		N=M;
		M=tmp;
		arrTmp=new int[N][M];
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) arrTmp[r][c]=arr[c][N-r-1];
		}
		arr=new int[bigSize][bigSize];
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) arr[r][c]=arrTmp[r][c];
		}
	}
	
	// 그룹 연산
	// 그룹 시계 방향으로
	public static void op5() {
		arrTmp=new int[N][M];
		int [] dx = {0, N/2, 0, -N/2};
		int [] dy = {M/2, 0, -M/2, 0};
		int [] ox = {0, 0, N/2, N/2};
		int [] oy = {0, M/2, M/2, 0};
		int idx=0;
		
		for(int i=0;i<4;i++) {
			for(int r=ox[i];r<ox[i]+N/2;r++) {
				for(int c=oy[i];c<oy[i]+M/2;c++) {
					arrTmp[r+dx[i]][c+dy[i]]=arr[r][c];
				}
			}
		}
		arr=new int[bigSize][bigSize];
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) arr[r][c]=arrTmp[r][c];
		}
	}
	
	// 그룹 반시계 방향으로
	public static void op6() {
		arrTmp=new int[N][M];
		int [] dx = {N/2, 0, -N/2, 0};
		int [] dy = {0, M/2, 0, -M/2};
		int [] ox = {0, N/2, N/2, 0};
		int [] oy = {0, 0, M/2, M/2};
		int idx=0;
		
		for(int i=0;i<4;i++) {
			for(int r=ox[i];r<ox[i]+N/2;r++) {
				for(int c=oy[i];c<oy[i]+M/2;c++) {
					arrTmp[r+dx[i]][c+dy[i]]=arr[r][c];
				}
			}
		}
		arr=new int[bigSize][bigSize];
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) arr[r][c]=arrTmp[r][c];
		}
	}
	
	public static void subset() {
		
	}
}
