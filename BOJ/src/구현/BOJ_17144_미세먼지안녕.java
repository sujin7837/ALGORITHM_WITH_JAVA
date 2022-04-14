package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int R, C, T;
	private static int [][]map, newMap;
	private static AirMachine airMachine;
	private static int []dx= {-1,1,0,0};
	private static int []dy= {0,0,-1,1};

	static class AirMachine {
		int x1, x2;

		public AirMachine(int x1, int x2) {
			super();
			this.x1 = x1;
			this.x2 = x2;
		}

		@Override
		public String toString() {
			return "AirMachine [x1=" + x1 + ", x2=" + x2 + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		map=new int[R+1][C+1];
		boolean check=false;
		
		for(int r=1;r<=R;r++) {
			st=new StringTokenizer(br.readLine());
			for(int c=1;c<=C;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
				if(map[r][c]==-1 && !check) {
					airMachine=new AirMachine(r, r+1);
					check=true;
				}
			}
		}
//		System.out.println(airMachine);
		for(int t=1;t<=T;t++) {
			boolean [][]visited=new boolean[R+1][C+1];
			newMap=new int[R+1][C+1];
			
			// 미세먼지 확산
			for(int r=1;r<=R;r++) {
				for(int c=1;c<=C;c++) {
					if(map[r][c]==0 || visited[r][c]) continue;
					spread(r, c, map[r][c]);
				}
			}
			
			copyMap(map, newMap);
//			for(int r=1;r<=R;r++) {
//				for(int c=1;c<=C;c++) {
//					System.out.print(map[r][c]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			// 공기청정기 작동
//			air();
//			for(int r=1;r<=R;r++) {
//				for(int c=1;c<=C;c++) {
//					System.out.print(map[r][c]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		
		int result=0;
		for(int r=1;r<=R;r++) {
			for(int c=1;c<=C;c++) {
				if(map[r][c]==0 || map[r][c]==-1) continue;
				result+=map[r][c];
			}
		}
		
		System.out.println(result);
	}

	private static void copyMap(int [][]map, int [][]newMap) {
		for(int r=1;r<=R;r++) map[r]=newMap[r].clone();
	}
	private static void spread(int r, int c, int x) {
		int val=x/5;
		int cnt=0;
		
		for(int d=0;d<4;d++) {
			int nx=r+dx[d];
			int ny=c+dy[d];
			
			if(ny==1 && (nx==airMachine.x1 || nx==airMachine.x2)) continue;
			if(isIn(nx, ny)) {
				cnt++;
				newMap[nx][ny]+=val;
			}
		}
		newMap[r][c]+=map[r][c]-val*cnt;
	}
	
	private static void air() {	// 공기청정기 작동
		// top
		for(int r=airMachine.x1-1;r>1;r--) {
			map[r][1]=map[r-1][1];
		}
		for(int c=1;c<C;c++) {
			map[1][c]=map[1][c+1];
		}
		for(int r=1;r<airMachine.x1;r++) {
			map[r][C]=map[r+1][C];
		}
		for(int c=C;c>2;c--) {
			map[airMachine.x1][c]=map[airMachine.x1][c-1];
		}
		map[airMachine.x1][2]=0;
		
		// down
		for(int r=airMachine.x2+1;r<R;r++) {
			map[r][1]=map[r+1][1];
		}
		for(int c=1;c<C;c++) {
			map[R][c]=map[R][c+1];
		}
		for(int r=R;r>airMachine.x2;r--) {
			map[r][C]=map[r-1][C];
		}
		for(int c=C;c>2;c--) {
			map[airMachine.x2][c]=map[airMachine.x2][c-1];
		}
		map[airMachine.x2][2]=0;
	}
	
	private static boolean isIn(int r, int c) {
		return r>=1 && r<=R && c>=1 && c<=C;
	}
}
