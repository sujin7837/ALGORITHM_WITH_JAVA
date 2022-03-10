package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1021_회전하는큐 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M;
	private static int [] arr;
	private static Deque<Integer> deque;
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[M+1];
		deque=new LinkedList<>();
		
		st=new StringTokenizer(bf.readLine());
		for(int i=1;i<=M;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) deque.add(i);
		
		int cnt=0;
		for(int i=1;i<=M;i++) {
			int cntF=0, cntB=0;
			int front=deque.pollFirst();
			while(front!=arr[i]) {
				deque.addLast(front);
				front=deque.pollFirst();
				cntF++;
			}
			cntB=deque.size()-cntF+1;
			if(cntF<=cntB) cnt+=cntF;
			else cnt+=cntB;
		}
		
		System.out.println(cnt);
	}

}
