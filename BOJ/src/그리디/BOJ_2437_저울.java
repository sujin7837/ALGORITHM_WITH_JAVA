package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2437_저울 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N;
	private static int[] nums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		nums=new int[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) nums[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
		
		int sum=1;
		for(int i=0;i<N;i++) {
			if(nums[i]<=sum) {
				sum+=nums[i];
			} else {
				break;
			}
		}
		
		System.out.println(sum);
	}

}
