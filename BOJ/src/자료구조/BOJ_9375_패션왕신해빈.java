package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_9375_패션왕신해빈 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int T, N;
	private static HashMap<String, Integer> hm;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;t++) {
			hm=new HashMap<>();
			N=Integer.parseInt(bf.readLine());
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(bf.readLine());
				String first=st.nextToken();
				String second=st.nextToken();
				if(hm.containsKey(second)) hm.put(second, hm.get(second)+1);
				else hm.put(second, 1);
			}
			
			int cnt=1;
			for(String s:hm.keySet()) {
				cnt*=hm.get(s)+1;
			}
			System.out.println(cnt-1);
		}
	}

}
