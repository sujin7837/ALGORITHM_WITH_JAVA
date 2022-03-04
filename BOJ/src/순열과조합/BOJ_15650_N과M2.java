package 순열과조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650_N과M2 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M;
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		combination(M, new int[M], 1);
	}

	public static void combination(int toChoose, int [] choosed, int start) {
		if(toChoose==0) {
			for(int i=0;i<M;i++) System.out.print(choosed[i]+" ");
			System.out.println();
			return;
		}
		for(int i=start;i<=N;i++) {
			choosed[choosed.length-toChoose]=i;
			combination(toChoose-1, choosed, i+1);
		}
	}
}
