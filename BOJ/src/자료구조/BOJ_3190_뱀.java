package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_3190_뱀 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int N, K, L;
	private static int[][] board;
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { 1, 0, -1, 0 };
	private static int[] X;
	private static String[] C;

	static class Node {
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		board = new int[N + 1][N + 1];

		K = Integer.parseInt(bf.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			board[R][C] = 1;
		}

		L = Integer.parseInt(bf.readLine());
		X = new int[L];
		C = new String[L];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(bf.readLine());
			X[i] = Integer.parseInt(st.nextToken());
			C[i] = st.nextToken();
		}

		int result=game();
		System.out.println(result);
	}

	public static int game() {
		Deque<Node> deque=new LinkedList<>();
		deque.add(new Node(1,1));
		
		boolean [][]visited=new boolean[N+1][N+1];
		visited[1][1]=true;
		
		int gameR=1, gameC=1;
		int dir=0;
		int second=0;
		for(int i=0;i<L;i++) {
			Node node=deque.peekFirst();
			int x=X[i];
			String c=C[i];
			int nx=node.r;
			int ny=node.c;
			
			for(int j=second;j<x;j++) {
				nx+=dx[dir];
				ny+=dy[dir];
//				System.out.println(nx+" "+ny);
				
				second++;
				if(!isIn(nx, ny)) return second;
				if(visited[nx][ny]) return second;
				deque.addFirst(new Node(nx, ny));
				visited[nx][ny]=true;
				if(board[nx][ny]==0) {
					Node poll=deque.pollLast();
					visited[poll.r][poll.c]=false;
				} else board[nx][ny]=0;
			}
			if(c.equals("L")) {
				dir--;
				if(dir<0) dir=3;
			} else if(c.equals("D")) {
				dir++;
				if(dir>3) dir=0;
			}
			gameR=nx;
			gameC=ny;
		}
		
		while(isIn(gameR, gameC)) {
			gameR+=dx[dir];
			gameC+=dy[dir];
			
			second++;
			if(!isIn(gameR, gameC)) return second;
			if(visited[gameR][gameC]) return second;
			deque.addFirst(new Node(gameR, gameC));
			if(board[gameR][gameC]==0) {
				Node poll=deque.pollLast();
				visited[poll.r][poll.c]=false;
			} else board[gameR][gameC]=0;
		}
		return second;
	}
	
	public static boolean isIn(int r, int c) {
		return r>=1 && r<=N && c>=1 && c<=N;
	}
}
