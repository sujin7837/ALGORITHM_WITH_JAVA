package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17837_새로운게임2 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int N, K;
	private static int[][] board;
	private static Deque<Integer> [][]queue;
	private static int[] dx = { 0, 0, 0, -1, 1 };
	private static int[] dy = { 0, 1, -1, 0, 0 };
	private static Horse []horses;

	static class Horse {
		int r, c, dir;
//		Queue<Horse> queue;

		public Horse(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
//			this.queue = queue;
		}

		@Override
		public String toString() {
			return "Horse [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		horses=new Horse[K+1];
		queue=new LinkedList[N+1][N+1];
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) {
				queue[r][c]=new LinkedList<>();
			}
		}

		board = new int[N+1][N+1];
		for(int r=1;r<=N;r++) {
			st=new StringTokenizer(br.readLine());
			for(int c=1;c<=N;c++) {
				board[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<=K;i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int dir=Integer.parseInt(st.nextToken());
			horses[i]=new Horse(r, c, dir);
			queue[r][c].add(i);
		}
		

		
		System.out.println(startGame());
	}

	private static int startGame() {
		int cnt=0;
		while(cnt<1000) {
			cnt++;
			for(int i=1;i<=K;i++) {
				int r=horses[i].r;
				int c=horses[i].c;
				
				Deque<Integer> q=new LinkedList<>();
				q.addAll(queue[r][c]);
				queue[r][c].clear();
				List<Integer> tmp=new ArrayList<>();
				int get;
//				System.out.println("i: "+i+" Q: "+q);
				while(q.peek()!=i) {
					get=q.poll();
					tmp.add(get);
				}
				queue[r][c].addAll(tmp);
				move(i, q);
				for(int j=1;j<=K;j++) {
					if(queue[horses[j].r][horses[j].c].size()>=4) return cnt;
				}
//				print();
			}
			print();
		}
		
		return -1;
	}
	private static void print() {
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) System.out.print(queue[r][c]);
			System.out.println();
		}
		System.out.println();
		
//		for(Horse h:horses) System.out.println(h);
	}
	
	private static void move(int x, Deque<Integer> q) {
		int r=horses[x].r;
		int c=horses[x].c;
		int dir=horses[x].dir;
		int nx=r+dx[dir];
		int ny=c+dy[dir];
		
		if(!isIn(nx, ny)) {	// 범위를 벗어남
			horses[x].dir=change(dir);
			dir=horses[x].dir;
//			System.out.println("dir: "+horses[x].dir);
			nx=r+dx[dir];
			ny=c+dy[dir];
			if(board[nx][ny]==2) {
//				System.out.println("dir?: "+horses[x].dir);
				queue[r][c].addAll(q);
				return;
			}
			else move(x, q);
		} else {
			int color=board[nx][ny];
					
			if(color==0) {	// 흰
				while(!q.isEmpty()) {
					int get=q.poll();
//					System.out.println("get: "+get+" queue: "+queue[nx][ny]);
					queue[nx][ny].add(get);
					horses[get]=new Horse(nx, ny, horses[get].dir);
				}
			} else if(color==1) {	// 빨
				while(!q.isEmpty()) {
					int get=q.pollLast();
					queue[nx][ny].add(get);
					horses[get]=new Horse(nx, ny, horses[get].dir);
//					System.out.println("red: "+horses[get]);
				}
			} else if(color==2) {	// 파
				horses[x].dir=change(dir);
				dir=horses[x].dir;
				nx=r+dx[dir];
				ny=c+dy[dir];
				if(!isIn(nx, ny)) {
					queue[r][c].addAll(q);
					return;
				}
				else if(board[nx][ny]==2) {
					queue[r][c].addAll(q);
					return;
				}
				else move(x, q);
			}
		}
	}
	
	private static int change(int dir) {
		if(dir==1) return 2;
		else if(dir==2) return 1;
		else if(dir==3) return 4;
		else return 3;
	}
	private static boolean isIn(int r, int c) {
		return r>=1 && r<=N && c>=1 && c<=N;
	}
}
