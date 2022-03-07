package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662_이중우선순위큐 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int T, K, N;
	private static String s;

	public static void main(String[] args) throws NumberFormatException, IOException {

		bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());

		for (int t = 1; t <= T; t++) {
			TreeMap<Integer, Integer> treeMap=new TreeMap<>();
			K = Integer.parseInt(bf.readLine());
			for (int k = 0; k < K; k++) {
				st=new StringTokenizer(bf.readLine());
				s=st.nextToken();
				N=Integer.parseInt(st.nextToken());
				if(s.equals("I")) {
					treeMap.put(N, treeMap.getOrDefault(N, 0)+1);
				} else {
					if(treeMap.isEmpty()) continue;
					if(N==-1) {
						int minVal=treeMap.firstKey();
						if(treeMap.get(minVal)==1) treeMap.remove(minVal);
						else treeMap.put(minVal, treeMap.get(minVal)-1);
						
					} else {
						int maxVal=treeMap.lastKey();
						if(treeMap.get(maxVal)==1) treeMap.remove(maxVal);
						else treeMap.put(maxVal, treeMap.get(maxVal)-1);
					}
				}
			}
			
			StringBuilder sb=new StringBuilder();
			if(treeMap.isEmpty()) {
				sb.append("EMPTY");
				System.out.println(sb);
			} else {
				if(treeMap.size()==1) {
					int out=treeMap.firstKey();
					sb.append(out).append(" ").append(out);
				}
				else sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey());
				System.out.println(sb);
			}
			
		}

	}
}
