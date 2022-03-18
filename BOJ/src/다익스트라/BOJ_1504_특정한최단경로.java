package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504_특정한최단경로 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, E, A, B;
	private static boolean cannot;
	private static ArrayList<Node> [] node;
	private static int [] dist;
	
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
		E=Integer.parseInt(st.nextToken());
		node=new ArrayList[N+1];
		for(int i=1;i<=N;i++) node[i]=new ArrayList<>();
		
		dist=new int[N+1];
		
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(bf.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			node[start].add(new Node(end, cost));
			node[end].add(new Node(start,cost));
		}
		
		st=new StringTokenizer(bf.readLine());
		A=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		
		// 입력 확인
//		System.out.println(Arrays.toString(node));
		
		int []l1= {1,A,B,N};
		int []l2= {1,B,A,N};
		cannot=false;
		int result1=0;
		for(int i=0;i<3;i++) {
			if(l1[i]==l1[i+1]) continue;
			if(cannot) {
				result1=Integer.MAX_VALUE;
				break;
			}
			result1+=dijkstra(l1[i],l1[i+1]);
		}
		cannot=false;
		int result2=0;
		for(int i=0;i<3;i++) {
			if(l2[i]==l2[i+1]) continue;
			if(cannot) {
				result2=Integer.MAX_VALUE;
				break;
			}
			result2+=dijkstra(l2[i],l2[i+1]);
		}
		int result=Math.min(result1, result2);
		if(result==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
		System.out.println(dijkstra(1,1)+" : "+dijkstra(N,N));
	}

	public static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.add(new Node(start,0));
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1]=0;
		
		while(!pq.isEmpty()) {
			Node now=pq.poll();
			int val=now.val;
			int cost=now.cost;
			if(dist[val]<cost) continue;
			
			for(int i=0;i<node[val].size();i++) {
				int val2=node[val].get(i).val;
				int cost2=node[val].get(i).cost+cost;
				if(dist[val2]>cost2) {
					dist[val2]=cost2;
					pq.add(new Node(val2, cost2));
				}
			}
		}
//		System.out.println(Arrays.toString(dist));
		if(dist[end]==Integer.MAX_VALUE) cannot=true;
		return dist[end];
	}
}
