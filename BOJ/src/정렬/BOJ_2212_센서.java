package 정렬;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2212_센서 {

	private static int N, K;
	private static int[] arr;
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		arr=new int[N];
		
		for(int i=0;i<N;i++) arr[i]=sc.nextInt();
		Arrays.sort(arr);
		
		int[] len=new int[N-1];
		for(int i=1;i<N;i++) len[i-1]=arr[i]-arr[i-1];
		Arrays.sort(len);
		
		int result=0;
		for(int i=0;i<N-K;i++) result+=len[i];
		System.out.println(result);
	}

}
