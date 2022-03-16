package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리멘더링 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, pN, sumPeople=0, result=Integer.MAX_VALUE, checkZero=0;
	private static int [] people;
	private static int [][] graph;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		people=new int[N+1];
		graph=new int[N+1][N+1];
		
		st=new StringTokenizer(bf.readLine());
		for(int i=1;i<=N;i++) {
			people[i]=Integer.parseInt(st.nextToken());
			sumPeople+=people[i];
		}
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(bf.readLine());
			pN=Integer.parseInt(st.nextToken());
			for(int j=0;j<pN;j++) {
				int tmp=Integer.parseInt(st.nextToken());
				graph[i][tmp]=1;
			}
		}
		
		// 입력 확인
//		System.out.println(Arrays.toString(people));
//		for(int []r:graph) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
		
		subSet(N, new boolean[N+1]);
		if(result==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}

	public static void subSet(int toCheck, boolean [] checked) {
		if(toCheck==0) {
			List<Integer> list=new LinkedList<>();
			List<Integer> list2=new LinkedList<>();
			for(int i=1;i<=N;i++) {
				if(checked[i]) list.add(i);
				else list2.add(i);
			}
			if(list.size()==0 || list.size()==N) return;
			if(bfs(list, list.get(0)) && bfs(list2, list2.get(0))) {
				int one=cntPeople(list);
				int two=cntPeople(list2);
				result=Math.min(result, Math.abs(one-two));
			}
			return;
		}
		
		checked[checked.length-toCheck]=true;
		subSet(toCheck-1, checked);
		checked[checked.length-toCheck]=false;
		subSet(toCheck-1, checked);
	}
	
	public static boolean bfs(List<Integer> list, int n) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(n);
		
		boolean [] visited=new boolean[N+1];
		visited[n]=true;
		
		int cnt=1;
		while(!queue.isEmpty()) {
			int now=queue.poll();
			
			for(int i=1;i<=N;i++) {
				if(list.contains(i)) {
					if(!visited[i] && graph[now][i]==1) {
						visited[i]=true;
						cnt++;
						queue.add(i);
					}
				}
			}
		}
		if(cnt==list.size()) return true;
		else return false;
	}
	
	public static int cntPeople(List<Integer> list) {
		int cnt=0;
		for(int i=0;i<list.size();i++) {
			cnt+=people[list.get(i)];
		}
		return cnt;
	}
}
