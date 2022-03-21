package 순열과조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652_N과M4 {
	
	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M;
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		combinationDup(M, new int[M], 1);
	}

	public static void combinationDup(int toChoose, int []choosed, int start) {
		if(toChoose==0) {
			for(int i=0;i<choosed.length;i++) {
				System.out.print(choosed[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<=N;i++) {
			choosed[choosed.length-toChoose]=i;
			combinationDup(toChoose-1, choosed, i);
		}
	}
}
