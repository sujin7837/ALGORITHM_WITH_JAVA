package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17141_연구소2 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int N, M, min;
	private static int[][] map;
	private static List<Virus> viruses = new ArrayList<>();
	private static int []dx= {-1,1,0,0};
	private static int []dy= {0,0,-1,1};

	static class Virus {
		int r, c;

		public Virus(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Virus [r=" + r + ", c=" + c + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==2) viruses.add(new Virus(r, c));
			}
		}

		min=Integer.MAX_VALUE;
		combination(M, new int[M], 0);
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}

	private static void combination(int toCheck, int []checked, int start) {
		if(toCheck==0) {
//			System.out.println(Arrays.toString(checked));
			int result=bfs(checked);
			if(result==-1) return;
			min=Math.min(min, result);
			return;
		}
		for(int i=start;i<viruses.size();i++) {
			checked[checked.length-toCheck]=i;
			combination(toCheck-1, checked, i+1);
		}
	}
	
	private static int bfs(int []checked) {
		Queue<Virus> queue=new LinkedList<>();
		int [][]newMap=new int[N][N];
		copyMap(map, newMap);
		
		for(int i=0;i<M;i++) {
			Virus virus=viruses.get(checked[i]);
			queue.add(virus);
			newMap[virus.r][virus.c]=-1;
		}
		
		int depth=1;
		while(!queue.isEmpty()) {
			int size=queue.size();
			while(size-->0) {
				Virus v=queue.poll();
				
				for(int d=0;d<4;d++) {
					int nx=v.r+dx[d];
					int ny=v.c+dy[d];
					
					if(isIn(nx, ny) && newMap[nx][ny]==0) {
						newMap[nx][ny]=depth;
						queue.add(new Virus(nx, ny));
					}
				}
			}
			depth++;
		}
//		System.out.println("virus: "+Arrays.toString(checked));
		int result=0;
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(newMap[r][c]==0) return -1;
				result=Math.max(result, newMap[r][c]);
			}
//			System.out.println();
		}
		return result;
	}
	
	private static void copyMap(int [][]map, int [][]newMap) {
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c]==1) newMap[r][c]=-2;
			}
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N; 
	}
}
