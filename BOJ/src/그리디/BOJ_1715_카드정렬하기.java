package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715_카드정렬하기 {

	private static BufferedReader br;
	
	private static int N;
	private static PriorityQueue<Integer> pq=new PriorityQueue<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) pq.add(Integer.parseInt(br.readLine()));
		int result=0;
		while(pq.size()>=2) {
			int a=pq.poll();
			int b=pq.poll();
			result+=a+b;
			pq.add(a+b);
		}
		
		System.out.println(result);
	}

}
