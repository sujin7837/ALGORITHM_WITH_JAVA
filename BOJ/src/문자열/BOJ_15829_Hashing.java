package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15829_Hashing {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int L;
	private static char [] ch;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		L=Integer.parseInt(bf.readLine());
		ch=new char[L];
		
		ch=bf.readLine().toCharArray();
		long tmp=0, powN=1;
		for(int i=0;i<L;i++) {
			powN=1;
			for(int j=0;j<i;j++) {
				powN*=31;
				powN%=1234567891;
			}
			tmp+=(long) (((int)ch[i]-96)*powN);
			tmp%=1234567891;
		}
		
		System.out.println(tmp);
		
	}

}
