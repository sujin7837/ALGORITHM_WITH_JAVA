package 문자열;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_1141 {

	private static int N;
	private static List<String> list=new ArrayList<>();
	private static List<String> check=new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		for(int i=0;i<N;i++) {
			list.add(sc.next());
		}
		Collections.sort(list);
//		System.out.println(list);
		check.add(list.get(N-1));
		
		for(int i=N-2;i>=0;i--) {
//			System.out.println(check);
			boolean isIn=true;
			for(String s:check) {
				isIn=true;
				if(s.contains(list.get(i))) {
					for(int l=0;l<list.get(i).length();l++) {
//						System.out.println("? isIn : "+isIn);
						if(s.charAt(l)!=list.get(i).charAt(l)) {
//							System.out.println("???");
							isIn=false;
							break;
						}
					}
				} else isIn=false;
			}
			if(!isIn) check.add(list.get(i)); 
		}
//		System.out.println(check);
		System.out.println(check.size());
	}

}
