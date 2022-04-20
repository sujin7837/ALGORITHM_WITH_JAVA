package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int V, E;
	private static List<Node> list;
	private static int[] parent;

	static class Node implements Comparable<Node> {
		int r, c, weight;

		public Node(int r, int c, int weight) {
			super();
			this.r = r;
			this.c = c;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		list=new ArrayList<>();
		parent=new int[V+1];
		for(int i=1;i<=V;i++) parent[i]=i;
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			list.add(new Node(a, b, w));
		}
		Collections.sort(list);
		
		int answer=0;
		for(int i=0;i<list.size();i++) {
			int a=list.get(i).r;
			int b=list.get(i).c;
			int weight=list.get(i).weight;
			if(findParent(a)!=findParent(b)) {
				answer+=weight;
				union(a, b);
			}
		}
		
		System.out.println(answer);
	}

	private static int findParent(int x) {
		if(x==parent[x]) return x;
		return parent[x]=findParent(parent[x]);
	}
	
	private static void union(int a, int b) {
		int A=findParent(a);
		int B=findParent(b);
		if(A==B) return;
		parent[A]=b; 
	}
}
