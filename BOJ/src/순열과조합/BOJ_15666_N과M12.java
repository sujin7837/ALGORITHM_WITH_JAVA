package 순열과조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_15666_N과M12 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, M;
	private static int[] nums, newNums;
	private static Set<Integer> set;
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		nums=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) nums[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
		set=new LinkedHashSet<>();
		for(int i=0;i<N;i++) set.add(nums[i]);
		newNums=new int[set.size()];
		Iterator<Integer> it=set.iterator();
		for(int i=0;i<set.size();i++) newNums[i]=it.next();
//		System.out.println(Arrays.toString(newNums));
		combination(M, new int[M], 0);
	}

	private static void combination(int toChoose, int []choosed, int start) {
		if(toChoose==0) {
			for(int i=0;i<choosed.length;i++) {
				System.out.print(choosed[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<newNums.length;i++) {
			choosed[choosed.length-toChoose]=newNums[i];
			combination(toChoose-1, choosed, i);
		}
	}
}
