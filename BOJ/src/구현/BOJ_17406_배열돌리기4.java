package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17406_배열돌리기4 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, M, K, result=Integer.MAX_VALUE;
	private static int [][]arr, arr2;
	private static int [] r, c, s;
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		arr=new int[N+1][M+1];
		arr2=new int[N+1][M+1];
		r=new int[K];
		c=new int[K];
		s=new int[K];
		
		for(int r=1;r<=N;r++) {
			st=new StringTokenizer(bf.readLine());
			for(int c=1;c<=M;c++) {
				arr[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(bf.readLine());
			r[i]=Integer.parseInt(st.nextToken());
			c[i]=Integer.parseInt(st.nextToken());
			s[i]=Integer.parseInt(st.nextToken());
		}
		// 입력 확인
//		for(int []r:arr2) {
//			for(int c:r) System.out.print(c+" ");
//			System.out.println();
//		}
//		
//		for(int i=0;i<K;i++) {
//			System.out.println(r[i]+" "+c[i]+" "+s[i]);
//		}
		
		permutation(K, new int[K], new boolean[K]);
		System.out.println(result);
	}

	public static void permutation(int toChoose, int []choosed, boolean[]visited) {
		if(toChoose==0) {
			for(int i=1;i<=N;i++) {
				arr2[i]=Arrays.copyOf(arr[i], arr[i].length);
			}
			for(int i=0;i<choosed.length;i++) {
				int x=r[choosed[i]]-s[choosed[i]];
				int y=c[choosed[i]]-s[choosed[i]];
				
				for(int d=0;d<=s[choosed[i]];d++) {
					rotate(x+d,y+d,s[choosed[i]]-d);
				}

			}
			for(int x1=1;x1<=N;x1++) {
				int tmp=0;
				for(int y1=1;y1<=M;y1++) {
					tmp+=arr2[x1][y1];
				}
				result=Math.min(result, tmp);
			}
			return;
		}
		
		for(int i=0;i<K;i++) {
			if(!visited[i]) {
				visited[i]=true;
				choosed[choosed.length-toChoose]=i;
				permutation(toChoose-1, choosed, visited);
				visited[i]=false;
			}
		}
	}
	
	public static void rotate(int R, int C, int S) {
		if(S==0) return;
		int keep=arr2[R][C];
		for(int x=R+1;x<=R+2*S;x++) {
			arr2[x-1][C]=arr2[x][C];
		}

		for(int y=C+1;y<=C+2*S;y++) {
			arr2[R+2*S][y-1]=arr2[R+2*S][y];
		}
		for(int x=R+2*S-1;x>=R;x--) {
			arr2[x+1][C+2*S]=arr2[x][C+2*S];
		}
		for(int y=C+2*S-1;y>=C+1;y--) {
			arr2[R][y+1]=arr2[R][y];
		}
		arr2[R][C+1]=keep;
	}
}
