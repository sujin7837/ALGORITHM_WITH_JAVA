package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1005_ACMCraft {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int T, N, K, W, result=0;
	private static int []times, dp, indegree;
	private static ArrayList<Integer> []list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		bf=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;t++) {
			result=0;
			st=new StringTokenizer(bf.readLine());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			times=new int[N+1];
			list=new ArrayList[N+1];
			for(int i=1;i<=N;i++) list[i]=new ArrayList<>();
			dp=new int[N+1];
			indegree=new int[N+1];
			
			st=new StringTokenizer(bf.readLine());
			for(int i=1;i<=N;i++) times[i]=Integer.parseInt(st.nextToken());
			for(int i=0;i<K;i++) {
				st=new StringTokenizer(bf.readLine());
				int from=Integer.parseInt(st.nextToken());
				int to=Integer.parseInt(st.nextToken());
				list[from].add(to);
				indegree[to]++;
			}
			W=Integer.parseInt(bf.readLine());
			
			dp();
//			System.out.println(Arrays.toString(dp));
			System.out.println(dp[W]);
		}
	}

	public static void dp() {
		Queue<Integer> queue=new LinkedList<>();
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) {
				dp[i]=times[i];
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int q=queue.poll();
			for(int i=0;i<list[q].size();i++) {
				int next=list[q].get(i);
				dp[next]=Math.max(dp[next], dp[q]+times[next]);
				indegree[next]--;
				if(indegree[next]==0) queue.offer(next);
			}
		}
		
	}
}
