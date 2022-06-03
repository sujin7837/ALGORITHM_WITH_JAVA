package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2138_전구와스위치 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, result=-1;
	private static char[] s1, s2, tmp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		s1=new char[N];
		s2=new char[N];
		tmp=new char[N];
		
		String ss1=br.readLine();
		String ss2=br.readLine();
		for(int i=0;i<N;i++) {
			s1[i]=ss1.charAt(i);
			s2[i]=ss2.charAt(i);
		}
		
		// 0번 안 누름
		int cnt=0;
		for(int i=0;i<N;i++) tmp[i]=s1[i];
		for(int i=1;i<N;i++) {
			if(tmp[i-1]!=s2[i-1]) {
				cnt++;
				toggle(i);
			}
		}
//		System.out.println(cnt);
		if(tmp[N-1]==s2[N-1]) result=cnt;
		
		// 0번 누름
		for(int i=0;i<N;i++) tmp[i]=s1[i];
		toggle(0);
		cnt=1;
		for(int i=1;i<N;i++) {
//			System.out.println(s1[i-1]+" "+s2[i-1]);
			if(tmp[i-1]!=s2[i-1]) {
				cnt++;
				toggle(i);
			}
		}
//		System.out.println(cnt);
//		System.out.println(Arrays.toString(tmp));
		if(tmp[N-1]==s2[N-1]) {
			if(result==-1) result=cnt;
			else result=Math.min(result, cnt);
		}
		System.out.println(result);
	}

	private static void toggle(int idx) {
//		System.out.println("before: "+Arrays.toString(s1));
		for(int i=idx-1;i<=idx+1;i++) {
			if(i>=0 && i<N) {
				if(tmp[i]=='0') tmp[i]='1';
				else tmp[i]='0';
			}
		}
//		System.out.println(idx+" "+Arrays.toString(s1));
	}
	
}
