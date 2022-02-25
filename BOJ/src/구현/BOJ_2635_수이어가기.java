package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2635_수이어가기 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N;
	private static List<Integer> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		list=new ArrayList<>();
		
		int result=0;
		for(int i=N;i>=N/2;i--) {
			List<Integer> tmp=new ArrayList<>();
			int first=N;
			int second=i;
			int tmpNum=i;
			int cnt=1;
			tmp.add(first);
			tmp.add(second);
			
			while(first-second>=0) {
				tmp.add(first-second);
				second=first-second;
				first=tmpNum;
				tmpNum=second;
			}
			
			if(tmp.size()>result) {
				result=tmp.size();
				list=tmp;
			}
		}
		
		System.out.println(result);
		for(int r:list) System.out.print(r+" ");
	}

}
