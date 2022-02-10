package 순열과조합;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_6603 {

	private static int K;
	private static int[] nums, numbers;
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		while(true) {
			K=sc.nextInt();
			if(K==0) return;
			
			nums=new int[K];
			numbers=new int[6];
			for(int i=0;i<K;i++) {
				nums[i]=sc.nextInt();
			}
			combination(0,0);
			System.out.println();
		}
		
		
	}

	public static void combination(int cnt, int start) {
		if(cnt==6) {
			for(int r:numbers) System.out.print(r+" ");
			System.out.println();
			return;
		}
		for(int i=start;i<K;i++) {
			numbers[cnt]=nums[i];
			combination(cnt+1, i+1);
		}
	}
}
