package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2605_줄세우기 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N;
	private static int [] student;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		student=new int[N+1];
		
		st=new StringTokenizer(bf.readLine());
		for(int i=1;i<=N;i++) student[i]=Integer.parseInt(st.nextToken());
		
		List<Integer> list=new ArrayList<>();
		list.add(1);
		for(int i=2;i<=N;i++) {
			list.add(list.size()-student[i], i);
		}
		
		for(int r:list) System.out.print(r+" ");
	}

}
