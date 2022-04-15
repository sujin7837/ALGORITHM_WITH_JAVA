package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_5373_큐빙 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int T, N;
	private static Map<Character, Integer> color=new HashMap<>();
	private static char[] colors = { 'w', 'y', 'r', 'o', 'g', 'b' };
	private static char[] direct= {'U', 'D', 'F', 'B', 'L', 'R'};
	private static char[][][] cubes;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int i=0;i<6;i++) {
			color.put(direct[i], i);
		}
		
		for (int t = 1; t <= T; t++) {
			init();
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				String s = st.nextToken();
				char face = s.charAt(0);
				char dir = s.charAt(1);
//				System.out.println(face+" "+dir);
				rotate(face, dir);
			}
			
			for(int r=0;r<3;r++) {
				for(int c=0;c<3;c++) {
					System.out.print(cubes[0][r][c]);
				}
				System.out.println();
			}
		}
	}

	private static void init() {
		cubes = new char[6][3][3];
		for (int i = 0; i < 6; i++) {
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					cubes[i][r][c] = colors[i];
				}
			}
		}
	}

	private static void rotate(char face, char dir) {
		rotateMain(face, dir);
		if(dir=='-') {
			rotateSide(face);
		} else {
			for(int i=0;i<3;i++) {
				rotateSide(face);
			}
		}
	}
	
	private static void rotateMain(char face, char dir) {
//		System.out.println(color+" "+face);
		int idx=color.get(face);
		char [][]newMap=new char[3][3];
		if (face == 'D') {
			if (dir == '+') { // 시계
				newMap[0][0] = cubes[idx][0][2];
				newMap[0][1] = cubes[idx][1][2];
				newMap[0][2] = cubes[idx][2][2];
				newMap[1][0] = cubes[idx][0][1];
				newMap[1][1] = cubes[idx][1][1];
				newMap[1][2] = cubes[idx][2][1];
				newMap[2][0] = cubes[idx][0][0];
				newMap[2][1] = cubes[idx][1][0];
				newMap[2][2] = cubes[idx][2][0];
				for(int r=0;r<3;r++) cubes[idx][r]=newMap[r].clone();
			} else { // 반시계
				newMap[0][0] = cubes[idx][2][0];
				newMap[0][1] = cubes[idx][1][0];
				newMap[0][2] = cubes[idx][0][0];
				newMap[1][0] = cubes[idx][2][1];
				newMap[1][1] = cubes[idx][1][1];
				newMap[1][2] = cubes[idx][0][1];
				newMap[2][0] = cubes[idx][2][2];
				newMap[2][1] = cubes[idx][1][2];
				newMap[2][2] = cubes[idx][0][2];
				for(int r=0;r<3;r++) cubes[idx][r]=newMap[r].clone();
			}
		} else {
			if (dir == '-') { // 반시계
				newMap[0][0] = cubes[idx][0][2];
				newMap[0][1] = cubes[idx][1][2];
				newMap[0][2] = cubes[idx][2][2];
				newMap[1][0] = cubes[idx][0][1];
				newMap[1][1] = cubes[idx][1][1];
				newMap[1][2] = cubes[idx][2][1];
				newMap[2][0] = cubes[idx][0][0];
				newMap[2][1] = cubes[idx][1][0];
				newMap[2][2] = cubes[idx][2][0];
				for(int r=0;r<3;r++) cubes[idx][r]=newMap[r].clone();
			} else { // 시계
				newMap[0][0] = cubes[idx][2][0];
				newMap[0][1] = cubes[idx][1][0];
				newMap[0][2] = cubes[idx][0][0];
				newMap[1][0] = cubes[idx][2][1];
				newMap[1][1] = cubes[idx][1][1];
				newMap[1][2] = cubes[idx][0][1];
				newMap[2][0] = cubes[idx][2][2];
				newMap[2][1] = cubes[idx][1][2];
				newMap[2][2] = cubes[idx][0][2];
				for(int r=0;r<3;r++) cubes[idx][r]=newMap[r].clone();
			}
		}
	}

	private static void rotateSide(char face) {
		if(face=='U') {
			char[] tmp = new char[3];
			for (int i = 0; i < 3; i++) {
				tmp[i] = cubes[3][0][i];
			}
			for (int i = 0; i < 3; i++) {
				cubes[3][0][i] = cubes[5][0][i];
				cubes[5][0][i] = cubes[2][0][i];
				cubes[2][0][i] = cubes[4][0][i];
				cubes[4][0][i] = tmp[i];
			}
		} else if(face=='D') {
			char[] tmp = new char[3];
			for (int i = 0; i < 3; i++) {
				tmp[i] = cubes[3][2][i];
			}
			for (int i = 0; i < 3; i++) {
				cubes[3][2][i]=cubes[4][2][i];
				cubes[4][2][i]=cubes[2][2][i];
				cubes[2][2][i]=cubes[5][2][i];
				cubes[5][2][i]=tmp[i];
			}
		} else if(face=='F') {
			char[] tmp = new char[3];
			for(int i=0;i<3;i++) {
				tmp[i]=cubes[0][2][i];
			}
			for (int i = 0; i < 3; i++) {
				cubes[0][2][i]=cubes[5][i][0];
				cubes[5][i][0]=cubes[1][2][2-i];
				cubes[1][2][2-i]=cubes[4][2-i][2];
				cubes[4][2-i][2]=tmp[i];
			}
		} else if(face=='B') {
			char[] tmp = new char[3];
			for(int i=0;i<3;i++) {
				tmp[i]=cubes[0][0][i];
			}
			for (int i = 0; i < 3; i++) {
				cubes[0][0][i]=cubes[4][2-i][0];
				cubes[4][2-i][0]=cubes[1][0][2-i];
				cubes[1][0][2-i]=cubes[5][i][2];
				cubes[5][i][2]=tmp[i];
			}
		} else if(face=='L') {
			char[] tmp = new char[3];
			for(int i=0;i<3;i++) {
				tmp[i]=cubes[0][i][0];
			}
			for (int i = 0; i < 3; i++) {
				cubes[0][i][0]=cubes[2][i][0];
				cubes[2][i][0]=cubes[1][2-i][0];
				cubes[1][2-i][0]=cubes[3][2-i][2];
				cubes[3][2-i][2]=tmp[i];
			}
		} else if(face=='R') {
			char[] tmp = new char[3];
			for(int i=0;i<3;i++) {
				tmp[i]=cubes[0][2-i][2];
			}
			for (int i = 0; i < 3; i++) {
				cubes[0][2-i][2]=cubes[3][i][0];
				cubes[3][i][0]=cubes[1][i][2];
				cubes[1][i][2]=cubes[2][2-i][2];
				cubes[2][2-i][2]=tmp[i];
			}
		}
	}
}
