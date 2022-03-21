package 순열과조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654_N과M5 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M;
	private static int [] nums;
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		nums=new int[N];
		
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) nums[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
		permutation(M, new int[M], new boolean[N]);
	}

	public static void permutation(int toChoose, int [] choosed, boolean[] visited) {
		if(toChoose==0) {
			for(int i=0;i<choosed.length;i++) System.out.print(choosed[i]+" ");
			System.out.println();
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				choosed[choosed.length-toChoose]=nums[i];
				permutation(toChoose-1, choosed, visited);
				visited[i]=false;
			}
		}
	}
}
