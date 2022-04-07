package 모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int T, N, M, R, C, L;
	private static int [][]map;
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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		bf=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(bf.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			R=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			L=Integer.parseInt(st.nextToken());
			map=new int[N][M];
			
			for(int r=0;r<N;r++) {
				st=new StringTokenizer(bf.readLine());
				for(int c=0;c<M;c++) {
					map[r][c]=Integer.parseInt(st.nextToken());
				}
			}
			
			if(L==1) System.out.println("#"+t+" "+1);
			else {
				int result=bfs(new Point(R, C));
				System.out.println("#"+t+" "+result);
			}
		}
	}

	private static int bfs(Point point) {
		Queue<Point> queue=new LinkedList<>();
		queue.add(point);
		
		boolean [][]visited=new boolean[N][M];
		visited[point.r][point.c]=true;
		
		int depth=1;
		int cnt=1;
		while(!queue.isEmpty()) {
			if(depth==L) return cnt;
			int size=queue.size();
			
			while(size-->0) {
				Point p=queue.poll();
				
				for(int i=0;i<4;i++) {
					int nx=p.r+dx[i];
					int ny=p.c+dy[i];
					
					if(isIn(nx, ny) && !visited[nx][ny]) {
						if(map[nx][ny]==0) continue;
						if(isValid(new Point(nx, ny), p, i)) {
							cnt++;
							visited[nx][ny]=true;
							queue.add(new Point(nx, ny));
						}
					}
				}
			}
			depth++;
//			System.out.println(depth+" "+cnt+" "+L);
			
		}
		return cnt;
	}
	
	private static boolean isValid(Point np, Point op, int dir) {
		int or=op.r;
		int oc=op.c;
		int nr=np.r;
		int nc=np.c;
		if(dir==0) {	// 상
			if((map[or][oc]==1 || map[or][oc]==2 || map[or][oc]==4 || map[or][oc]==7) && (map[nr][nc]==1 || map[nr][nc]==2 || map[nr][nc]==5 || map[nr][nc]==6)) return true;
		} else if(dir==1) {	// 하
			if((map[or][oc]==1 || map[or][oc]==2 || map[or][oc]==5 || map[or][oc]==6) && (map[nr][nc]==1 || map[nr][nc]==2 || map[nr][nc]==4 || map[nr][nc]==7)) return true;
		} else if(dir==2) {	// 좌
			if((map[or][oc]==1 || map[or][oc]==3 || map[or][oc]==6 || map[or][oc]==7) && (map[nr][nc]==1 || map[nr][nc]==3 || map[nr][nc]==4 || map[nr][nc]==5)) return true;
		} else if(dir==3) {	// 우
			if((map[or][oc]==1 || map[or][oc]==3 || map[or][oc]==4 || map[or][oc]==5) && (map[nr][nc]==1 || map[nr][nc]==3 || map[nr][nc]==6 || map[nr][nc]==7)) return true;
		}
		return false;
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
