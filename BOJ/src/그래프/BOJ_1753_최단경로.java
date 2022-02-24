package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int V, E, K, u, v, w;
	private static ArrayList [] adjList;
	private static int[] distance;

	static class Node implements Comparable<Node> {
		int val, dist;


		public Node(int val, int dist) {
			super();
			this.val = val;
			this.dist = dist;
		}
		
		@Override
		public String toString() {
			return "Node [val=" + val + ", dist=" + dist + "]";
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.dist, o.dist);
		}

	}

	public static void main(String[] args) throws IOException {

		bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bf.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(bf.readLine());
		distance = new int[V + 1];
		
		adjList = new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			adjList[i]=new ArrayList<Node>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			adjList[u].add(new Node(v,w));
		}
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;

		// 입력 확인
//		for(ArrayList n:adjList) System.out.println(n);
		
		dijkstra(K);
		for (int i = 1; i <= V; i++) {
			if (distance[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node node = pq.poll();

			for(int i=0;i<adjList[node.val].size();i++) {
				Node next=(Node) adjList[node.val].get(i);
				if(next.dist!=0 && distance[next.val]>distance[node.val]+next.dist) {
					distance[next.val]=distance[node.val]+next.dist;
					pq.add(new Node(next.val, distance[next.val]));
				}
			}
		}
	}
}
