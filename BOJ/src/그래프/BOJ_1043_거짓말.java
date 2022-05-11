package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1043_거짓말 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, M, NUM;
	private static int []parent;
	private static List<Integer> knows=new ArrayList<>();
	private static List<Integer> []list;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		parent=new int[N+1];
		for(int i=1;i<=N;i++) parent[i]=i;
		
		list=new ArrayList[M];	// 파티에 온 사람들
		for(int i=0;i<M;i++) list[i]=new ArrayList<>();
				
		st=new StringTokenizer(br.readLine());
		NUM=Integer.parseInt(st.nextToken());
		if(NUM>0) {
			for(int i=0;i<NUM;i++) {
				int person=Integer.parseInt(st.nextToken());
				knows.add(person);
			}
			int root=knows.get(0);
			for(int i=1;i<knows.size();i++) {
				union(root, knows.get(i));
			}
			
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				int num=Integer.parseInt(st.nextToken());
				if(num==0) continue;
				root=Integer.parseInt(st.nextToken());
				list[i].add(root);
				while(--num>0) {
					int a=Integer.parseInt(st.nextToken());
					union(a, root);
					list[i].add(a);	// i번 파티에 온 사람들
				}
			}
			
			for(int i=0;i<M;i++) {
				for(int x:knows) {
					if(list[i].contains(x)) {
						for(int y:list[i]) {
							union(y, x);
						}
						break;
					}
				}
			}
			
//			for(int i=1;i<=N;i++) {
//				System.out.print(findParent(i)+" ");
//			}
			int cnt=0;
			root=findParent(knows.get(0));
			for(int i=0;i<M;i++) {
				if(findParent(list[i].get(0))!=root) cnt++;
			}
			System.out.println(cnt);
		} else System.out.println(M);
	}

	private static int findParent(int x) {
		if(parent[x]==x) return x;
		return parent[x]=findParent(parent[x]);
	}
	private static void union(int a, int b) {
		int A=findParent(a);
		int B=findParent(b);
		if(A==B) return;
		parent[B]=A;
	}

}
