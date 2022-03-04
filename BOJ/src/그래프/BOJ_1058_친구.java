package 그래프;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1058_친구 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N;
	private static char [][] map;
//	private static int [] cnt;
	private static List<Integer> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		map=new char[N][N];
		HashMap<Integer, List> friends=new HashMap<>();
		HashMap<Integer, List> plus=new HashMap<>();
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(bf.readLine());
			map[r]=st.nextToken().toCharArray();
		}
		
		// 입력 확인
//		for(char []r:map) {
//			for(char c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		for(int r=0;r<N;r++) {
			list=new ArrayList<>();
			for(int c=0;c<N;c++) {
				if(map[r][c]=='Y') {
//					cnt[r]++;
					list.add(c);
				}
			}
			friends.put(r, list);
		}
		for(int i=0;i<N;i++) {
			List li=new ArrayList<>();
			List friends1=friends.get(i);
			int size1=friends1.size();
			for(int j=0;j<size1;j++) {
				List friends2=friends.get(friends1.get(j));
				int size2=friends2.size();
				for(int k=0;k<size2;k++) {
					if((int)friends2.get(k)!=i && !friends1.contains(friends2.get(k)) && !li.contains(friends2.get(k))) {
						li.add(friends2.get(k));
					}
				}
			}
			plus.put(i, li);
		}
//		System.out.println(friends);
//		System.out.println(plus);
		int maxVal=0;
		for(int i=0;i<N;i++) {
			int tmp=friends.get(i).size()+plus.get(i).size();
			maxVal=Math.max(maxVal, tmp);
		}
		System.out.println(maxVal);
	}

}
