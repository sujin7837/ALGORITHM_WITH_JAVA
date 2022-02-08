package 정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1431_시리얼번호 {

	private static int N;
	private static String serialNum[];
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		serialNum=new String[N];
		for(int i=0;i<N;i++) {
			serialNum[i]=sc.next();
		}
		Arrays.sort(serialNum, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()!=o2.length()) return o1.length() - o2.length();
				else {
					int o1Num=0;
					int o2Num=0;
					for(int i=0;i<o1.length();i++) {
						if(Character.isDigit(o1.charAt(i))) o1Num+=o1.charAt(i)-'0';
					}
					for(int i=0;i<o2.length();i++) {
						if(Character.isDigit(o2.charAt(i))) o2Num+=o2.charAt(i)-'0';
					}
					if(o1Num!=o2Num) return o1Num-o2Num;
					else return o1.compareTo(o2);
				}
			}
			
		});
		
		for(String s:serialNum) System.out.println(s);
	}

}
