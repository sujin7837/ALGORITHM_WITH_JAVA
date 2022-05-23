package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2565_전깃줄 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N;
	private static int []dp;
	private static Elec []elec;
	
	static class Elec implements Comparable<Elec> {
		int a, b;

		public Elec(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public String toString() {
			return "Elec [a=" + a + ", b=" + b + "]";
		}

		@Override
		public int compareTo(Elec o) {
			return Integer.compare(this.a, o.a);
		};
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		elec=new Elec[N];
		dp=new int[N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			elec[i]=new Elec(a, b);
		}
		Arrays.sort(elec);
		
		for(int i=0;i<N;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(elec[j].b<elec[i].b) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
		}
		int max=-1;
		for(int i=0;i<N;i++) {
			if(dp[i]>max) max=dp[i];
		}
		System.out.println(N-max);
	}

}
