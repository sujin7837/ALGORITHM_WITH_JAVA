package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9663_NQueen {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, cnt=0;
	private static int []choosed;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		choosed=new int[N+1];
		
		nQueen(1);
		System.out.println(cnt);
	}

	private static void nQueen(int r) {
		if(r>N) {
			cnt++;
			return;
		}
		
		for(int i=1;i<=N;i++) {
			choosed[r]=i;
			if(check(r)) nQueen(r+1);
		}
	}
	
	private static boolean check(int r) {
		for(int i=1;i<r;i++) {
			if(choosed[i]==choosed[r]) return false;
			if(Math.abs(choosed[r]-choosed[i])==Math.abs(r-i)) return false;
		}
		return true;
	}
}
