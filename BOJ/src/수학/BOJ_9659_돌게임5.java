package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9659_돌게임5 {

	private static BufferedReader br;
	
	private static long N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Long.parseLong(br.readLine());
		if(N%2==0) System.out.println("CY");
		else System.out.println("SK");
	}

}
