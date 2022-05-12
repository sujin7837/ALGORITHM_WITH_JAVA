package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, M;
	private static int []parent;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		parent=new int[N+1];
		for(int i=1;i<=N;i++) parent[i]=i;
		
		for(int r=1;r<=N;r++) {
			st=new StringTokenizer(br.readLine());
			for(int c=1;c<=N;c++) {
				int get=Integer.parseInt(st.nextToken());
				if(get==1) union(r, c);
			}
		}
		st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		boolean poss=true;
		for(int i=1;i<M;i++) {
			int b=Integer.parseInt(st.nextToken());
			if(findParent(a)!=findParent(b)) {
				poss=false;
				break;
			}
		}
		if(poss) System.out.println("YES");
		else System.out.println("NO");
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
