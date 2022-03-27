import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2343_기타레슨 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M, result=Integer.MAX_VALUE;
	private static int [] courses, tmp;
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		courses=new int[N];
		int start=0;
		int end=0;
		
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			courses[i]=Integer.parseInt(st.nextToken());
			end+=courses[i];
		}
		
		while(start<=end) {
			tmp=new int[M];
			int mid=(start+end)/2;
			int idx=0;
			for(int i=0;i<M;i++) {
				while(idx<N && tmp[i]+courses[idx]<=mid) {
					tmp[i]+=courses[idx++];
//					System.out.println(mid);
				}
			}
//			System.out.print(Arrays.toString(tmp));
//			System.out.println();
			if(idx<N) {	// 블루레이 크기가 너무 작음
				start=mid+1;
			} else {	// 블루레이 크기가 큼
				result=mid;
				end=mid-1;
			}
		}
		System.out.println(result);
	}
}
