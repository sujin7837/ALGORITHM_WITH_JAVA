package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18405_경쟁적전염 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, K, S, X, Y;
	private static int [][] map;
	private static Virus virus;
	private static PriorityQueue<Virus> queue=new PriorityQueue<>();
	private static int [] dx = {-1,1,0,0};
	private static int [] dy = {0,0,-1,1};
	
	static class Virus implements Comparable<Virus> {
		int r, c, num;

		public Virus(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Virus [r=" + r + ", c=" + c + ", num=" + num + "]";
		}

		@Override
		public int compareTo(Virus o) {
			return Integer.compare(this.num, o.num);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[N+1][N+1];
		
		for(int r=1;r<=N;r++) {
			st=new StringTokenizer(bf.readLine());
			for(int c=1;c<=N;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
				if(map[r][c]>0) {
					queue.add(new Virus(r, c, map[r][c]));
				}
			}
		}
		st=new StringTokenizer(bf.readLine());
		S=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		Y=Integer.parseInt(st.nextToken());
		
		// 입력 확인
//		for(int []r:map) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
//		
//		while(!queue.isEmpty()) {
//			System.out.println(queue.poll());
//		}
		
		bfs();
		StringBuilder sb=new StringBuilder();
		sb.append(map[X][Y]);
		System.out.println(sb);
	}

	public static void bfs() {
		List<Virus> list=new ArrayList<>();
		for(int s=0;s<S;s++) {
			int size=queue.size();
			
			while(size-->0) {
				Virus v=queue.poll();
				
				for(int i=0;i<4;i++) {
					int nx=v.r+dx[i];
					int ny=v.c+dy[i];
					
					if(isIn(nx, ny) && map[nx][ny]==0) {
						map[nx][ny]=map[v.r][v.c];
						list.add(new Virus(nx, ny, map[nx][ny]));
					}
				}
			}
			queue.addAll(list);
			if(map[X][Y]!=0) return;
//			for(int []r:map) {
//				for(int c:r) System.out.print(c+" ");
//				System.out.println();
//			}
//			System.out.println();
		}
	}
	
	public static boolean isIn(int r, int c) {
		return r>=1 && r<=N && c>=1 && c<=N;
	}
}
