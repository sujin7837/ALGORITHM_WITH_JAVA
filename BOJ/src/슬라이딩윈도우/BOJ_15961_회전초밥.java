package 슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15961_회전초밥 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, d, k, c, result;
	private static int [] sushi, eat;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		sushi=new int[N];
		eat=new int[d+1];
		
		for(int i=0;i<N;i++) sushi[i]=Integer.parseInt(bf.readLine());
		result=1;
		eat[c]++;
		
		Queue<Integer> queue=new LinkedList<>();
		for(int i=N-k;i<N;i++) {
			if(eat[sushi[i]]==0) {
				result++;
			}
			eat[sushi[i]]++;
			queue.add(sushi[i]);
		}
		int cnt=result;
		for(int i=0;i<N-1;i++) {
//			System.out.println(queue+" "+result);
			int pop=queue.poll();
//			System.out.println(pop);
			eat[pop]--;
			if(eat[pop]==0) cnt--;
			queue.add(sushi[i]);
			if(eat[sushi[i]]==0) cnt++;
			eat[sushi[i]]++;
//			System.out.println(Arrays.toString(eat));
//			System.out.println(queue+" : "+cnt);
			if(cnt>result) result=cnt;
		}
		
		System.out.println(result);
	}

}
