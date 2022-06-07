package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11501_주식 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int T, N;
	private static long result;
	private static long []days;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N=Integer.parseInt(br.readLine());
			days=new long[N];
			result=0;
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				days[i]=Integer.parseInt(st.nextToken());
			}
			
			Long max=days[N-1];
			for(int i=N-2;i>=0;i--) {
				if(days[i]>max) {
					max=days[i];
				} else if(days[i]<max) result+=max-days[i];
			}
			
			System.out.println(result);
		}
	}

}
