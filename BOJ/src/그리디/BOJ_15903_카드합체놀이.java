package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_15903_카드합체놀이 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, M;
	private static PriorityQueue<Long> pq=new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) pq.add(Long.parseLong(st.nextToken()));
		for(int i=0;i<M;i++) {
			long get1=pq.poll();
			long get2=pq.poll();
			long sum=get1+get2;
			pq.add(sum);
			pq.add(sum);
		}
		
		long result=0;
		while(!pq.isEmpty()) {
			result+=pq.poll();
		}
		
		System.out.println(result);
	}

}
