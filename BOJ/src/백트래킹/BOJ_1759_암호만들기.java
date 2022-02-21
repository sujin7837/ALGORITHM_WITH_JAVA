package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {

	private static int L, C;
	private static List<String> alphas=new ArrayList<>();
	private static List<String> result=new ArrayList<>();
	private static List<String> list=new ArrayList<>();
	private static BufferedReader bf;
	private static StringTokenizer st;
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		L=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		list.add("a");
		list.add("e");
		list.add("i");
		list.add("o");
		list.add("u");
		
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<C;i++) alphas.add(st.nextToken());
		Collections.sort(alphas);
		
		// 입력 확인
//		System.out.println(alphas);
//		System.out.print(vowel);
//		System.out.println();
//		System.out.print(consonant);
		
		combination(L, 1, 2, new String[L], 0);
		
	}

	public static void combination(int toChoose, int toChooseVowel, int toChooseConsonant, String [] choosed, int start) {
		if(toChoose==0) {
			if(toChooseVowel<=0 && toChooseConsonant<=0) {
				{
					String s="";
					for(int i=0;i<choosed.length;i++) s+=choosed[i];
					if(!result.contains(s)) {
						result.add(s);
						System.out.println(s);
					}
					return;
				}
			} else return;
		}
		
		for(int i=start;i<C;i++) {
			choosed[choosed.length-toChoose]=alphas.get(i);
			if(list.contains(alphas.get(i))) {
				combination(toChoose-1, toChooseVowel-1, toChooseConsonant, choosed, i+1);
				combination(toChoose, toChooseVowel, toChooseConsonant, choosed, i+1);
			} else {
				combination(toChoose-1, toChooseVowel, toChooseConsonant-1, choosed, i+1);
				combination(toChoose, toChooseVowel, toChooseConsonant, choosed, i+1);
			}
		}
	}
}
