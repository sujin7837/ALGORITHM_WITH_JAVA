package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16637_괄호추가하기 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, maxVal=Integer.MIN_VALUE;
	private static String S;
	private static List<Integer> nums;
	private static List<Character> ops;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		nums=new ArrayList<>();
		ops=new ArrayList<>();
		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		S=bf.readLine();
		for(int i=0;i<N-2;i+=2) {
			nums.add(S.charAt(i)-'0');
			ops.add(S.charAt(i+1));
		}
		nums.add(S.charAt(N-1)-'0');
		
		dfs(nums.get(0), 0);
		System.out.println(maxVal);
	}

	public static void dfs(int result, int nowIdx) {
		if(nowIdx>=ops.size()) {
			maxVal=Math.max(maxVal, result);
			return;
		}
		int a=operate(result, nums.get(nowIdx+1), ops.get(nowIdx));
		dfs(a, nowIdx+1);
		if(nowIdx+1<ops.size()) {
			int mid=operate(nums.get(nowIdx+1), nums.get(nowIdx+2), ops.get(nowIdx+1));
			int b=operate(result, mid, ops.get(nowIdx));
			dfs(b, nowIdx+2);
		}
	}

	public static int operate(int result, int num, char op) {
		if(op=='+') result+=num;
		else if(op=='-') result-=num;
		else if(op=='*') result*=num;
		return result;
	}
}
