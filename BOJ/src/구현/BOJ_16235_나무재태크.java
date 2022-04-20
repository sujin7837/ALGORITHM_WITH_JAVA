package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16235_나무재태크 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int N, M, K;
	private static int[][] map, winterMap;
	private static PriorityQueue<Tree> pq;
	private static Queue<Tree> die;
	private static int []dx= {-1,-1,-1,0,0,1,1,1};
	private static int []dy= {-1,0,1,-1,1,-1,0,1};

	static class Tree implements Comparable<Tree> {
		int r, c, age;

		public Tree(int r, int c, int age) {
			super();
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Tree [r=" + r + ", c=" + c + ", age=" + age + "]";
		}

		@Override
		public int compareTo(Tree o) {
			return this.age-o.age;
		}
	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[N+1][N+1];
		winterMap=new int[N+1][N+1];
		pq=new PriorityQueue<>();
		die=new LinkedList<>();
		
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) map[r][c]=5;
		}
		
		for(int r=1;r<=N;r++) {
			st=new StringTokenizer(br.readLine());
			for(int c=1;c<=N;c++) {
				winterMap[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int z=Integer.parseInt(st.nextToken());
			pq.add(new Tree(x, y, z));
		}
		
		for(int i=0;i<K;i++) startYear();
		System.out.println(pq.size());
	}
	
	private static void startYear() {
		spring();
//		System.out.println("1: "+pq);
		summer();
//		System.out.println("2: "+pq);
		fall();
//		System.out.println("3: "+pq);
		winter();
//		System.out.println("4: "+pq);
	}
	
	private static void spring() {
		List<Tree> list=new ArrayList<>();
		int size=pq.size();
		while(size-->0) {
			Tree t=pq.poll();
			if(t.age>map[t.r][t.c]) {
				die.add(new Tree(t.r, t.c, t.age/2));
			} else {
				map[t.r][t.c]-=t.age;
				list.add(new Tree(t.r, t.c, t.age+1));
//				System.out.println(list);
			}
		}
		pq.addAll(list);
//		System.out.println(pq);
	}
	
	private static void summer() {
		int size=die.size();
		while(size-->0) {
			Tree t=die.poll();
			map[t.r][t.c]+=t.age;
		}
	}
	
	private static void fall() {
		List<Tree> list=new ArrayList<>();
		int size=pq.size();
		while(size-->0) {
			Tree t=pq.poll();
			if(t.age>0 && t.age%5==0) {
				for(int d=0;d<8;d++) {
					int nx=t.r+dx[d];
					int ny=t.c+dy[d];
					
					if(isIn(nx, ny)) {
						list.add(new Tree(nx, ny, 1));
					}
				}
			}
			list.add(t);
		}
		pq.addAll(list);
	}
	
	private static void winter() {
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) {
				map[r][c]+=winterMap[r][c];
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r>=1 && r<=N && c>=1 && c<=N;
	}
}
