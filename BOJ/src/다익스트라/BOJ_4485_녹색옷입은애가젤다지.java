package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int N;
	private static int[][] map;
	private static int[][] distance;
	private static int []dx= {-1,1,0,0};
	private static int []dy= {0,0,-1,1};

	static class Node implements Comparable<Node> {
		int r, c, cost;

		public Node(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		int idx=0;
		while(true) {
			idx++;
			N=Integer.parseInt(bf.readLine());
			if(N==0) break;
			map=new int[N][N];
			distance=new int[N][N];
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) distance[r][c]=Integer.MAX_VALUE;
			}
			
			for(int r=0;r<N;r++) {
				st=new StringTokenizer(bf.readLine());
				for(int c=0;c<N;c++) {
					map[r][c]=Integer.parseInt(st.nextToken());
				}
			}
			
			// 입력 확인
//			for(int []r:map) {
//				for(int c:r) System.out.print(c+" ");
//				System.out.println();
//			}
			
			dijkstra();
			System.out.println("Problem "+idx+": "+distance[N-1][N-1]);
		}
	}

	public static void dijkstra() {
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.add(new Node(0,0, map[0][0]));
		distance[0][0]=map[0][0];
		
		while(!pq.isEmpty()) {
			Node now=pq.poll();
			int r=now.r;
			int c=now.c;
			int cost=now.cost;
			
			for(int i=0;i<4;i++) {
				int R=r+dx[i];
				int C=c+dy[i];
				
				if(isIn(R, C)) {
					if(distance[R][C]<cost) continue;
					int cost2=map[R][C]+cost;
					if(distance[R][C]>cost2) {
						distance[R][C]=cost2;
						pq.add(new Node(R, C, cost2));
					}
				}
			}
		}
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
