package 정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_1174_줄어드는수 {

	private static int N;
	private static int[] num= {9,8,7,6,5,4,3,2,1,0};
	private static List<Long> numbers=new ArrayList<Long>();
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		
		if(N>1023) System.out.println(-1);
		else {
			combination(0,0);
			Collections.sort(numbers);
			System.out.println(numbers.get(N-1));
		}
		
	}

	public static void combination(int idx, long sum) {
		
		if(!numbers.contains(sum)) numbers.add(sum);
		if(idx==10) return;

		combination(idx+1, sum*10+num[idx]);
		combination(idx+1, sum);
	}
}
