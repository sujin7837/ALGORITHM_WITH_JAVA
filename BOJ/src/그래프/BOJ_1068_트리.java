package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1068_트리 {

	private static BufferedReader br;
	private static StringTokenizer st;

	private static int N, root, erase, result;
//	private static int []parent, child;
	private static List<Integer> []list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
//		parent=new int[N];
		list=new ArrayList[N];
		for(int i=0;i<N;i++) list[i]=new ArrayList<>();
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int x=Integer.parseInt(st.nextToken());
			if(x==-1) {
				root=i;
				continue;
			}
			list[x].add(i);
		}
		erase=Integer.parseInt(br.readLine());
		
		remove(erase);
		if(erase==root) result=0;
		else result=findLeaf(root);
		System.out.println(result);
	}

	private static void remove(int x) {
		int size=list[x].size();
		while(size-->0) {
			int get=list[x].get(size);
			remove(get);
		}
		for(int i=0;i<N;i++) {
			if(list[i].contains(x)) {
				list[i].remove(list[i].indexOf(x));
			}
		}
	}
	
	private static int findLeaf(int x) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(x);
		
		int cnt=0;
		while(!queue.isEmpty()) {
			int q=queue.poll();
			if(list[q].size()==0) {
				cnt++;
				continue;
			} else {
				for(int i:list[q]) queue.add(i);
			}
		}
		
		return cnt;
	}
}
