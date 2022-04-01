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

public class BOJ_1194_달이차오른다가자 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int N, M, R, C;
	private static char[][] maze;
	private static int[][] dist;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	static class Minsik {
		int r, c, cnt, key;

		public Minsik(int r, int c, int cnt, int key) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.key = key;
		}

		@Override
		public String toString() {
			return "Minsik [r=" + r + ", c=" + c + ", cnt=" + cnt + ", key=" + key + "]";
		}

	}

	public static void main(String[] args) throws IOException {

		bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new char[N][M];
		dist = new int[N][M];
		for (int i = 0; i < N; i++)
			Arrays.fill(dist[i], Integer.MAX_VALUE);

		for (int r = 0; r < N; r++) {
			String s = bf.readLine();
			for (int c = 0; c < M; c++) {
				maze[r][c] = s.charAt(c);
				if (maze[r][c] == '0') {
					R = r;
					C = c;
					dist[r][c] = 0;
					maze[r][c] = '.';
				}
			}
		}

		// 입력 확인
//		for(char []r:maze) {
//			for(char c:r) System.out.print(c+" ");
//			System.out.println();
//		}

//		System.out.println(1<<0);
		move(R, C);
	}

	public static void move(int r, int c) {
		Queue<Minsik> queue = new LinkedList<>();
		queue.add(new Minsik(r, c, 0, 0));

		boolean [][][]visited=new boolean[N][M][(int) Math.pow(2,6)];
		visited[r][c][0]=true;
		
		while(!queue.isEmpty()) {
			Minsik minsik=queue.poll();
			int R=minsik.r;
			int C=minsik.c;
			int cnt=minsik.cnt;
			int key=minsik.key;
			
			for(int i=0;i<4;i++) {
				int nx=R+dx[i];
				int ny=C+dy[i];
				
				if(isIn(nx, ny) && !visited[nx][ny][key]) {
					if(maze[nx][ny]=='1') {	// 출구
						System.out.println(cnt+1);
						return;
					} else if(maze[nx][ny]=='#') continue;	// 벽
					else if(maze[nx][ny]=='.') {	// 빈 칸
						visited[nx][ny][key]=true;
						queue.add(new Minsik(nx, ny, cnt+1, key));
					} else if(isKey(nx, ny)) {	// 열쇠
						int newKey=1<<(maze[nx][ny]-'a');
						newKey|=key;
						if(!visited[nx][ny][newKey]) {
							visited[nx][ny][key]=true;
							visited[nx][ny][newKey]=true;
							queue.add(new Minsik(nx, ny, cnt+1, newKey));
						}
					} else if(isDoor(nx, ny)) {	// 문
						boolean check=((key & (1<<(maze[nx][ny]-'A')))!=0);
						if(check) {	// 열쇠를 갖고있는 경우
							visited[nx][ny][key]=true;
							queue.add(new Minsik(nx, ny, cnt+1, key));
						} else continue;	// 열쇠가 없는 경우
					}
				}
			}
		}
		System.out.println(-1);
		return;
	}

	public static boolean isKey(int r, int c) {
		return maze[r][c] >= 'a' && maze[r][c] <= 'f';
	}

	public static boolean isDoor(int r, int c) {
		return maze[r][c] >= 'A' && maze[r][c] <= 'F';
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
