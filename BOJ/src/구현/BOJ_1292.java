package 구현;

import java.util.Scanner;

public class BOJ_1292 {
	private static int A, B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		int cnt=0;
		int start=0;
		int now=0;
		while(cnt<=B) {
			for(int i=1;i<=start;i++) {
				cnt++;	
				if(cnt>=A) {
					if(cnt>B) break;
					now+=start;
				}
			}
			start++;
		}
		System.out.println(now);
	}
}

