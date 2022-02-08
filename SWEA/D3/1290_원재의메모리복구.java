package swea.d3;

import java.util.Scanner;

public class SWEA_D3_1290_원재의메모리복구하기 {
	private static int T;
	private static String arr[];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		arr=new String[T];
		
		for(int t=0;t<T;t++) {
			arr[t]=sc.next();
			int len=arr[t].length();
			
			int cnt=0;
			char ch='0';
			if(len==1) {
				if(arr[t].charAt(0)!=ch) cnt++;
			} else {
				for(int i=0;i<len;i++) {
					if(arr[t].charAt(i)!=ch) {
						cnt++;
						ch=arr[t].charAt(i);
					}
				}
			}
			System.out.printf("#%d %d\n", t+1, cnt);
		}
	}

}
