package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1162_도로포장 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M, K;
	private static ArrayList<Node> [] nodes;
	private static long [][] distance;
	private static long result=Long.MAX_VALUE;
	
	static class Node implements Comparable<Node> {
		int val, cnt;
		long weight;

		public Node(int val, long weight, int cnt) {
			super();
			this.val = val;
			this.weight = weight;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [val=" + val + ", weight=" + weight + ", cnt=" + cnt + "]";
		}

		@Override
		public int compareTo(Node o) {
			if(this.weight<o.weight) return -1;
			else if(this.weight==o.weight) return 0;
			else return 1;
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		nodes=new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			nodes[i]=new ArrayList<>();
		}
		
		distance=new long[N+1][K+1];
		for(int i=1;i<=N;i++) {
			Arrays.fill(distance[i], Long.MAX_VALUE);
		}
		distance[1][0]=0;
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(bf.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			nodes[start].add(new Node(end, weight, 0));
			nodes[end].add(new Node(start, weight, 0));
		}
		dijkstra();
		
		for(int i=0;i<=K;i++) {
			result=Math.min(result, distance[N][i]);
		}
		System.out.println(result);
	}

	public static void dijkstra() {
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.add(new Node(1, 0, 0));
		
//		for(long []r:distance) {
//			for(long c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		while(!pq.isEmpty()) {
			Node now=pq.poll();
			int val=now.val;
			long weight=now.weight;
			int cnt=now.cnt;
			
			if(distance[val][cnt]<weight) continue;
			for(int i=0;i<nodes[val].size();i++) {
				int val2=nodes[val].get(i).val;
				long weight2=nodes[val].get(i).weight+weight;
				
				// 도로 포장을 안 했을 때
				if(distance[val2][cnt]>weight2) {
					distance[val2][cnt]=weight2;
					pq.add(new Node(val2, weight2, cnt));
				}
				
				// 도로 포장을 했을 때
				if(cnt+1<=K && distance[val2][cnt+1]>weight) {
					distance[val2][cnt+1]=weight;
					pq.add(new Node(val2, weight, cnt+1));
				}
			}
		}
		
	}
}
