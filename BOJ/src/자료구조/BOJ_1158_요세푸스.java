package 자료구조;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1158_요세푸스 {

	private static int N, K;
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		Queue<Integer> queue=new LinkedList<Integer>();
		
		for(int i=1;i<=N;i++) {
			queue.add(i);
		}
		
		// queue 입력 확인
//		for(int r:queue) System.out.print(r+" ");
		int cnt=0;
		List<Integer> list=new LinkedList<Integer>();
		
		while(!queue.isEmpty()) {
			int current=queue.poll();
			cnt++;
			if(cnt==K) {
				list.add(current);
				cnt=0;
			} else {
				queue.add(current);
			}
		}
		
		System.out.print("<");
		for(int i=0;i<list.size()-1;i++) {
			System.out.print(list.get(i)+", ");
		}
		System.out.println(list.get(list.size()-1)+">");
	}

}
