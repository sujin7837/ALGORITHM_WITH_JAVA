package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18310_안테나 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N;
	private static long sum=0;
	private static int []houses;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		houses=new int[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			houses[i]=Integer.parseInt(st.nextToken());
			sum+=houses[i];
		}
		Arrays.sort(houses);
		if(N%2==0) System.out.println(houses[N/2-1]);
		else System.out.println(houses[N/2]);
	}

}
