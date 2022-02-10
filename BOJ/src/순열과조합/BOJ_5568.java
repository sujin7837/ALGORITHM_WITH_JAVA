package 순열과조합;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_5568 {

	private static int N, K;
	private static int[] input, numbers;
	private static boolean[] isSelected;
	private static List<String> result=new ArrayList<>();
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		
		input = new int[N];
		numbers = new int[K];
		isSelected = new boolean[N];
		
		for(int i=0;i<N;i++) {
			input[i]=sc.nextInt();
		}
		
		permutation(0);
		System.out.println(result.size());
	}

	public static void permutation(int cnt) {
		if(cnt==K) {
			String s="";
			for(int r:numbers) {
				s+=Integer.toString(r);
			}
			if(!(result.contains(s))) result.add(s);
			return;
		}
		for(int i=0;i<N;i++) {
			if(isSelected[i]) continue;
			numbers[cnt]=input[i];
			isSelected[i]=true;
			permutation(cnt+1);
			isSelected[i]=false;
		}
	}
}
