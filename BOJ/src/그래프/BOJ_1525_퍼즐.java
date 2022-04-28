package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1525_퍼즐 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static String map;
	private static String result="123456780";
	private static Map<String, Integer> m=new HashMap<>();
	private static int []dx= {-1,1,0,0};
	private static int []dy= {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		map="";
		for(int r=0;r<3;r++) {
			st=new StringTokenizer(br.readLine());
			for(int c=0;c<3;c++) {
				map+=st.nextToken();
			}
		}
		m.put(map, 0);
		int ans=bfs(map);
		System.out.println(ans);
	}

	private static int bfs(String s) {
		Queue<String> queue=new LinkedList<>();
		queue.add(s);
		
		while(!queue.isEmpty()) {
//			System.out.println(queue);
			String q=queue.poll();
			int zero=q.indexOf('0');
			int r=zero%3;
			int c=zero/3;
			
			if(q.equals(result)) return m.get(q);
			for(int d=0;d<4;d++) {
				int nx=r+dx[d];
				int ny=c+dy[d];
				
				if(isIn(nx, ny)) {
					int pos=nx+ny*3;
					char ch=q.charAt(pos);
					String tmp=q.replace(ch, 'a');
//					System.out.println(ch);
					tmp=tmp.replace('0', ch);
					tmp=tmp.replace('a', '0');
//					System.out.println("tmp: "+tmp);
					if(!m.containsKey(tmp)) {
						m.put(tmp, m.get(q)+1);
						queue.add(tmp);
					}
				}
			}
		}
		return -1;
	}
	
	
	private static boolean isIn(int r, int c) {
		return r>=0 && r<3 && c>=0 && c<3;
	}
	
}
