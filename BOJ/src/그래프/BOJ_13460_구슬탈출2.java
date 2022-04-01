package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13460_구슬탈출2 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int N, M, redR, redC, blueR, blueC;
	private static char[][] map;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	static class Marble {
		int r, c, dist;

		public Marble(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Marble [r=" + r + ", c=" + c + ", dist=" + dist + "]";
		}

	}

	static class Game {
		int redR, redC, blueR, blueC;

		public Game(int redR, int redC, int blueR, int blueC) {
			super();
			this.redR = redR;
			this.redC = redC;
			this.blueR = blueR;
			this.blueC = blueC;
		}

		@Override
		public String toString() {
			return "Game [redR=" + redR + ", redC=" + redC + ", blueR=" + blueR + ", blueC=" + blueC + "]";
		}

	}

	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char[N][M];
		
		for(int r=0;r<N;r++) {
			String s=bf.readLine();
			for(int c=0;c<M;c++) {
				map[r][c]=s.charAt(c);
				if(map[r][c]=='R') {
					redR=r;
					redC=c;
				}
				if(map[r][c]=='B') {
					blueR=r;
					blueC=c;
				}
			}
		}

	int result=startGame(new Game(redR, redC, blueR, blueC));
	System.out.println(result);

	}

	public static int startGame(Game game) {
		Queue<Game> queue=new LinkedList<>();
		queue.add(game);
//		System.out.println(game);
		boolean [][][][]visited=new boolean[N][M][N][M];
		visited[game.redR][game.redC][game.blueR][game.blueC]=true;
		
		int cnt=0;
		while(!queue.isEmpty() && cnt++<10) {
			int size=queue.size();
			
			while(size-->0) {
				Game g=queue.poll();
				
				for(int i=0;i<4;i++) {
					Marble blue=move(new Marble(g.blueR, g.blueC, 0), i);
					if(map[blue.r][blue.c]=='O') continue;
					
					Marble red=move(new Marble(g.redR, g.redC, 0), i);
					if(map[red.r][red.c]=='O') return cnt;
					
					if(blue.r==red.r && blue.c==red.c) {
						if(blue.dist>red.dist) {
							blue.r-=dx[i];
							blue.c-=dy[i];
						} else {
							red.r-=dx[i];
							red.c-=dy[i];
						}
					}
					
					if(!visited[red.r][red.c][blue.r][blue.c]) {
						visited[red.r][red.c][blue.r][blue.c]=true;
						queue.add(new Game(red.r, red.c, blue.r, blue.c));
					}
				}
				
			}
		}
		return -1;
	}
	
	public static Marble move(Marble marble, int dir) {
		int R=marble.r;
		int C=marble.c;
		int cnt=0;
				
		while(map[R+dx[dir]][C+dy[dir]]!='#' && map[R][C]!='O') {
			R+=dx[dir];
			C+=dy[dir];
			cnt++;
		}
		
		return new Marble(R, C, cnt);
	}
}
