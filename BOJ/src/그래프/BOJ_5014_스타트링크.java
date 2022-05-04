package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014_스타트링크 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int F, S, G, U, D, result, cnt;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		
		F=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		G=Integer.parseInt(st.nextToken());
		U=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		result=Integer.MAX_VALUE;
		cnt=0;
		
		if(S==G) System.out.println(0);
		else {
			if(!bfs(S)) System.out.println("use the stairs");
			else System.out.println(cnt-1);
			
		}
	}

	private static boolean bfs(int x) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(x);
		
		boolean []visited=new boolean[F+1];
		visited[x]=true;
		
		while(!queue.isEmpty()) {
			int size=queue.size();
			cnt++;
			while(size-->0) {
				int q=queue.poll();
				if(q==G) return true;
				
				if(q+U<=F && !visited[q+U]) {
					visited[q+U]=true;
					queue.add(q+U);
				}
				if(q-D>0 && !visited[q-D]) {
					visited[q-D]=true;
					queue.add(q-D);
				}
				
			}
		}
		return false;
	}
	
}
