package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499_주사위굴리기 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M, x, y, K;
	private static int [][]map;
	private static int []direction;
	private static int [][]dice;
	private static int []dx= {0,0,-1,1};
	private static int []dy= {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		direction=new int[K];
		dice=new int[4][3];
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(bf.readLine());
			for(int c=0;c<M;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<K;i++) direction[i]=Integer.parseInt(st.nextToken());
		
		int nx=x, ny=y;
		for(int i=0;i<K;i++) {
			int dir=direction[i];
			nx+=dx[dir-1];
			ny+=dy[dir-1];
			
			if(!isIn(nx, ny)) {	// 범위를 벗어나면 다음 명령으로 이동
				nx-=dx[dir-1];
				ny-=dy[dir-1];
				continue;	
			}
			diceRoll(dir);	// 주사위 굴리기
			if(map[nx][ny]==0) {	// 현재 map이 0이면 주사위 바닥면을 복사해옴
				map[nx][ny]=dice[1][1];
			} else {	// 현재 map이 0이 아니면 현재 map값을 주사위 바닥면으로 복사해옴
				dice[1][1]=map[nx][ny];
				map[nx][ny]=0;
			}
//			for(int []r:dice) {
//				for(int c:r) System.out.print(c+" ");
//				System.out.println();
//			}
			System.out.println(dice[3][1]);
		}
	}
	
	private static void diceRoll(int dir) {
		int [][]tmp=new int[4][3];
		for(int r=0;r<4;r++) tmp[r]=dice[r].clone();
		
		if(dir==1) {	// 동
			dice[3][1]=tmp[1][0];
			dice[1][0]=tmp[1][1];
			dice[1][1]=tmp[1][2];
			dice[1][2]=tmp[3][1];
		} else if(dir==2) {	// 서
			dice[1][1]=tmp[1][0];
			dice[1][2]=tmp[1][1];
			dice[3][1]=tmp[1][2];
			dice[1][0]=tmp[3][1];
		} else if(dir==3) {	// 북
			dice[1][1]=tmp[0][1];
			dice[2][1]=tmp[1][1];
			dice[3][1]=tmp[2][1];
			dice[0][1]=tmp[3][1];
		} else if(dir==4) {	// 남
			dice[3][1]=tmp[0][1];
			dice[0][1]=tmp[1][1];
			dice[1][1]=tmp[2][1];
			dice[2][1]=tmp[3][1];
		}
	}

	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
