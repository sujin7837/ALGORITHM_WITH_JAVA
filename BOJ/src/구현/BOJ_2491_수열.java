package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2491_수열 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N;
	private static int [] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		arr=new int[N];
		
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
		
		int maxVal=1, len=1;
		for(int i=1;i<N;i++) {
			if(arr[i-1]<=arr[i]) len++;
			else len=1;
			maxVal=Math.max(maxVal, len);
		}
		
		len=1;
		for(int i=1;i<N;i++) {
			if(arr[i-1]>=arr[i]) len++;
			else len=1;
			maxVal=Math.max(maxVal, len);
		}
		
		System.out.println(maxVal);
	}

}
