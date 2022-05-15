package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2749_피보나치수3 {

	private static BufferedReader br;
	private static long N;
	private static long []arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Long.parseLong(br.readLine());
		
		int mod=(int) (15*Math.pow(10, 5));
		arr=new long[mod+1];
		arr[0]=0;
		arr[1]=1;
		for(int i=2;i<mod;i++) {
			arr[i]=(arr[i-2]+arr[i-1])%1000000;
		}
		
		if(N>=mod) N%=mod;
		
		System.out.println(arr[(int) N]);
	}

}
