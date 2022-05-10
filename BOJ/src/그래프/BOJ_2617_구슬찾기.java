package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2617_구슬찾기 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, M, num, result=0;
	private static int []cntL, cntH;
	private static boolean []visitedL, visitedH;
	private static List<Integer> []light, heavy;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		num=N/2;
		light=new ArrayList[N+1];
		for(int i=1;i<=N;i++) light[i]=new ArrayList<>();
		heavy=new ArrayList[N+1];
		for(int i=1;i<=N;i++) heavy[i]=new ArrayList<>();
		cntL=new int[N+1];
		cntH=new int[N+1];
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			if(!light[a].contains(b)) light[a].add(b);
			if(!heavy[b].contains(a)) heavy[b].add(a);
		}
//		System.out.println(Arrays.toString(light));
//		System.out.println(Arrays.toString(heavy));
		for(int i=1;i<=N;i++) {
			visitedL=new boolean[N+1];
//			visitedL[i]=true;
			dfsL(i, i);
			
			visitedH=new boolean[N+1];
//			visitedH[i]=true;
			dfsH(i, i);
//			System.out.println(i+" "+result);
		}
		System.out.println(Arrays.toString(cntL));
		System.out.println(Arrays.toString(cntH));
		for(int i=1;i<=N;i++) {
			if(cntL[i]>num) result++;
			if(cntH[i]>num) result++;
		}
		System.out.println(result);
	}

	private static void dfsL(int start, int x) {
//		if(light[x].size()==0) return;
		visitedL[x]=true;
		for(int i:light[x]) {
			if(!visitedL[i]) {
//				visitedL[i]=true;
				cntL[start]++;
//				System.out.println(i+" "+cnt+" "+light[i].size());
				dfsL(start, i);
			}
		}
	}
	
	private static void dfsH(int start, int x) {
//		if(heavy[x].size()==0) return;
		visitedH[x]=true;
		for(int i:heavy[x]) {
			if(!visitedH[i]) {
//				visitedH[i]=true;
				cntH[start]++;
//				System.out.println(i+" "+cnt+" "+light[i].size());
				dfsH(start, i);
			}
		}
	}
}
