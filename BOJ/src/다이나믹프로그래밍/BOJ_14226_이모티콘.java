package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14226_이모티콘 {

	private static BufferedReader br;
	
	private static int S;
	
	static class State {
		int viewCnt, clipCnt, time;

		public State(int viewCnt, int clipCnt, int time) {
			super();
			this.viewCnt = viewCnt;
			this.clipCnt = clipCnt;
			this.time = time;
		}

		@Override
		public String toString() {
			return "State [viewCnt=" + viewCnt + ", clipCnt=" + clipCnt + ", time=" + time + "]";
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		S=Integer.parseInt(br.readLine());
		
		int result=bfs();
		System.out.println(result);
	}

	private static int bfs() {
		Queue<State> queue=new LinkedList<>();
		queue.add(new State(1, 0, 0));
		
		boolean [][]visited=new boolean[10001][10001];
		visited[1][0]=true;
		
		while(!queue.isEmpty()) {
			State state=queue.poll();
			if(state.viewCnt==S) return state.time;
			if(state.viewCnt!=state.clipCnt && !visited[state.viewCnt][state.viewCnt]) {	// 1
				visited[state.viewCnt][state.viewCnt]=true;
				queue.add(new State(state.viewCnt, state.viewCnt, state.time+1));
			}
			if(!visited[state.viewCnt+state.clipCnt][state.clipCnt]) {	// 2
				visited[state.viewCnt+state.clipCnt][state.clipCnt]=true;
				queue.add(new State(state.viewCnt+state.clipCnt, state.clipCnt, state.time+1));
			}
			if(state.viewCnt-1>0 && !visited[state.viewCnt-1][state.clipCnt]) {	// 3
				visited[state.viewCnt-1][state.clipCnt]=true;
				queue.add(new State(state.viewCnt-1, state.clipCnt, state.time+1));
			}
		}
		
		return 0;
	}
}
