package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869_달팽이는올라가고싶다 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int A, B, V;
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		A=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		V=Integer.parseInt(st.nextToken());
		
		int snail=A;
		long days=1L;
		if(snail<V) {
			days+=(V-snail)/(-B+A);
			if((V-snail)%(-B+A)>0) days+=1;;
		}
		
		System.out.println(days);
	}

}
