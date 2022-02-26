package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559_수열 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, K;
	private static int [] arr;
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		arr=new int[N];
		
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
		
		System.out.println(Sum(K));
	}

	public static int Sum(int k) {
		int sum=Integer.MIN_VALUE;
		for(int i=0;i<=N-k;i++) {
			int tmp=0;
			for(int j=i;j<i+k;j++) {
				tmp+=arr[j];
			}
			sum=Math.max(sum, tmp);
		}
		return sum;
	}
}
