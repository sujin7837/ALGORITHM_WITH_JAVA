package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1374_강의실 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N;
	private static int no, start, end;
	private static List<Class> classes;
	
	static class Class implements Comparable<Class> {
		int no, start, end;

		public Class(int no, int start, int end) {
			super();
			this.no = no;
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Class [no=" + no + ", start=" + start + ", end=" + end + "]";
		}

		@Override
		public int compareTo(Class o) {
			if(this.start==o.start) return Integer.compare(this.end, o.end);
			return Integer.compare(this.start, o.start);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		classes=new ArrayList<>();
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			no=Integer.parseInt(st.nextToken());
			start=Integer.parseInt(st.nextToken());
			end=Integer.parseInt(st.nextToken());
			classes.add(new Class(no, start, end));
		}
		Collections.sort(classes);
		
		int result=0;
		for(int i=0;i<N;i++) {
			while(!pq.isEmpty() && pq.peek()<=classes.get(i).start) {
				pq.poll();
			}
			pq.add(classes.get(i).end);
			result=Math.max(result, pq.size());
		}
		
		System.out.println(result);
	}

}
