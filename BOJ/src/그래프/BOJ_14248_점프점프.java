package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14248_점프점프 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, S;
	private static int []stones;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		stones=new int[N+1];
		
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) stones[i]=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(br.readLine());
		
		System.out.println(bfs(S));
	}

	private static int bfs(int x) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(x);
		
		boolean []visited=new boolean[N+1];
		visited[x]=true;
		
		while(!queue.isEmpty()) {
			int q=queue.poll();
			
			if(q-stones[q]>=1 && !visited[q-stones[q]]) {
				visited[q-stones[q]]=true;
				queue.add(q-stones[q]);
			}
			if(q+stones[q]<=N && !visited[q+stones[q]]) {
				visited[q+stones[q]]=true;
				queue.add(q+stones[q]);
			}
		}
		
		int cnt=0;
		for(int i=1;i<=N;i++) {
			if(visited[i]) cnt++;
		}
		return cnt;
	}
}
