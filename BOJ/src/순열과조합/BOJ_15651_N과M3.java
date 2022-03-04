package 순열과조합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15651_N과M3 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	private static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int N, M;

	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		permutationDup(M, new int[M]);
		
		bw.flush();
	}

	public static void permutationDup(int toChoose, int [] choosed) throws IOException {
		if(toChoose==0) {
			for(int i=0;i<M;i++) bw.write(String.valueOf(choosed[i])+" ");
			bw.newLine();
			return;
		}
		for(int i=1;i<=N;i++) {
			choosed[choosed.length-toChoose]=i;
			permutationDup(toChoose-1, choosed);
		}
	}
}
