package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238_파티 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M, X;
	private static ArrayList<Node> [] node;
	private static int [] distance;
	
	static class Node implements Comparable<Node> {
		int val, cost;

		public Node(int val, int cost) {
			super();
			this.val = val;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [val=" + val + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		
		node=new ArrayList[M+1];
		for(int i=1;i<=M;i++) {
			node[i]=new ArrayList<>();
		}
		
		distance=new int[N+1];
		
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(bf.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			node[start].add(new Node(end, cost));
		}
		
		// 입력 확인
//		System.out.println(Arrays.toString(node));
		int maxVal=Integer.MIN_VALUE;
		for(int i=1;i<=N;i++) {
			int result=dijkstra(i, X)+dijkstra(X, i);
			maxVal=Math.max(result, maxVal);
		}
		
		System.out.println(maxVal);
	}

	public static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		for(int i=1;i<=N;i++) distance[i]=Integer.MAX_VALUE;
		distance[start]=0;
		
		while(!pq.isEmpty()) {
			Node now=pq.poll();
//			System.out.println(now);
			int val=now.val;
			int cost=now.cost;
			
			if(distance[val]<cost) continue;
			for(int i=0;i<node[val].size();i++) {
				int val2=node[val].get(i).val;
				int cost2=node[val].get(i).cost+cost;
				if(distance[val2]>cost2) {
					distance[val2]=cost2;
					pq.add(new Node(val2, cost2));
				}
			}
		}
//		for(int i=1;i<=M;i++) System.out.print(distance[i]+" ");
//		System.out.println(distance[end]);
		return distance[end];
	}
}
