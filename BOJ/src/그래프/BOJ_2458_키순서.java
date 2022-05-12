package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2458_키순서 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, M;
	private static List<Integer> []smaller;
	private static List<Integer> []bigger;
	private static boolean []visitedS, visitedB;
	private static int []cntS, cntB;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		cntS=new int[N+1];
		cntB=new int[N+1];
		smaller=new ArrayList[N+1];
		bigger=new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			smaller[i]=new ArrayList<>();
			bigger[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			smaller[b].add(a);
			bigger[a].add(b);
		}
		
		for(int i=1;i<=N;i++) {
			visitedS=new boolean[N+1];
			visitedB=new boolean[N+1];
			visitedS[i]=true;
			dfsS(i, i);
			visitedB[i]=true;
			dfsB(i, i);
		}
		
		int cnt=0;
		for(int i=1;i<=N;i++) {
			int get=cntS[i]+cntB[i];
//			System.out.println(cntS[i]+" "+cntB[i]);
//			System.out.println(get);
			if(get>=N-1) cnt++;
		}
		System.out.println(cnt);
	}

	private static void dfsS(int start, int x) {
		if(smaller[x].size()==0) {
			return;
		}
		
		for(int i:smaller[x]) {
			if(!visitedS[i]) {
				visitedS[i]=true;
				cntS[start]++;
				dfsS(start, i);
			}
		}
	}
	
	private static void dfsB(int start, int x) {
		if(bigger[x].size()==0) {
			return;
		}
		
		for(int i:bigger[x]) {
			if(!visitedB[i]) {
				visitedB[i]=true;
				cntB[start]++;
				dfsB(start, i);
			}
		}
	}
}
