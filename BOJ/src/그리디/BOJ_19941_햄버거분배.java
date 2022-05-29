package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19941_햄버거분배 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, K, result=0;
	private static String s;
	private static boolean []visited;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		s=br.readLine();
	
		visited=new boolean[N];
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='P') {
				for(int j=i-K;j<=i+K;j++) {
					if(j>=N) break;
					if(j<0 || i==j || visited[j]) continue;
					if(s.charAt(j)=='H') {
						visited[j]=true;
						result++;
						break;
					}
				}
			}
		}
		
		System.out.println(result);
	}

}
