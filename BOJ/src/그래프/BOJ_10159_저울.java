package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10159_저울 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, M;
//	private static int []parent;
	private static List<Integer> []lighter;
	private static List<Integer> []heavier;
	private static boolean []visitedL, visitedH;
	private static int []cntL, cntH;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
//		parent=new int[N+1];
//		for(int i=1;i<=N;i++) parent[i]=i;
		lighter=new ArrayList[N+1];
		heavier=new ArrayList[N+1];
		cntL=new int[N+1];
		cntH=new int[N+1];
		
		for(int i=1;i<=N;i++) {
			lighter[i]=new ArrayList<>();
			heavier[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			lighter[a].add(b);
			heavier[b].add(a);
		}
		
		for(int i=1;i<=N;i++) {
			visitedL=new boolean[N+1];
			visitedL[i]=true;
			dfsL(i, i);
			visitedH=new boolean[N+1];
			visitedH[i]=true;
			dfsH(i, i);
		}
		
		for(int i=1;i<=N;i++) System.out.println(N-(cntL[i]+cntH[i])-1);
	}

	private static void dfsL(int start, int x) {
		if(lighter[x].size()==0) return;
		for(int i:lighter[x]) {
			if(!visitedL[i]) {
				visitedL[i]=true;
				cntL[start]++;
				dfsL(start, i);
			}
		}
	}
	private static void dfsH(int start, int x) {
		if(heavier[x].size()==0) return;
		for(int i:heavier[x]) {
			if(!visitedH[i]) {
				visitedH[i]=true;
				cntH[start]++;
				dfsH(start, i);
			}
		}
	}
}
