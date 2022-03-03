package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17829_222풀링 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N;
	private static int [][] map, newMap;
	private static List<Integer> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		map=new int[N][N];
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(bf.readLine());
			for(int c=0;c<N;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		// 입력 확인
//		for(int []r:map) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		int size=N;
		while(size>1) {
			list=new ArrayList<>();
			for(int r=0;r<size;r+=2) {
				for(int c=0;c<size;c+=2) {
					list.add(find(r, c));
				}
			}
			size/=2;
			
			map=new int[size][size];
			map=makeMatrix(size);
		}
		System.out.println(map[0][0]);
	}

	public static int find(int x, int y) {
		int first=Integer.MIN_VALUE, second=Integer.MIN_VALUE;
		for(int r=0;r<2;r++) {
			for(int c=0;c<2;c++) {
				if(map[x+r][y+c]>first) {
					second=first;
					first=map[x+r][y+c];
				} else if(map[x+r][y+c]>second) {
					second=map[x+r][y+c];
				}
			}
		}
		return second;
	}
	
	public static int[][] makeMatrix(int size) {
		newMap=new int[size][size];
		int idx=0;
		for(int r=0;r<size;r++) {
			for(int c=0;c<size;c++) {
				newMap[r][c]=list.get(idx++);
			}
		}
		return newMap;
	}
}
