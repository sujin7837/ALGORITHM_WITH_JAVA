package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15684_사다리조작 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, M, H, result;
	private static int [][]map;
	private static boolean can=false;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		map=new int[H+1][N+1];
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			map[a][b]=-1;
			map[a][b+1]=1;
		}
		
		result=Integer.MAX_VALUE;
		for(int i=0;i<4;i++) {
			result=i;
			dfs(1, 0);
			if(can) break;
		}
		if(!can) result=-1;
		System.out.println(result);
	}

	private static void dfs(int idx, int count) {
		if(result==count) {
			if(destination()) can=true;
			return;
		}
		
		for(int r=idx;r<=H;r++) {
			for(int c=1;c<N;c++) {
				if(map[r][c]==0 && map[r][c+1]==0) {	// 사다리를 세울 수 있는 경우
					map[r][c]=-1;
					map[r][c+1]=1;
					dfs(idx, count+1);
					map[r][c]=map[r][c+1]=0;
				}
			}
		}
	}
	
	private static boolean destination() {	// 사다리를 탄 결과
		for(int c=1;c<=N;c++) {
			int r=1;
			int start=c;
			while(r<=H) {
				if(map[r][start]==-1) start+=1;	// 사다리 왼쪽 만남
				else if(map[r][start]==1) start-=1;	// 사다리 오른쪽 만남
				r++;
			}
			if(start!=c) return false;
		}
		
		return true;
	}
}
