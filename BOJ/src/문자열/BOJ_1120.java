package 문자열;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1120 {
	
	private static String a=null;
	private static String b=null;
	private static int diff[];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		a=sc.next();
		b=sc.next();
		
		int lenA=a.length();
		int lenB=b.length();
		diff=new int[lenB-lenA+1];
//		System.out.println(a+" "+b);
//		System.out.println("lenA: "+lenA+" lenB: "+lenB);
		for(int start=0;start<=lenB-lenA;start++) {
			int idx=0;
			for(int i=start;i<start+lenA;i++) {
				if(a.charAt(idx++)!=b.charAt(i)) diff[start]++;
			}
		}
		Arrays.sort(diff);
//		for(int d:diff) System.out.println(d);
		System.out.println(diff[0]);
	}

}
