package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_1339_단어수학 {

	private static BufferedReader br;
	
	private static int N;
	private static String []s;
	private static Map<Character, Integer> map=new HashMap<>();
	
	static class Value implements Comparable<Value> {
		char alpha;
		int num;
		
		public Value(char alpha, int num) {
			super();
			this.alpha = alpha;
			this.num = num;
		}

		
		@Override
		public String toString() {
			return "Value [alpha=" + alpha + ", num=" + num + "]";
		}


		@Override
		public int compareTo(Value o) {
			return Integer.compare(o.num, this.num);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		s=new String[N];
		
		for(int i=0;i<N;i++) s[i]=br.readLine();
		Arrays.sort(s, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				return -1*(o1.length()-o2.length());
			}
			
		});
		
		List<Value> list=new ArrayList<>();
		for(int i=0;i<s[0].length();i++) {
			for(String ss:s) {
				if(ss.length()>i) {
					map.putIfAbsent(ss.charAt(ss.length()-1-i), 0);
					map.put(ss.charAt(ss.length()-1-i), map.get(ss.charAt(ss.length()-1-i))+(int) Math.pow(10, i));
				}
			}
		}
		
		for(Character c:map.keySet()) {
			list.add(new Value(c, map.get(c)));
		}
		
		Collections.sort(list);
//		System.out.println(list.toString());
		int sum=0;
		int num=9;
		for(int i=0;i<list.size();i++) {
			sum+=list.get(i).num*num;
			num--;
		}
		
		System.out.println(sum);
	}

}
