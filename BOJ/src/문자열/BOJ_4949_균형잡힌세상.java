package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949_균형잡힌세상 {

	private static BufferedReader bf;
	
	private static String s;
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack=new Stack<>();
		while(true) {
			s=bf.readLine();
			String result="yes";
			if(s.equals(".")) break;
			stack=new Stack<>();
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='(') stack.add("(");
				if(s.charAt(i)=='[') stack.add("[");
				if(s.charAt(i)==')') {
					if(stack.isEmpty()) {
//						System.out.println("1-1");
						result="no";
						break;
					}
					String now=stack.pop();
					if(!now.equals("(")) {
//						System.out.println("1-2");
						result="no";
					}
				}
				if(s.charAt(i)==']') {
					if(stack.isEmpty()) {
//						System.out.println("2-1");
						result="no";
						break;
					}
					String now=stack.pop();
//					System.out.println(now);
					if(!now.equals("[")) {
//						System.out.println("2-2 : "+i);
						result="no";
					}
				}
			}
			if(stack.size()!=0) {
//				System.out.println("3");
				result="no";
			}
			System.out.println(result);
		}
		
	}

}
