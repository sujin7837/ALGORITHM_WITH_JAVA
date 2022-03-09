package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_5430_AC {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int T, N;
	private static String s;
	private static Deque<Integer> deque;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;t++) {
			deque=new LinkedList<>();
			s=bf.readLine();
			N=Integer.parseInt(bf.readLine());
			
			st=new StringTokenizer(bf.readLine(), "[,]");
			for(int n=0;n<N;n++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			// 입력 확인
//			for(int r:nums) System.out.print(r+" ");
//			System.out.println();
			
			StringBuilder sb=new StringBuilder();
			boolean isError=false;
			boolean isFront=true;
			for(int i=0;i<s.length();i++) {
				char ch=s.charAt(i);
				if(ch=='D') {
					if(deque.size()==0) {
						sb.append("error");
						isError=true;
						break;
					}
					else {
						if(isFront) deque.pollFirst();
						else deque.pollLast();
					}
				} else if(ch=='R') isFront=!isFront;
			}
			if(!isError) {
				sb.append("[");
				if(isFront) {
					while(!deque.isEmpty()) {
						if(deque.size()>1) sb.append(deque.peekFirst()).append(",");
						else sb.append(deque.peekFirst());
						deque.pollFirst();
					}
				} else {
					while(!deque.isEmpty()) {
						if(deque.size()>1) sb.append(deque.peekLast()).append(",");
						else sb.append(deque.peekLast());
						deque.pollLast();
					}
				}
				sb.append("]");
			}
			
			System.out.println(sb);
		}
	}

}
