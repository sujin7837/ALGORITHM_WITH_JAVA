package swea.d2;

import java.util.Scanner;

public class SWEA_D2_1954_달팽이숫자 {

	private static int T, N;
	private static int dx[] = {0, 1, 0, -1};
	private static int dy[] = {1, 0, -1, 0};
	private static int arr[][];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		
		for(int t=0;t<T;t++) {
			N=sc.nextInt();
			arr=new int[N][N];
			int lastNum=N*N;
			int now=1;
			int idx=0;
			int startX=0;
			int startY=0;
			int startJ=N-1;
			arr[0][0]=now++;
			
			while(now<=lastNum) {
				if(startX+dx[idx]<0 || startX+dx[idx]>=N || startY+dy[idx]<0 || startY+dy[idx]>=N) {
					idx++;
					if(idx==4) idx=0;
					continue;
				}
				if(arr[startX+dx[idx]][startY+dy[idx]]!=0) {
					idx++;
					if(idx==4) idx=0;
					continue;
				}
				startX+=dx[idx];
				startY+=dy[idx];
				arr[startX][startY]=now++;
			}
			
			
			System.out.printf("#%d\n", t+1);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
