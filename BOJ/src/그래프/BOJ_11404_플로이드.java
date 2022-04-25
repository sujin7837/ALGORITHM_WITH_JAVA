package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11404_플로이드 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, M;
	private static int [][]graph;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		graph=new int[N+1][N+1];
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) graph[r][c]=Integer.MAX_VALUE;
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			if(graph[a][b]!=Integer.MAX_VALUE) graph[a][b]=Math.min(graph[a][b], c);
			else graph[a][b]=c;
		}
		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				if(k==i) continue;
				for(int j=1;j<=N;j++) {
					if(k==j || i==j) continue;
//					System.out.println("i: "+i+" j: "+j+" k: "+k+" "+graph[i][j]);
					if(graph[i][k]!=Integer.MAX_VALUE && graph[k][j]!=Integer.MAX_VALUE) graph[i][j]=Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
		
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) System.out.print((graph[r][c]==Integer.MAX_VALUE?0:graph[r][c])+" ");
			System.out.println();
		}
	}

}
