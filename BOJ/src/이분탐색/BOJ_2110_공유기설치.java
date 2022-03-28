package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110_공유기설치 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, C;
	private static int [] houses;
	
	public static void main(String[] args) throws IOException {
		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		houses=new int[N];
		
		for(int i=0;i<N;i++) {
			houses[i]=Integer.parseInt(bf.readLine());
		}
		Arrays.sort(houses);
		
		int result=1;
		int start=1;
		int end=houses[N-1]-houses[0];
		while(start<=end) {
			int mid=(start+end)/2;
			if(canInstall(mid)) {	// 설치 가능
				result=Math.max(result, mid);
				start=mid+1;
			} else {	// 설치 불가능
				end=mid-1;
			}
		}
		
		System.out.println(result);
	}

	public static boolean canInstall(int mid) {
		int cnt=1;
		int now=houses[0]+mid;
		for(int i=0;i<N;i++) {
			if(houses[i]>=now) {
				cnt++;
				now=houses[i]+mid;
			}
		}
		return cnt>=C;
	}
}
