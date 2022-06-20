package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_16120_PPAP {

	private static BufferedReader br;
	
	private static String s;
	private static Stack<Character> stack=new Stack<>();
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		s=br.readLine();

		boolean ppap=true;
		boolean isA=false;
		for(int i=0;i<s.length();i++) {
//			System.out.println(stack+" "+i);
			if(isA) {
				if(s.charAt(i)=='P') {
					stack.add('P');
					isA=false;
					continue;
				}
				else {
					ppap=false;
					break;
				}
			}
			if(s.charAt(i)=='P') stack.add('P');
			else {
				if(stack.size()<2) {
					ppap=false;
					break;
				} else {
					stack.pop();
					stack.pop();
					isA=true;
				}
			}
		}
		if(isA) ppap=false;
		if(stack.size()>1) ppap=false;
		
		if(ppap) System.out.println("PPAP");
		else System.out.println("NP");
	}

}
