package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_18870_좌표압축 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N;
	private static int [] nums, sortNums;
	private static HashMap<Integer, Integer> hm=new HashMap<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		nums=new int[N];
		sortNums=new int[N];
		
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			sortNums[i]=nums[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sortNums);
		
		int rank=0;
		for(int i=0;i<N;i++) {
			if(!hm.containsKey(sortNums[i])) {
				hm.put(sortNums[i], rank++);
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(hm.get(nums[i])).append(' ');
		}
		
		System.out.println(sb);
		
//		for(int i=0;i<N;i++) {
//			System.out.print(hm.get(nums[i])+" ");
//		}
	}

}
