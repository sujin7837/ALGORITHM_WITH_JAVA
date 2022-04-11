package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, result;
	private static int [][]S;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		S=new int[N+1][N+1];
		
		for(int r=1;r<=N;r++) {
			st=new StringTokenizer(br.readLine());
			for(int c=1;c<=N;c++) {
				S[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		result=Integer.MAX_VALUE;
		combination(N/2, new int[N/2], 1);

		System.out.println(result);
	}

	private static void combination(int toChoose, int[] choosed, int start) {
		if(toChoose==0) {
			List<Integer> list1=new ArrayList<>();
			List<Integer> list2=new ArrayList<>();
			for(int i=0;i<choosed.length;i++) list1.add(choosed[i]);
			for(int i=1;i<=N;i++) {
				if(!list1.contains(i)) list2.add(i);
			}
//			System.out.println(list1);
//			System.out.println(list2);
			int sum1=getSum(list1);
			int sum2=getSum(list2);
//			System.out.println(Math.abs(sum1-sum2)+" : "+result);
			result=Math.min(Math.abs(sum1-sum2), result);
			return;
		}
		
		for(int i=start;i<=N;i++) {
//			System.out.println(choosed.length+" "+toChoose);
			choosed[choosed.length-toChoose]=i;
			combination(toChoose-1, choosed, i+1);
		}
	}
	
	private static int getSum(List<Integer> list) {
		int sum=0;
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.size();j++) {
				if(i==j) continue;
				int a=list.get(i);
				int b=list.get(j);
				sum+=S[a][b];
			}
		}
		
		return sum;
	}
}
