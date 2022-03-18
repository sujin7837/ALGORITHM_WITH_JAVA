package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18352_특정거리의도시찾기 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int N, M, K, X, A, B;
	private static ArrayList<Node>[] node;
	private static int [] distance;

	static class Node implements Comparable<Node> {
		int data, dist;

		public Node(int data, int dist) {
			super();
			this.data = data;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", dist=" + dist + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.dist-o.dist;
		}

	}

	public static void main(String[] args) throws IOException {

		bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		node = new ArrayList[N+1];
		distance=new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[X]=0;

		for(int i=0;i<=N;i++) node[i]=new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(bf.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			node[A].add(new Node(B,1));
		}
		
		// 입력 확인
//		System.out.println(Arrays.toString(node));
		
		dijkstra(X);
		int cnt=0;
		for(int i=1;i<=N;i++) {
			if(distance[i]==K) {
				cnt++;
				System.out.println(i);
			}
		}
		if(cnt==0) System.out.println(-1);
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
//			System.out.println(pq);
			Node now=pq.poll();
			int data=now.data;
			int dist=now.dist;
			if(distance[data]<dist) continue;
			for(int i=0;i<node[data].size();i++) {
				int data2=node[data].get(i).data;
				int dist2=node[data].get(i).dist+dist;
				
				if(distance[data2]>dist2) {
					distance[data2]=dist2;
					pq.add(new Node(data2, dist2));
				}
			}
		}
	}
}
