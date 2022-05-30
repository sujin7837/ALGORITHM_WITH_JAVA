package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1105_팔 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static String l, r;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		l=st.nextToken();
		r=st.nextToken();
		
		int result=0;
		if(l.length()==r.length()) {
			for(int i=0;i<l.length();i++) {
				if(l.charAt(i)=='8' && r.charAt(i)=='8') result++;
				else if(l.charAt(i)!=r.charAt(i)) break;
			}
		}
		
		System.out.println(result);
	}

}
