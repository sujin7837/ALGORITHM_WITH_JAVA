package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1963_소수경로 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int T;
	private static String from, to;

	static class Number {
		String from;
		int cnt;

		public Number(String from, int cnt) {
			super();
			this.from = from;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Number [from=" + from + ", cnt=" + cnt + "]";
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			from=st.nextToken();
			to=st.nextToken();
			int result=bfs();
			if(result==-1) System.out.println("Impossible");
			else System.out.println(result);
		}
	}

	private static int bfs() {
		Queue<Number> queue=new LinkedList<>();
		queue.add(new Number(from, 0));
		
		boolean []visited=new boolean[10000];
		visited[Integer.parseInt(from)]=true;
		
		while(!queue.isEmpty()) {
			int size=queue.size();
			while(size-->0) {
				Number n=queue.poll();
//				System.out.println(n);
				
				if(n.from.equals(to)) return n.cnt;
				for(int i=0;i<4;i++) {
					for(int j=0;j<=9;j++) {
						if(j==0 && i==0) continue;
						String s=n.from.substring(0, i)+(j+"");
						if(i<3) s+=n.from.substring(i+1);
						if(isPrime(s) && !visited[Integer.parseInt(s)]) {
							visited[Integer.parseInt(s)]=true;
//						System.out.println(s);
							queue.add(new Number(s, n.cnt+1));
						}
					}
				}
			}
		}
		
		return -1;
	}
	
	private static boolean isPrime(String s) {
		int num=Integer.parseInt(s);
		for(int i=2;i<=(int)Math.sqrt(num);i++) {
			if(num%i==0) return false;
		}
		return true;
	}
}
