package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int R, C, M, result=0;
	private static int []dx= {0,-1,1,0,0};
	private static int []dy= {0,0,0,1,-1};
	private static PriorityQueue<Shark> pq;
	
	static class Shark implements Comparable<Shark> {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
		
		@Override
		public int compareTo(Shark o) {
			if(this.c==o.c) {
				if(this.r==o.r) return Integer.compare(this.z, o.z);
				return Integer.compare(this.r, o.r);
			}
			return Integer.compare(this.c, o.c);
		}
	}
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		pq=new PriorityQueue<>();
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int z=Integer.parseInt(st.nextToken());
			pq.add(new Shark(r, c, s, d, z));
		}
		
		for(int i=1;i<=C;i++) {
//			System.out.println(i);
			fishing(i);
//			System.out.println(pq);
		}
		System.out.println(result);
	}

	private static void fishing(int x) {
		haveShark(x);
		moveShark();
//		System.out.println();
	}
	
	private static void eat() {
		if(pq.size()<=1) return;
		List<Shark> list=new ArrayList<>();
		Shark tmp=pq.poll();
		while(!pq.isEmpty()) {
			Shark s1=tmp;
			Shark s2=pq.poll();
//			System.out.println(s1+" "+s2);
			if(!(s1.r==s2.r && s1.c==s2.c)) list.add(s1);
			if(pq.isEmpty()) list.add(s2);
			tmp=s2;
//			System.out.println(list);
		}
		pq.addAll(list);
//		System.out.println("먹고 난 상어: "+pq);
	}
	
	private static void haveShark(int x) {
		if(pq.isEmpty() || pq.peek().c>x) return;	// x열에 상어가 존재하지 않음
		List<Shark> list=new ArrayList<>();
		while(!pq.isEmpty()) {
			Shark s=pq.poll();
			if(s.c==x) {	// 상어를 잡음
//				System.out.println("잡은 상어: "+s);
				result+=s.z;
				break;
			}
			list.add(s);	// 지나온 열의 상어 임시 보관
		}
		pq.addAll(list);
//		System.out.println("이동 전 상어: "+pq);
	}
	
	private static void moveShark() {
		List<Shark> list=new ArrayList<>();
		int remain;
		while(!pq.isEmpty()) {
			Shark s=pq.poll();
//			int remain=s.s%(2*C-2);
			int nx=s.r+dx[s.d]*s.s;
			int ny=s.c+dy[s.d]*s.s;
//			System.out.println(s+" "+nx+" "+ny);
			
			if(isIn(nx, ny)) list.add(new Shark(nx, ny, s.s, s.d, s.z));	// 경계를 넘지 않음
			else {	// 경계를 넘음 -> 방향 변경
				while(!isIn(nx, ny)) {
					if(s.d==1) {
						remain=Math.abs(nx)+1;
					} else if(s.d==2) {
						remain=Math.abs(R-nx);
					} else if(s.d==3) {
						remain=Math.abs(C-ny);
					} else {
						remain=Math.abs(ny)+1;
					}
					s.d=changeDir(s.d);	// 방향 변경
//				System.out.println(s+" "+remain);
					nx+=dx[s.d]*remain*2;
					ny+=dy[s.d]*remain*2;
				}
				list.add(new Shark(nx, ny, s.s, s.d, s.z));
			}
		}
		pq.addAll(list);
//		System.out.println("남은 상어: "+pq);
		eat();
	}
	
	private static int changeDir(int x) {
		int d=0;
		if(x==1) d=2;
		else if(x==2) d=1;
		else if(x==3) d=4;
		else if(x==4) d=3;
		return d;
	}
	
	private static boolean isIn(int r, int c) {
		return r>0 && r<=R && c>0 && c<=C;
	}
}
