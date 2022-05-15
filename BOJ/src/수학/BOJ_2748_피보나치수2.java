package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2748_피보나치수2 {

	private static BufferedReader br;
	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		long p0=0, p1=1;
		long result=0;
		for(int i=2;i<=N;i++) {
			result=p0+p1;
			p0=p1;
			p1=result;
		}
		
		if(N<2) System.out.println(1);
		else System.out.println(result);
	}

}
