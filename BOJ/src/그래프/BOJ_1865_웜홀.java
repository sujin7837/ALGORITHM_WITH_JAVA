package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1865_웜홀 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int TC, N, M, W;
	private static List<Road>[] list;
	private static int [] dist;

	static class Road {
		int to, time;

		public Road(int to, int time) {
			super();
			this.to = to;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Road [to=" + to + ", time=" + time + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		bf=new BufferedReader(new InputStreamReader(System.in));
		TC=Integer.parseInt(bf.readLine());
		for(int t=1;t<=TC;t++) {
			st=new StringTokenizer(bf.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			list=new ArrayList[N+1];
			dist=new int[N+1];
			for(int i=1;i<=N;i++) list[i]=new ArrayList<>();
			
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(bf.readLine());
				int S=Integer.parseInt(st.nextToken());
				int E=Integer.parseInt(st.nextToken());
				int T=Integer.parseInt(st.nextToken());
				list[S].add(new Road(E, T));
				list[E].add(new Road(S, T));
			}
			for(int i=0;i<W;i++) {
				st=new StringTokenizer(bf.readLine());
				int S=Integer.parseInt(st.nextToken());
				int E=Integer.parseInt(st.nextToken());
				int T=Integer.parseInt(st.nextToken());
				list[S].add(new Road(E, -1*T));
			}
			
			// 입력 확인
//			System.out.println(Arrays.toString(list));
			
			if(belmanford()) System.out.println("YES");
			else System.out.println("NO");
		}
	}

	public static boolean belmanford() {
		Arrays.fill(dist, 987654321);
		dist[1]=0;
		boolean isUpdate=false;
		
		for(int i=1;i<N;i++) {
			isUpdate=false;
			for(int j=1;j<=N;j++) {
				for(int k=0;k<list[j].size();k++) {
					if(dist[list[j].get(k).to]>dist[j]+list[j].get(k).time) {
						isUpdate=true;
						dist[list[j].get(k).to]=dist[j]+list[j].get(k).time;
					}
				}
			}
		}
		
		if(isUpdate) {
			for(int j=1;j<=N;j++) {
				for(int k=0;k<list[j].size();k++) {
					if(dist[list[j].get(k).to]>dist[j]+list[j].get(k).time) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
}
