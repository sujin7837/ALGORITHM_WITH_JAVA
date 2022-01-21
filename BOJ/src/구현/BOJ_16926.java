package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_16926 {
	private static int N, M, R;
	private static int[][] arr;
	private static int[][] result;
	
	public static void rotate() {
		int startR=0, startC=0;
		int size = Math.min(N, M) / 2;
		int sizeR=N, sizeC=M;
		
		for(int i=0;i<size;i++) {
			for(int dir=0;dir<4;dir++) {
				if(dir==0) {
					for(int r=1;r<=sizeR-1;r++) {
						result[startR+r][startC]=arr[startR+r-1][startC];
//						System.out.print("startR: "+(startR+r)+" "+result[startR+r][startC]+" ");
					}
					startR+=sizeR-1;
//					System.out.println(startR);
				} else if(dir==1) {
					for(int c=1;c<=sizeC-1;c++) {
						result[startR][startC+c]=arr[startR][startC+c-1];
					}
					startC+=sizeC-1;
				} else if(dir==2) {
					for(int r=1;r<=sizeR-1;r++) {
						result[startR-r][startC]=arr[startR-r+1][startC];
					}
					startR-=sizeR-1;
				} else if(dir==3) {
					for(int c=1;c<=sizeC-1;c++) {
						result[startR][startC-c]=arr[startR][startC-c+1];
					}
					startR+=1;
					startC-=sizeC-2;
					sizeR-=2;
					sizeC-=2;
//					System.out.println("last startR: "+startR+" last startC: "+startC);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		
		arr = new int[N][M];
		result = new int[N][M];
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		for(int i=0;i<R;i++) {
			rotate();
			for(int j=0;j<result.length;j++) {
				System.arraycopy(result[j], 0, arr[j], 0, result[j].length);
			}
		}
		for(int []row:result) {
			for(int c:row) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
	}

}

