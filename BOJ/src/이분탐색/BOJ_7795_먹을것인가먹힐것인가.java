package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7795_먹을것인가먹힐것인가 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int T, N, M;
	private static int []A, B;
	public static void main(String[] args) throws NumberFormatException, IOException {
		bf=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(bf.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			A=new int[N];
			B=new int[M];
			
			st=new StringTokenizer(bf.readLine());
			for(int i=0;i<N;i++) A[i]=Integer.parseInt(st.nextToken());
			Arrays.sort(A);
			
			st=new StringTokenizer(bf.readLine());
			for(int i=0;i<M;i++) B[i]=Integer.parseInt(st.nextToken());
			Arrays.sort(B);
			
			int result=0;
			for(int i=0;i<N;i++) {
				int cnt=0;
				int start=0;
				int end=M-1;
				while(start<=end) {
					int mid=(start+end)/2;
					if(A[i]>B[mid]) {
						cnt=mid+1;
//						System.out.println(A[i]+" : "+B[mid]+" : "+cnt);
						start=mid+1;
					} else {
						
//						System.out.println(A[i]+" : "+B[mid]+" : "+cnt);
						end=mid-1;
					}
				}
				result+=cnt;
			}
			
			System.out.println(result);
		}
	}

}
