package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904_A와B {

	private static BufferedReader br;
	
	private static String S, T;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		S=br.readLine();
		T=br.readLine();

		for(int i=T.length()-1;i>=S.length();i--) {
			if(T.charAt(i)=='B') {
				T=T.substring(0, i);
				StringBuilder sb=new StringBuilder(T);
				T=sb.reverse().toString();
				
			} else T=T.substring(0, i);
		}
		
//		System.out.println(S);
		if(!S.equals(T)) System.out.println(0);
		else System.out.println(1);
	}

}
