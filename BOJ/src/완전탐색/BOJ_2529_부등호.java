package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2529_부등호 {

	private static int K;
	private static char [] ch;
	private static StringTokenizer st;
	private static List<String> list=new ArrayList<String>();
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		K=Integer.parseInt(bf.readLine());
		ch=new char[K];
		st=new StringTokenizer(bf.readLine(), " ");
		for(int i=0;i<K;i++) {
			ch[i]=st.nextToken().charAt(0);
		}
		
		// 입력 확인
//		for(char c:ch) System.out.print(c+" ");
//		System.out.println();
		
		permutation(K+1, new int[K+1], new boolean[10]);
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
	}

	public static void permutation(int toChoose, int [] choosed, boolean [] visited) {
		if(toChoose==0) {
			for(int i=0;i<K;i++) {
				int start=choosed[i];
				int second=choosed[i+1];
				if(ch[i]=='<') {
					if(start>second) return;
				}
				if(ch[i]=='>') {
					if(start<second) return;
				}
			}
			String s="";
			for(int r:choosed) {
				if(r==0) s+="0";
				else {
					String tmp=Integer.toString(r);
					s+=tmp;
				}
			}
			list.add(s);
			return;
		}
		
		for(int i=0;i<10;i++) {
			if(!visited[i]) {
				visited[i]=true;
				choosed[choosed.length-toChoose]=i;
				permutation(toChoose-1, choosed, visited);
				visited[i]=false;
			}
		}
	}
}
