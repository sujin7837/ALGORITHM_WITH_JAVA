package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {

	private static int R, C, result=0;
	private static char[][] map;
	private static int [] dx = {-1, 0, 1};
	private static int [] dy = {1, 1, 1};
	private static boolean [][] visited;
	private static List<Integer> list=new ArrayList<>();
	private static StringTokenizer st;
	private static BufferedReader bf;
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		visited=new boolean[R][C];

		for(int r=0;r<R;r++) {
			st=new StringTokenizer(bf.readLine());
			String s=st.nextToken();
			for(int c=0;c<C;c++) {
				map[r][c]=s.charAt(c);
			}
		}
		
		// 입력 확인
//		for(char []r:map) {
//			for(char c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		for(int r=0;r<R;r++) {
			result+=dfs(r, 0);
		}
		System.out.println(result);
	}

	public static int dfs(int r, int c) {
		if(c==C-1) return 1;
		
		int ret=0;
		for(int i=0;i<3;i++) {
			int nx=r+dx[i];
			int ny=c+dy[i];
			
			if(isIn(nx, ny) && !visited[nx][ny] && map[nx][ny]=='.') {
//				System.out.println(nx+" : "+ny);
				visited[nx][ny]=true;
				ret=dfs(nx, ny);
				if(ret==1) return 1;
			}
		}
		return 0;
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
}
