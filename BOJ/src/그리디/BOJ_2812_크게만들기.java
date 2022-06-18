package 그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2812_크게만들기 {

	private static BufferedReader br;
	private static BufferedWriter bw;
	private static StringTokenizer st;
	
	private static int N, K;
	private static String num;
	private static Deque<Character> store=new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		bw=new BufferedWriter(new OutputStreamWriter(System.out));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		num=br.readLine();
		
		int n=0;
		for(int i=0;i<N;i++) {
			while(n<K && !store.isEmpty() && store.getFirst()<num.charAt(i)) {
				store.removeFirst();
				n++;
			}
			store.addFirst(num.charAt(i));
		}
		
//		String result="";
//		while(!store.isEmpty()) result+=store.pollLast();

//		System.out.println(result);
		StringBuilder sb=new StringBuilder();
		while(store.size()>K-n) sb.append(store.removeLast());
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
