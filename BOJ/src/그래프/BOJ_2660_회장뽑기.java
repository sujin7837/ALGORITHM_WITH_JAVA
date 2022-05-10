package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2660_회장뽑기 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N;
	private static int []num;
	private static List<Integer> []list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		num=new int[N+1];
		list=new ArrayList[N+1];
		for(int i=1;i<=N;i++) list[i]=new ArrayList<>();
		
		st=new StringTokenizer(br.readLine());
		 while(st.hasMoreTokens()) {
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			if(a==-1 && b==-1) break;
			if(!list[a].contains(b)) list[a].add(b);
			if(!list[b].contains(a)) list[b].add(a);
			st=new StringTokenizer(br.readLine());
		}
		int min=Integer.MAX_VALUE;
		List<Integer> idx=new ArrayList<>();
		for(int i=1;i<=N;i++) {
			num[i]=bfs(i);
//			System.out.println(num[i]);
			min=Math.min(min, num[i]);
		}
		int cnt=0;
		for(int i=1;i<=N;i++) {
			if(num[i]==min) {
				cnt++;
				idx.add(i);
			}
		}
		System.out.println(min+" "+cnt);
		for(int x:idx) System.out.print(x+" ");
	}

	private static int bfs(int x) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(x);
		
		boolean []visited=new boolean[N+1];
		visited[x]=true;
		
		int depth=-1;
		while(!queue.isEmpty()) {
			int size=queue.size();
			while(size-->0) {
				int q=queue.poll();
				
				for(int i:list[q]) {
					if(!visited[i]) {
						visited[i]=true;
						queue.add(i);
					}
				}
			}
			depth++;
		}
		return depth;
	}
}
