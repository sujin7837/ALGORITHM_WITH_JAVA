package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_5052_전화번호목록 {

	private static int T, N;
	private static List<String> tel;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(bf.readLine());
		for(int t=0;t<T;t++) {
			tel=new ArrayList<String>();
			N=Integer.parseInt(bf.readLine());
			
			for(int i=0;i<N;i++) tel.add(bf.readLine());
			Collections.sort(tel);
			
			// 정렬 확인
//			for(String s:tel) System.out.println(s);
			
			boolean isNo=false;
			for(int i=0;i<N-1;i++) {
				int len1=tel.get(i).length();
				int len2=tel.get(i+1).length();
				if(len1<len2) {
					if(tel.get(i).equals(tel.get(i+1).substring(0, len1))) {
						isNo=true;
						break;
					}
				}
			}
			if(isNo) System.out.println("NO");
			else System.out.println("YES");
		}
	}

}
