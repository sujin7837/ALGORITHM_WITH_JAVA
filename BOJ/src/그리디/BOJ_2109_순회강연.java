package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2109_순회강연 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N;
	private static Class []classes;
	private static boolean []check=new boolean[10001];
	
	static class Class implements Comparable<Class> {
		int p, d;

		public Class(int p, int d) {
			super();
			this.p = p;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Class [p=" + p + ", d=" + d + "]";
		}

		@Override
		public int compareTo(Class o) {
			return Integer.compare(o.p, this.p);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		classes=new Class[N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int p=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			classes[i]=new Class(p, d);
		}
		Arrays.sort(classes);
//		for(Class c:classes) System.out.println(c);
		
		int money=0;
		int idx=1;
		for(int i=0;i<N;i++) {
			int d=classes[i].d;
			if(!check[d]) {
				money+=classes[i].p;
				check[d]=true;
				if(d==idx) idx++;
				continue;
			}
			while(check[d] && d>=idx) {
				d--;
			}
			if(d>=idx) {
				money+=classes[i].p;
				check[d]=true;
				if(d==idx) idx++;
			}
		}
		
		System.out.println(money);
	}

}
