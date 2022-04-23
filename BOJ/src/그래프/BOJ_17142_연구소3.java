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

public class BOJ_17142_연구소3 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, M, result;
	private static int [][]map;
	private static int []dx= {-1,1,0,0};
	private static int []dy= {0,0,-1,1};
	private static List<Virus> viruses;
	
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
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		viruses=new ArrayList<>();
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
				if(map[r][c]==2) viruses.add(new Virus(r, c));
			}
		}
		
		result=Integer.MAX_VALUE;
		combination(M, new Virus[M], 0);
		System.out.println(result==Integer.MAX_VALUE?-1:result);
	}

	private static void combination(int toChoose, Virus []choosed, int start) {	// 활성화할 M개의 바이러스 찾기
		if(toChoose==0) {
			int [][]newMap=new int[N][N];
//			System.out.println("start!!!");
			copyMap(map, newMap);
//			for(int []r:map) {
//				for(int c:r) System.out.print(c+" ");
//				System.out.println();
//			}
			int cnt=bfs(choosed);
			if(!check()) {
				copyMap(newMap, map);
				return;
			}
			copyMap(newMap, map);
			result=Math.min(cnt, result);
//			for(int []r:map) {
//				for(int c:r) System.out.print(c+" ");
//				System.out.println();
//			}
//			System.out.println("cnt "+cnt+"  ");
//			System.out.println(Arrays.toString(choosed));
			return;
		}
		
		for(int i=start;i<viruses.size();i++) {
			choosed[choosed.length-toChoose]=viruses.get(i);
			combination(toChoose-1, choosed, i+1);
		}
	}
	
	private static void copyMap(int [][]map, int [][]newMap) {
		for(int i=0;i<N;i++) newMap[i]=map[i].clone();
	}
	
	private static boolean check() {
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c]==0) return false;
			}
		}
		return true;
	}
	
	private static int bfs(Virus []choosed) {
		Queue<Virus> queue=new LinkedList<>();
		boolean [][]visited=new boolean[N][N];
		for(int i=0;i<choosed.length;i++) {
			Virus v=choosed[i];
			queue.add(v);
			visited[v.r][v.c]=true;
		}
		
		int depth=0;
		while(!check() && !queue.isEmpty()) {
			int size=queue.size();
			boolean have=false;
			while(size-->0) {
				Virus v=queue.poll();
				
				for(int d=0;d<4;d++) {
					int nx=v.r+dx[d];
					int ny=v.c+dy[d];
					
					if(isIn(nx, ny) && !visited[nx][ny] && map[nx][ny]!=1) {
						have=true;
						visited[nx][ny]=true;
						map[nx][ny]=2;
						queue.add(new Virus(nx, ny));
					}
				}
			}
			if(have) depth++;
//			for(int []r:map) {
//				for(int c:r) System.out.print(c+" ");
//				System.out.println();
//			}
//			System.out.println("depth: "+depth);
		}
		return depth;
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
