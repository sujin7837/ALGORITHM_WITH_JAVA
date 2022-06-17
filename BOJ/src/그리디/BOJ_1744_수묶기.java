package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1744_수묶기 {

	private static BufferedReader br;
	
	private static int N;
	private static List<Integer> list=new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) list.add(Integer.parseInt(br.readLine()));
		Collections.sort(list);
		
		int cnt=0;
		int begin=0, end=N-1;
		long result=0;
		while(begin<=end) {
//			System.out.println(result+" "+begin+" "+end);
			int comp1=0, comp2=0;
			if(begin==end) {
				result+=list.get(begin);
				break;
			}
			if(begin+1<=end) {
				int s1=list.get(begin);
				int s2=list.get(begin+1);
				if(s1*s2<0) {
					result+=s1;
					begin++;
				} else if(s1*s2==0 && (s1<0 || s2<0)) {
					begin+=2;
				} else {
					if(s1==1 || s2==1) {
						result+=s1;
						begin++;
					} else comp1=s1*s2;
				}
			}
			if(end-1>=begin) {
				int e1=list.get(end-1);
				int e2=list.get(end);
				if(e1*e2<=0) {
					result+=e2;
					end--;
				} else if(e1*e2==0 && (e1<0 || e2<0)) {
					end-=2;
				} else {
					if(e1==1 || e2==1) {
						result+=e2;
						end--;
					} else comp2=e1*e2;
				}
			}
			if(comp1>0 || comp2>0) {
				if(comp1>comp2) {
					result+=comp1;
					begin+=2;
				} else {
					result+=comp2;
					end-=2;
				}
			}
		}
		
		System.out.println(result);
	}

}
