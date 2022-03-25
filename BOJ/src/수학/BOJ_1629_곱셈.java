package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629_곱셈 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static long A, B, C, result=1;
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		A=Long.parseLong(st.nextToken());
		B=Long.parseLong(st.nextToken());
		C=Long.parseLong(st.nextToken());
		
		result=multiple(A, B);
		System.out.println(result);
	}

	public static long multiple(long a, long b) {
		if(b==1) return a%C;
		
		long mid=multiple(a, b/2);
		mid=mid*mid%C;
		if(b%2==0) return mid;
		else return mid*a%C;
	}
}
