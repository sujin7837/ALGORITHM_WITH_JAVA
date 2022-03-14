package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5525_IOIOI {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M, cnt=0;
	private static char []S;
	private static int []val;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		M=Integer.parseInt(bf.readLine());
		S=new char[M];
		val=new int[M];
		S=bf.readLine().toCharArray();
		
//		System.out.println(Arrays.toString(S));
		
		for(int i=1;i<M-1;i++) {
			if(S[i]=='O' && S[i+1]=='I') val[i+1]=val[i-1]+1;
			if(val[i+1]>=N && S[i+1-2*N]=='I') cnt++;
		}
		
		System.out.println(cnt);
	}

}
