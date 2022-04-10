package 순열과조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_15663_N과M9 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M;
	private static int []nums;
	private static Set<String> set;
	public static void main(String[] args) throws IOException {
		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		nums=new int[N];
		
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) nums[i]=Integer.parseInt(st.nextToken());
		
		Arrays.sort(nums);
		set=new LinkedHashSet<>();
		permutation(M, new int[M], new boolean[N]);
		for(String r:set) {
			System.out.println(r);
		}
	}

	private static void permutation(int toChoose, int [] choosed, boolean[] visited) {
		if(toChoose==0) {
			String s="";
			for(int i=0;i<choosed.length;i++) {
				if(i==choosed.length-1) s+=choosed[i];
				else s+=choosed[i]+" ";
			}
			
			set.add(s);
//			System.out.println(set);
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
