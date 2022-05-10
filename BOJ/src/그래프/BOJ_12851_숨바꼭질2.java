package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851_숨바꼭질2 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, K, min, cnt;
	private static int []dx= {-1,1};
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		min=Integer.MAX_VALUE;
		cnt=0;
		if(N==K) {
			min=0;
			cnt=1;
		} else bfs();
		System.out.println(min);
		System.out.println(cnt);
	}

	private static void bfs() {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(N);
		
		boolean []visited=new boolean[100001];
		visited[N]=true;
		
		boolean find=false;
		int depth=0;
		while(!queue.isEmpty()) {
			int size=queue.size();
//			System.out.println(queue);
			while(size-->0) {
				int q=queue.poll();
				visited[q]=true;
				int nx;
				for(int d=0;d<3;d++) {
					if(d==2) {
						nx=2*q;
					}
					else {
						nx=q+dx[d];
					}
					if(nx==K) {
						find=true;
						cnt++;
					}
					if(nx>=0 && nx<=100000 && !visited[nx]) {
						queue.add(nx);
					}
				}
			}
			depth++;
			if(find) {
				min=depth;
				return;
			}
		}
	}
}
