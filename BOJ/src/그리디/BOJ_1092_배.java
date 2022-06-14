package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1092_배 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, M;
	private static List<Integer> limits, weights;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		limits=new ArrayList<>();
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) limits.add(Integer.parseInt(st.nextToken()));
		Collections.sort(limits, Collections.reverseOrder());
		
		M=Integer.parseInt(br.readLine());
		weights=new ArrayList<>();
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) weights.add(Integer.parseInt(st.nextToken()));
		Collections.sort(weights, Collections.reverseOrder());
		
		if(limits.get(0)<weights.get(0)) System.out.println(-1);
		else {
			int count=0;
			while(weights.size()>0) {
				int idx=0;
				for(int i=0;i<N;) {
					if(limits.get(i)>=weights.get(idx)) {
						weights.remove(idx);
						i++;
					} else idx++;
					if(idx==weights.size()) break;
				}
				count++;
			}
			
			System.out.println(count);
		}
	}

}
