package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_20056_마법사상어와파이어볼 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, M, K;
	private static int []dx= {-1,-1,0,1,1,1,0,-1};
	private static int []dy= {0,1,1,1,0,-1,-1,-1};
	private static PriorityQueue<FireBall> fireBall;
	
	static class FireBall implements Comparable<FireBall> {
		int r, c, m, s, d;

		public FireBall(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public int compareTo(FireBall o) {
			if(this.r==o.r) return Integer.compare(this.c, o.c);
			return Integer.compare(this.r, o.r);
		}

		@Override
		public String toString() {
			return "FireBall [r=" + r + ", c=" + c + ", m=" + m + ", s=" + s + ", d=" + d + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		fireBall=new PriorityQueue<>();
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			fireBall.add(new FireBall(r, c, m, s, d));
		}
		
		for(int i=0;i<K;i++) {
			start();
		}
//		print();
//		System.out.println(fireBall);
		int result=0;
		while(!fireBall.isEmpty()) {
			FireBall fb=fireBall.poll();
			result+=fb.m;
		}
		System.out.println(result);
	}

//	private static void print() {
//		for(int i=0;i<fireBall.size();i++) System.out.println(fireBall.get(i));
//	}
	
	private static void start() {
		move();
		sameCheck();
	}
	
	private static List<FireBall> shareBall(List<FireBall> same) {
		List<FireBall> tmp=new ArrayList<>();
		int r=same.get(0).r;
		int c=same.get(0).c;
		int m=0;
		int s=0;
		boolean allOdd=true;
		boolean allEven=true;
//		System.out.println(same);
		for(int i=0;i<same.size();i++) {
			m+=same.get(i).m;
			s+=same.get(i).s;
			if((same.get(i).d)%2==0) allOdd=false;
			if((same.get(i).d)%2!=0) allEven=false;
		}
		m/=5;
//		System.out.println(m);
		s/=same.size();
		if(m==0) return null;
		if(allOdd || allEven) {
			for(int i=0;i<8;i+=2) {
				tmp.add(new FireBall(r, c, m, s, i));
			}
		} else {
			for(int i=1;i<8;i+=2) {
				tmp.add(new FireBall(r, c, m, s, i));
			}
		}
//		System.out.println(same);
//		System.out.println(tmp);
		return tmp;
	}
	
	private static void sameCheck() {
		List<FireBall> tmp=new ArrayList<>();
		List<FireBall> same=new ArrayList<>();
		FireBall fb=fireBall.poll();
		while(!fireBall.isEmpty()) {
			FireBall fb2=fireBall.poll();
			if(fb.r==fb2.r && fb.c==fb2.c) {
				same.add(fb);	// 같은 좌표에 있을 때
				if(fireBall.isEmpty()) {
					same.add(fb2);
					List<FireBall> get=shareBall(same);
					if(get!=null) tmp.addAll(get);
					same.clear();
				}
			}
			else {	// 같은 좌표가 아닐 때
				if(same.size()>0) {
					same.add(fb);
					List<FireBall> get=shareBall(same);
					if(get!=null) tmp.addAll(get);
					same.clear();
				}
				else tmp.add(fb);
				if(fireBall.isEmpty()) tmp.add(fb2);
			}
			fb=fb2;
//			System.out.println(tmp);
		}
//		System.out.println("---sameCheck---");
//		System.out.println(tmp);
		fireBall.addAll(tmp);
//		System.out.println(fireBall);
	}
	
	private static void move() {
		List<FireBall> tmp=new ArrayList<>();
		while(!fireBall.isEmpty()) {
			FireBall fb=fireBall.poll();
			int s=fb.s%N;
			int nx=fb.r+dx[fb.d]*s;
			int ny=fb.c+dy[fb.d]*s;
			if(nx<=0) nx+=N;
			else if(nx>N) nx-=N;
			if(ny<=0) ny+=N;
			else if(ny>N) ny-=N;
			tmp.add(new FireBall(nx, ny, fb.m, fb.s, fb.d));
		}
		fireBall.addAll(tmp);
//		System.out.println("---move---");
//		System.out.println(fireBall);
	}
}
