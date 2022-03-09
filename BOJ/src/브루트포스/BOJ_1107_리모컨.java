package 브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M;
	private static boolean [] cannotUse;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		M=Integer.parseInt(bf.readLine());
		cannotUse=new boolean[10];
		if(M>0) {
			st=new StringTokenizer(bf.readLine());
			for(int i=0;i<M;i++) {
				int a=Integer.parseInt(st.nextToken());
				cannotUse[a]=true;
			}
		}
			
			// 입력 확인
//			System.out.println(Arrays.toString(cannotUse));
//			System.out.println(Arrays.toString(Nch));
//			System.out.println(Nch[1]);
			


		int minVal=Math.abs(N-100);
		for(int i=0;i<=1000000;i++) {
			int len=findLen(i);
			if(len>0) {
				minVal=Math.min(len+Math.abs(N-i), minVal);
			}
		}
			
		System.out.println(minVal);
			
	}

	public static int findLen(int n) {
		if(n==0) {
			if(cannotUse[0]) return 0;
			else return 1;
		}
		int cnt=0;
		while(n>0) {
			if(cannotUse[n%10]) return 0;
			cnt++;
			n/=10;
		}
		return cnt;
	}
	
	
}
