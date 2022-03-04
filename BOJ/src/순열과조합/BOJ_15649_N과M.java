package 순열과조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15649_N과M {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M;
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		permutation(M, new int[M], new boolean[N+1]);
	}

	public static void permutation(int toChoose, int [] choosed, boolean [] visited) {
		if(toChoose==0) {
			for(int i=0;i<M;i++) System.out.print(choosed[i]+" ");
			System.out.println();
			return;
		}
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				choosed[choosed.length-toChoose]=i;
				permutation(toChoose-1, choosed, visited);
				visited[i]=false;
			}
		}
	}
}
