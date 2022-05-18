package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9184_신나는함수실행 {
	private static int [][][]dp=new int[21][21][21];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			if(a==-1 && b==-1 && c==-1) break;
			
			int result=dfs(a, b, c);
			System.out.println("w("+a+", "+b+", "+c+") = "+result);
		}
		
	}

	private static int dfs(int a, int b, int c) {
		if(a<=0 || b<=0 || c<=0) return 1;
		if(a>20 || b>20 || c>20) return dp[20][20][20]=dfs(20, 20, 20);
		if(dp[a][b][c]!=0) return dp[a][b][c];
		
		if(a<b && b<c) return dp[a][b][c]= dfs(a, b, c-1)+dfs(a, b-1, c-1)-dfs(a, b-1, c);
		return dp[a][b][c]=dfs(a-1, b, c)+dfs(a-1, b-1, c)+dfs(a-1, b, c-1)-dfs(a-1, b-1, c-1);
	}
}
