package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1138_한줄로서기 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N;
	private static int []cnts, result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		cnts=new int[N];
		result=new int[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			cnts[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			int cnt=0, idx=0;
			while(cnt<cnts[i] || result[idx]!=0) {
				if(result[idx++]==0) cnt++;
			}
			result[idx]=i+1;
		}
		
		for(int i=0;i<N;i++) System.out.print(result[i]+" ");
	}

}
