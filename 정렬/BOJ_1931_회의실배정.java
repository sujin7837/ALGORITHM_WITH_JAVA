package 정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1931_회의실배정 {

	private static int N;
	private static int time[][];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		time = new int[N][2];

		for (int i = 0; i < N; i++) {
			time[i][0] = sc.nextInt();
			time[i][1] = sc.nextInt();
		}

		Arrays.sort(time, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) return o1[0]-o2[0];
				return o1[1]-o2[1];
			}
			
		});
		
		// 정렬 체크
//		for(int r[]:time) {
//			for(int c:r) {
//				System.out.print(c+" ");
//			}
//			System.out.println();
//		}
		
		int cnt=1;
		int start=time[0][0];
		int end=time[0][1];
		for(int i=1;i<N;i++) {
			start=time[i][0];
			if(start>=end) {
				cnt++;
				end=time[i][1];
			}
		}
		System.out.println(cnt);
	}

}
