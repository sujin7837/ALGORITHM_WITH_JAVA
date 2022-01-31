package 문자열;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_개미 {

	private static int N1, N2, T;
	private static char arr1[];
	private static char arr2[];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N1=sc.nextInt();
		N2=sc.nextInt();
		arr1=new char[N1];
		arr2=new char[N2];
		String s1=sc.next();
//		System.out.println(s1);
		for(int i=0;i<N1;i++) {
			arr1[i]=s1.charAt(i);
		}
		String s2=sc.next();
		for(int i=0;i<N2;i++) {
			arr2[i]=s2.charAt(i);
		}
		T=sc.nextInt();
		int now1=-1;
		int now2=-1;
		
		for(int i=0;i<T;i++) {
		}
	}
	
	static class Ant {
		String dir;
		int N;
		char ant[];
		
		public Ant(String dir, int n, char[] ant) {
			super();
			this.dir = dir;
			N = n;
			this.ant = ant;
		}

		@Override
		public String toString() {
			return "Ant [dir=" + dir + ", N=" + N + ", ant=" + Arrays.toString(ant) + "]";
		}
	}

}
