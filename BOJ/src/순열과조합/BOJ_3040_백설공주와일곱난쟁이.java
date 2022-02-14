package 순열과조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3040_백설공주와일곱난쟁이 {

	private static int [] nums;
	private static int tmp=0;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		nums=new int[9];
		for(int i=0;i<9;i++) {
			nums[i]=Integer.parseInt(bf.readLine());
		}
		
		combination(7, new int[7], 0);
	}

	public static void combination(int toCheck, int [] choosed, int start) {
		if(toCheck==0) {
			tmp=0;
			for(int i=0;i<7;i++) tmp+=choosed[i];
			if(tmp==100) {
				for(int r:choosed) System.out.println(r);
				return;
			}
			return;
		}
		
		for(int i=start;i<9;i++) {
			choosed[choosed.length-toCheck]=nums[i];
			combination(toCheck-1, choosed, i+1);
		}
	}
}
