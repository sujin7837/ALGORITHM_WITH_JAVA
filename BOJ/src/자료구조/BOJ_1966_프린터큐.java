package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966_프린터큐 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int T, N, M;
	private static PriorityQueue<Integer> pq;
	private static int [] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;t++) {
			pq=new PriorityQueue<>(Collections.reverseOrder());
			st=new StringTokenizer(bf.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			arr=new int[N];
			
			st=new StringTokenizer(bf.readLine());
			for(int i=0;i<N;i++) {
				int num=Integer.parseInt(st.nextToken());
				pq.offer(num);
				arr[i]=num;
			}
			
			// 입력 확인
//			for(int i=0;i<N;i++) System.out.println(pq.poll());
			
			int result=0, idx=0;
			while(pq.size()>0) {
				int now=pq.poll();
				while(arr[idx]!=now) {
					idx++;
					if(idx==N) idx=0;
				}
//				System.out.println(now+" :: "+idx);
				if(arr[idx]==now) {
					result++;
					if(idx==M) break;
					idx++;
					if(idx==N) idx=0;
				}
			}
			System.out.println(result);
		}
		
	}

}
