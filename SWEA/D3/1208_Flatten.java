package swea.d3;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_D3_1208_Flatten {

	private static int D;
	private static int H[]=new int[100];
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		for(int t=0;t<10;t++) {
			D=sc.nextInt();
			for(int h=0;h<100;h++) H[h]=sc.nextInt();
			
			// 입력 확인
//			for(int r:H) System.out.print(r+" ");
			
			for(int i=0;i<D;i++) {
				Arrays.sort(H);
				H[99]--;
				H[0]++;
			}
			Arrays.sort(H);
			
			int result=H[99]-H[0];
			System.out.printf("#%d %d\n", t+1, result);
			
		}
	}

}
