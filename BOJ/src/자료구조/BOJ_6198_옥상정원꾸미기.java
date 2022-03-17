package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_6198_옥상정원꾸미기 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N;
	private static long result=0;
	private static int []H;
	private static Stack<Integer> stack=new Stack<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		
		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		H=new int[N];
		
		for(int i=0;i<N;i++)  {
			H[i]=Integer.parseInt(bf.readLine());
		}
		
		for(int i=0;i<N;i++) {
			int h=H[i];
			while(!stack.isEmpty()) {
				int top=stack.pop();
				if(top>h) {
					stack.push(top);
					break;
				}
			}
			result+=stack.size();
			stack.push(h);
		}
		System.out.println(result);
	}

}
