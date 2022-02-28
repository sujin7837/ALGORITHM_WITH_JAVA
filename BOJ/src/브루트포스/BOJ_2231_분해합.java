package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2231_분해합 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N;
	private static List<Integer> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		
		int result=0;
		for(int i=1;i<N;i++) {
			int num=i, sum=i;
			while(num>0) {
				sum+=num%10;
				num/=10;
			}
			if(sum==N) {
				result=i;
				break;
			}
		}
		System.out.println(result);
	}

}
