package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2309_일곱난쟁이 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int [] arr=new int[9];
	private static int [] result=new int[7];
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<9;i++) arr[i]=Integer.parseInt(bf.readLine());
		combination(7, new int[7], 0);
		Arrays.sort(result);
		for(int r:result) System.out.println(r);
	}

	public static void combination(int toChoose, int [] choosed, int start) {
		if(toChoose==0) {
			int sum=0;
			for(int r:choosed) sum+=r;
			if(sum==100) result=Arrays.copyOf(choosed, choosed.length);
			return;
		}
		
		for(int i=start;i<9;i++) {
			choosed[choosed.length-toChoose]=arr[i];
			combination(toChoose-1, choosed, i+1);
		}
	}
}
