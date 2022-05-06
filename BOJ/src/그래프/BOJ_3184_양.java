package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3184_양 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int R, C, sheepN, wolfN;
	private static char[][] map;
	private static boolean[][] visited;
	private static int []dx= {-1,1,0,0};
	private static int []dy= {0,0,-1,1};

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];

		for (int r = 0; r < R; r++) {
			String s = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = s.charAt(c);
			}
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (!visited[r][c] && map[r][c] != '#') {
					bfs(r, c);
				}
			}
		}
		sheepN=0;
		wolfN=0;
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(map[r][c]=='o') sheepN++;
				if(map[r][c]=='v') wolfN++;
			}
		}
		System.out.println(sheepN+" "+wolfN);
	}

	private static void bfs(int r, int c) {
		Queue<Point> queue=new LinkedList<>();
		queue.add(new Point(r, c));
		
		visited[r][c]=true;
		List<Point> sheep=new ArrayList<>();
		List<Point> wolf=new ArrayList<>();
		if(map[r][c]=='o') sheep.add(new Point(r, c));
		if(map[r][c]=='v') wolf.add(new Point(r, c));
		while(!queue.isEmpty()) {
			Point p=queue.poll();
			
			for(int d=0;d<4;d++) {
				int nx=p.r+dx[d];
				int ny=p.c+dy[d];
				
				if(isIn(nx, ny) && !visited[nx][ny] && map[nx][ny]!='#') {
					visited[nx][ny]=true;
					if(map[nx][ny]=='o') sheep.add(new Point(nx, ny));
					if(map[nx][ny]=='v') wolf.add(new Point(nx, ny));
					queue.add(new Point(nx, ny));
				}
			}
		}
		if(sheep.size()>wolf.size()) {
			for(int i=0;i<wolf.size();i++) {
				Point p=wolf.get(i);
				map[p.r][p.c]='.';
			}
		} else {
			for(int i=0;i<sheep.size();i++) {
				Point p=sheep.get(i);
				map[p.r][p.c]='.';
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}
