package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_21608_상어초등학교 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N;
	private static int [][]map;
	private static Map<Integer, List<Integer>> students;
	private static int []order;
	private static int []dx= {-1,1,0,0};
	private static int []dy= {0,0,-1,1};
	
	static class Seat implements Comparable<Seat> {
		int r, c, cnt, blank;

		public Seat(int r, int c, int cnt, int blank) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.blank = blank;
		}

		@Override
		public String toString() {
			return "Seat [r=" + r + ", c=" + c + ", cnt=" + cnt + ", blank=" + blank + "]";
		}

		@Override
		public int compareTo(Seat o) {
			if(this.cnt==o.cnt) {
				if(this.blank==o.blank) {
					if(this.r==o.r) return Integer.compare(this.c, o.c);
					else return Integer.compare(this.r, o.r);
				} else return -1*Integer.compare(this.blank, o.blank);
			}
			return -1*Integer.compare(this.cnt, o.cnt);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N+1][N+1];
		students=new HashMap<>();
		order=new int[N*N];
		
		for(int r=0;r<N*N;r++) {
			st=new StringTokenizer(br.readLine());
			int get=Integer.parseInt(st.nextToken());
			order[r]=get;
			List<Integer> tmp=new ArrayList<>();
			for(int c=0;c<4;c++) {
				tmp.add(Integer.parseInt(st.nextToken()));
			}
			students.put(get, tmp);
		}
		
		// 입력 확인
//		System.out.println(students);
//		System.out.println(Arrays.toString(order));
		
		for(int i=1;i<=N*N;i++) {
			chooseSeat(order[i-1]);
		}
		
		int result=0;
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) {
				int score=satisfy(r, c);
				if(score==1) result+=1;
				else if(score==2) result+=10;
				else if(score==3) result+=100;
				else if(score==4) result+=1000;
			}
		}
		
		System.out.println(result);
	}

	private static int satisfy(int r, int c) {
		List<Integer> list=students.get(map[r][c]);
		int cnt=0;
		for(int d=0;d<4;d++) {
			int nx=r+dx[d];
			int ny=c+dy[d];
			
			if(isIn(nx, ny) && list.contains(map[nx][ny])) cnt++;
		}
		return cnt;
	}
	
	private static void chooseSeat(int x) {
		PriorityQueue<Seat> pq=new PriorityQueue<>();
		
		List<Integer> list=students.get(x);
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) {
				if(map[r][c]!=0) continue;
				int cnt=0;
				int blank=0;
				for(int d=0;d<4;d++) {
					int nx=r+dx[d];
					int ny=c+dy[d];
					
					if(isIn(nx, ny)) {
						if(map[nx][ny]==0) blank++;
						else if(list.contains(map[nx][ny])) cnt++;
					}
				}
				pq.add(new Seat(r, c, cnt, blank));
			}
		}
//		System.out.println(pq);
//		for(int []r:map) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		Seat s=pq.poll();
		map[s.r][s.c]=x;
	}
	
	private static boolean isIn(int r, int c) {
		return r>=1 && r<=N && c>=1 && c<=N;
	}
}
