package 문자열;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_3048 {

	private static int N1, N2, T;
	private static String s1;
	private static String s2;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N1=sc.nextInt();
		N2=sc.nextInt();
		
		s1=sc.next();
		s2=sc.next();
		int lenS1=s1.length();
		int lenS2=s2.length();
		int biggerLen=Math.max(lenS1, lenS2);
		
		List<Integer> arr=new ArrayList<>();
		for(int i=0;i<N1;i++) arr.add(1);
		for(int i=0;i<N2;i++) arr.add(0);
		String result="";
		T=sc.nextInt();
		if(T>=lenS1+lenS2) {
			for(int i=0;i<s2.length();i++) result+=s2.charAt(i);
			for(int i=s1.length()-1;i>=0;i--) result+=s1.charAt(i);
		} else {
			for(int i=0;i<T;i++) {
				for(int start=1;start<arr.size();start++) {
					if(arr.get(start-1)>arr.get(start)) {
						arr.set(start-1, 0);
						arr.set(start, 1);
						start++;
					}
				}
			}
//			System.out.println(arr);
			int idxS1=lenS1-1;
			int idxS2=0;
			for(int i=0;i<arr.size();i++) {
				if(arr.get(i)==1) {
					result+=s1.charAt(idxS1--);
				} else if(arr.get(i)==0) {
					result+=s2.charAt(idxS2++);
				}
			}
		}
		System.out.println(result);
	}
}
