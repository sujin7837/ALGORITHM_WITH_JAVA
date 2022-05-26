package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1448_삼각형만들기 {

	private static BufferedReader br;
	
	private static int N, result;
	private static Integer []nums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		nums=new Integer[N];
		for(int i=0;i<N;i++) nums[i]=Integer.parseInt(br.readLine());
		Arrays.sort(nums, Collections.reverseOrder());
		result=-1;
		for(int i=0;i<N;i++) {
			if(i+2==N) break;
			if(nums[i]<nums[i+1]+nums[i+2]) {
				result=nums[i]+nums[i+1]+nums[i+2];
				break;
			}
		}
		System.out.println(result);
	}

}
