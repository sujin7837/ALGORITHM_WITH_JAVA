package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int N, time = 0;
	private static int[][] map;
	private static BabyShark babyShark;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	static class BabyShark {
		int r, c, size, eatCnt;

		public BabyShark(int r, int c, int size, int eatCnt) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.eatCnt = eatCnt;
		}

		@Override
		public String toString() {
			return "BabyShark [r=" + r + ", c=" + c + ", size=" + size + ", eatCnt=" + eatCnt + "]";
		}

		void eat() {
			eatCnt++;
			if (eatCnt == size) {
				size++;
				eatCnt = 0;
			}
		}
	}

	static class Fish implements Comparable<Fish> {
		int r, c, size, dist;

		public Fish(int r, int c, int size, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Fish [r=" + r + ", c=" + c + ", size=" + size + "dist=" + dist + "]";
		}

		@Override
		public int compareTo(Fish o) {
			if (this.dist == o.dist) {
				if (this.r == o.r)
					return Integer.compare(this.c, o.c);
				else
					return Integer.compare(this.r, o.r);
			} else
				return Integer.compare(this.dist, o.dist);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(bf.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 9) {
					babyShark = new BabyShark(r, c, 2, 0);
					map[r][c] = 0;
				}
			}
		}

		// 입력 확인
//		for(int []r:map) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
//		System.out.println(babyShark);
//		System.out.println(fish);

		bfs(babyShark);
		System.out.println(time);
	}

	public static void bfs(BabyShark bs) {
		boolean[][] visited = new boolean[N][N];
		visited[bs.r][bs.c] = true;

		Queue<BabyShark> queue = new LinkedList<>();
		queue.offer(bs);

		int depth=0;
		Fish target=null;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				BabyShark b = queue.poll();
				
				for (int i = 0; i < 4; i++) {
					int nx = b.r + dx[i];
					int ny = b.c + dy[i];

					if (isIn(nx, ny) && !visited[nx][ny]) {
						visited[nx][ny]=true;
						if (map[nx][ny] == 0 || map[nx][ny] == b.size) {
							queue.offer(new BabyShark(nx, ny, b.size, b.eatCnt));
						} else if (map[nx][ny] < b.size) {
							Fish fish=new Fish(nx, ny, map[nx][ny], depth+1);
							if(target==null) target=fish;
							else target=target.compareTo(fish)<0?target:fish;
						}
					}
				}
			}
			
			if(target!=null) break;
			depth++;
		}
		
		if(target==null) return;
		bs.eat();
		map[target.r][target.c]=0;
		time+=target.dist;
		bfs(new BabyShark(target.r, target.c, bs.size, bs.eatCnt));
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
