package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int T, N, W, H, result;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	static class Point {
		int r, c, val;

		public Point(int r, int c, int val) {
			super();
			this.r = r;
			this.c = c;
			this.val = val;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", val=" + val + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int [][]map = new int[H][W];

			for (int r = 0; r < H; r++) {
				st = new StringTokenizer(bf.readLine());
				for (int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			// 입력 확인
//			for(int []r:map) {
//				for(int c:r) System.out.print(c+" ");
//				System.out.println();
//			}

			result=Integer.MAX_VALUE;
			game(0, map);

			System.out.println("#" + t + " " + result);
		}
	}

	private static boolean game(int count, int [][]map) {
		int res=getRemain(map);
		if(res==0) {
			result=0;
			return true;	// 남은 구슬이 없음
		}
		
		if(count==N) {	// 모든 행을 탐색 완료
			result=Math.min(result, res);
			return false;
		}
		
		int [][]newMap=new int[H][W];
		for(int c=0;c<W;c++) {
			// 시작 위치를 탐색
			int r=0;
			while(r<H && map[r][c]==0) r++;
			if(r==H) continue;	// 행에 구슬이 없으면 다음 행으로 넘어감
			
			// 현재 배열 정보 백업
			copyMap(map, newMap);
			// 벽돌 깨기
			crash(r, c, newMap);
			// 남은 벽돌 이동
			move(newMap);
			
			if(game(count+1, newMap)) return true;
		}
		return false;
	}
	
	// 배열 정보 백업
	private static void copyMap(int [][]map, int [][]newMap) {
		for(int r=0;r<H;r++) newMap[r]=map[r].clone();
	}
	
	// 벽돌 깨기
	private static void crash(int r, int c, int [][]map) {
		Queue<Point> queue=new LinkedList<>();
		if(map[r][c]>1) queue.add(new Point(r, c, map[r][c]));
		
		map[r][c]=0;	// 자기 자신 0 처리
		while(!queue.isEmpty()) {
			Point p=queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx=p.r;
				int ny=p.c;
				
				for(int v=0;v<p.val-1;v++) {	// 사방 벽돌 깨기
					nx+=dx[i];
					ny+=dy[i];
					
					if(!isIn(nx, ny)) continue;
					if(map[nx][ny]>0) {
						if(map[nx][ny]>1) queue.add(new Point(nx, ny, map[nx][ny]));
						map[nx][ny]=0;
					}
				}
			}
		}
	}
	
	// 남은 구슬 이동
	private static void move(int [][]map) {
		Stack<Integer> stack;
		
		for(int c=0;c<W;c++) {
			stack=new Stack<>();
			for(int r=0;r<H;r++) {
				if(map[r][c]>0) {
					stack.add(map[r][c]); 
					map[r][c]=0;
				}
			}
			int R=H-1;
			while(!stack.isEmpty()) {
				int val=stack.pop();
				map[R][c]=val;
				R--;
			}
		}
	}
	
	// 남은 구슬의 개수
	private static int getRemain(int [][]map) {
		int count=0;
		for(int r=0;r<H;r++) {
			for(int c=0;c<W;c++) {
				if(map[r][c]>0) count++;
			}
		}
		
		return count;
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && r<H && c>=0 && c<W;
	}
}
