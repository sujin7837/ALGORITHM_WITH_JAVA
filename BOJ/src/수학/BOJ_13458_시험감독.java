package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458_시험감독 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, B, C;
	private static long cnt=0;
	private static int []A;
	
	public static void main(String[] args) throws IOException {
		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		A=new int[N];
		
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(bf.readLine());
		B=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			A[i]-=B;
			cnt++;	// 총감독관
			if(A[i]<=0) continue;
			cnt+=A[i]/C;	// 부감독관
			if(A[i]%C>0) cnt+=1;
		}
		
		System.out.println(cnt);
	}

}
