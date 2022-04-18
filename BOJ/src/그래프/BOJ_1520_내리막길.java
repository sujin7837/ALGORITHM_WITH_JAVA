package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1520_내리막길 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int M, N;
	private static int[][] map, dp;
	private static int []dx= {-1,1,0,0};	// 사방탐색 x좌표: (상, 하, 좌, 우)
	private static int []dy= {0,0,-1,1};	// 사방탐색 y좌표: (상, 하, 좌, 우)

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());	// 산의 세로 크기
		N = Integer.parseInt(st.nextToken());	// 산의 가로 크기
		map = new int[M][N];	// 산의 정보를 저장할 2차원 배열
		dp=new int[M][N];

		for (int r = 0; r < M; r++) {	// 산의 정보 저장
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for(int r=0;r<M;r++) {
			for(int c=0;c<N;c++) dp[r][c]=-1;
		}
		
		int result=findPath(0, 0);	// 시작점에서 탐색 시작
		System.out.println(result);	// 탐색 결과 가능한 경로의 개수 출력
	}

	private static int findPath(int r, int c) {	// 내리막길을 이동하며 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸에 도착하는 방법의 수 탐색(bfs)
		if(r==M-1 && c==N-1) return 1;
		if(dp[r][c]!=-1) return dp[r][c];
		
		dp[r][c]=0;
		for(int d=0;d<4;d++) {
			int nx=r+dx[d];
			int ny=c+dy[d];
			
			if(isIn(nx, ny) && map[nx][ny]<map[r][c]) {
				dp[r][c]+=findPath(nx, ny);
			}
		}
		return dp[r][c];
	}
	
	
	
	private static boolean isIn(int r, int c) {	// 좌표가 2차원 배열의 범위 내에 있는지 확인
		return r>=0 && r<M && c>=0 && c<N;
	}
}
