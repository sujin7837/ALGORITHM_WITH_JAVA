package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_4386_별자리만들기 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int N;
	private static Node [] node;
	private static ArrayList<Edge> edges=new ArrayList<>();
	private static int [] parent;

	static class Node {
		double r, c;

		public Node(double r, double c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}
		
	}

	static class Edge implements Comparable<Edge> {
		int start, end;
		double dist;

		public Edge(int start, int end, double dist) {
			super();
			this.start = start;
			this.end = end;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", dist=" + dist + "]";
		}

		@Override
		public int compareTo(Edge o) {
			if(this.dist<o.dist) return -1;
			return 1;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		node = new Node[N];
		parent=new int[N];
		makeSet();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			double r = Double.parseDouble(st.nextToken());
			double c = Double.parseDouble(st.nextToken());
			node[i]=new Node(r, c);
		}
		
		// 입력 확인
//		System.out.println(Arrays.toString(node));
		
		
		
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				double dist=distance(node[i], node[j]);
				edges.add(new Edge(i, j, dist));
			}
		}
		
		// 거리 확인
//		System.out.println(edges);
		
		Collections.sort(edges);
		double result=0;
		for(int i=0;i<edges.size();i++) {
			int start=edges.get(i).start;
			int end=edges.get(i).end;
			double dist=edges.get(i).dist;
			
			if(findParent(start)!=findParent(end)) {
				result+=dist;
				union(start, end);
			}
		}
		System.out.printf("%.2f", result);
	}

	public static void makeSet() {
		for(int i=0;i<N;i++) parent[i]=i;
	}
	
	public static int findParent(int a) {
		if(a==parent[a]) return a;
		return parent[a]=findParent(parent[a]);
	}
	
	public static void union(int a, int b) {
		int aRoot=findParent(a);
		int bRoot=findParent(b);
		
		parent[bRoot]=aRoot;
		return;
	}
	
	public static double distance(Node node1, Node node2) {
		return Math.pow((node1.r-node2.r)*(node1.r-node2.r)+(node1.c-node2.c)*(node1.c-node2.c), 0.5);
	}
}
