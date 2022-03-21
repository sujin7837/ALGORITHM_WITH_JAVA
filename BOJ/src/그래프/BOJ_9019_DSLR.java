package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019_DSLR {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int T, A, B;
	private static String [] command;

	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(bf.readLine());
		for(int t=0;t<T;t++) {
			st=new StringTokenizer(bf.readLine());
			A=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			command=new String[10001];
			Arrays.fill(command, "");
			
			bfs(A);
			System.out.println(command[B]);
		}
	}

	public static void bfs(int A) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(A);
		
		boolean [] visited=new boolean[10001];
		visited[A]=true;
		
		while(!queue.isEmpty()) {
			int now=queue.poll();
			int D=(2*now>9999?2*now%10000:2*now);
			int S=(now==0?9999:now-1);
			int L=(now%1000)*10+(now/1000);
			int R=(now%10)*1000+(now/10);
			
			if(!visited[D]) {
				visited[D]=true;
				command[D]=command[now]+"D";
				queue.add(D);
			}
			if(!visited[S]) {
				visited[S]=true;
				command[S]=command[now]+"S";
				queue.add(S);
			}
			if(!visited[L]) {
				visited[L]=true;
				command[L]=command[now]+"L";
				queue.add(L);
			}
			if(!visited[R]) {
				visited[R]=true;
				command[R]=command[now]+"R";
				queue.add(R);
			}
		}
	}
}
