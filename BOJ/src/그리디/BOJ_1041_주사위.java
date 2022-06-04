package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1041_주사위 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static long N, result;
	private static long []dice=new long[6];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<6;i++) {
			dice[i]=Long.parseLong(st.nextToken());
		}
		
		result=0;
		if(N==1) {	// 크기가 1일 때
			Arrays.sort(dice);
			for(int i=0;i<5;i++) result+=dice[i];
		} else {	// 크기가 1보다 클 때
			// 한 면
			long val=Long.MAX_VALUE;
			for(long x:dice) {
				if(x<val) val=x;
			}
			long one=(N-2)*(5*N-6)*val;
			
			// 두 면
			val=Long.MAX_VALUE;
			val=Math.min(Math.min(dice[0]+dice[1], dice[1]+dice[5]), Math.min(dice[0]+dice[4], dice[4]+dice[5]));
			long tmp=Math.min(dice[2], dice[3]);
			val=Math.min(Math.min(dice[0]+tmp, dice[1]+tmp), val);
			val=Math.min(Math.min(dice[4]+tmp, dice[5]+tmp), val);
			long two=(8*N-12)*val;
			
			// 세 면
			val=Long.MAX_VALUE;
			val=Math.min(Math.min(dice[0]+dice[1], dice[1]+dice[5]), Math.min(dice[0]+dice[4], dice[4]+dice[5]));
			val+=tmp;
			long three=4*val;
			
			result=one+two+three;
		}
		
		System.out.println(result);
	}
}
