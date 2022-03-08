package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_뱀과사다리게임 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M;
	private static int [] map, visited;
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[101];
		visited=new int[101];
		
		for(int i=1;i<=100;i++) map[i]=i;
		for(int i=1;i<=100;i++) visited[i]=-1;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(bf.readLine());
			map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		
		bfs(1);
		System.out.println(visited[100]);
	}

	public static void bfs(int start) {
		Queue<Integer> queue=new LinkedList<>();
		queue.offer(start);
		visited[start]=0;
		
		while(!queue.isEmpty()) {
			int now=queue.poll();
			
			for(int i=1;i<=6;i++) {
				int moveTo=now+i;
				if(moveTo>100) continue;
				moveTo=map[moveTo];
				
				if(visited[moveTo]==-1) {
					visited[moveTo]=visited[now]+1;
					queue.offer(moveTo);
				}
			}
			
		}
	}
}
