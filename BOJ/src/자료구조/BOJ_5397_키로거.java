package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_5397_키로거 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int T, N;
	private static String S;
	private static Stack<Character> pre;
	private static Stack<Character> post;

	public static void main(String[] args) throws NumberFormatException, IOException {

		bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		for (int t = 0; t < T; t++) {
			pre=new Stack<>();
			post=new Stack<>();
			S = bf.readLine();
			N=S.length();
			for(int i=0;i<N;i++) {
				if(S.charAt(i)=='<') {
					if(!pre.isEmpty()) {
						char x=pre.pop();
						post.push(x);
					}
				} else if(S.charAt(i)=='>') {
					if(!post.isEmpty()) {
						char x=post.pop();
						pre.push(x);
					}
					
				} else if(S.charAt(i)=='-') {
					if(!pre.isEmpty()) {
						pre.pop();
					}
				} else {
					pre.push(S.charAt(i));
				}
			}
			
			StringBuilder sb=new StringBuilder();
			
			while(!post.isEmpty()) pre.push(post.pop());
			for(int i=0;i<pre.size();i++) sb.append(pre.elementAt(i));
			System.out.println(sb);
		}
	}

}
