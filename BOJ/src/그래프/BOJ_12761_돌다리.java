package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12761_돌다리 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int A, B, N, M, cnt;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		A=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		cnt=0;
		bfs(N, M);
		System.out.println(cnt);
	}

	private static void bfs(int n, int m) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(n);
		
		boolean[] visited=new boolean[100001];
		visited[n]=true;
		int []dx= {-1,1,-1*A, A, -1*B, B};
		
		while(!queue.isEmpty()) {
//			System.out.println(queue);
			int size=queue.size();
			
			while(size-->0) {
				int q=queue.poll();
				
				if(q==m) return;
				for(int d=0;d<6;d++) {
					int nx=q+dx[d];
					if(isIn(nx) && !visited[nx]) {
						visited[nx]=true;
						queue.add(nx);
					}
				}
				
				int a=q*A;
				int b=q*B;
//			System.out.println(a+" "+b);
				if(isIn(a) && !visited[a]) {
					visited[a]=true;
					queue.add(a);
				}
				if(isIn(b) && !visited[b]) {
					visited[b]=true;
					queue.add(b);
				}
			}
			cnt++;
		}
	}
	
	private static boolean isIn(int x) {
		return x>=0 && x<=100000;
	}
}
