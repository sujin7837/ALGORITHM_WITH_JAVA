package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int N, M, min;
	private static List<CCTV> list;
	private static int[][] map, newMap;
	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0 };
	private static int[][] cctv = { {}, { 8, 4, 2, 1 }, { 12, 3 }, { 9, 5, 6, 10 }, { 11, 13, 7, 14 }, { 15 } };

	static class CCTV {
		int r, c, num;

		public CCTV(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}

	}

	public static void main(String[] args) throws IOException {

		bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list=new ArrayList<>();

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(bf.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]>=1 && map[r][c]<=5) list.add(new CCTV(r, c, map[r][c]));
			}
		}

		// 입력 확인
//		for(int []r:cctv) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}

//		for(int []r:cctv) {
//			for(int c:r) {
//				for(int i=0;i<4;i++) {
//					if((c&1<<i)>0) System.out.println(c+" "+i);
//				}
//			}
//		}

		min=Integer.MAX_VALUE;
		search(0, map);
		System.out.println(min);
	}

	private static void search(int count, int [][]map) {
		if(count==list.size()) {
			int cnt=countArea(map);
			min=Math.min(min, cnt);
			return;
		}
//		for(int i=0;i<list.size();i++) {
		newMap=new int[N][M];
		copyMap(map, newMap);
		CCTV now=list.get(count);
		for(int j=0;j<cctv[now.num].length;j++) {	// cctv의 가능한 모든 방향 탐색
			for(int d=0;d<4;d++) {
				if((cctv[now.num][j]&1<<d)>0) {	// 방향 d로 이동이 가능한 경우
					getMap(now.r, now.c, d, newMap);
				}
			}
			search(count+1, newMap);
			copyMap(map, newMap);
		}
			
//		}
	}
	
	private static void getMap(int r, int c, int dir, int [][]newMap) {	// cctv 감시 가능 영역 표시
		int R=r;
		int C=c;
//		int cnt=0;
		while(true) {
			R+=dx[dir];
			C+=dy[dir];
			
			if(!isIn(R, C)) return;	// 범위를 벗어나면 감시 가능한 영역 끝
			if(newMap[R][C]==6) return;
			newMap[R][C]=-1;
//			cnt++;
		}
	}
	
	private static int countArea(int [][]map) {
		int cnt=0;
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				if(map[r][c]==0) cnt++;
			}
		}
		return cnt;
	}
	
	private static void copyMap(int [][]map, int [][]newMap) {
		for(int r=0;r<N;r++) newMap[r]=map[r].clone();
	}

	
	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
