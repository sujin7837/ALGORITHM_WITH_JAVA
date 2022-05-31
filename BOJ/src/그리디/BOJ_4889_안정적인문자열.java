package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_4889_안정적인문자열 {

	private static BufferedReader br;
	private static StringTokenizer st;
	private static Stack<Character> stack;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		String s="";
		int t=0;
		while((s=br.readLine()).charAt(0)!='-') {
			t++;
			stack=new Stack<>();
			int cnt=0;
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='{') {
					stack.add('{');
				} else {
					if(stack.isEmpty()) {
						cnt++;
						stack.add('{');
					}
					else stack.pop();
				}
			}
			cnt+=stack.size()/2;
			System.out.println(t+". "+cnt);
		}
	}

}
