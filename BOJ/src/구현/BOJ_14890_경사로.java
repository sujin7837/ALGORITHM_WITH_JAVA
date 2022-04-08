package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890_경사로 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, L;
	private static int [][]map;
	
	public static void main(String[] args) throws IOException {
		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		
		for(int r=0;r<N;r++) {
			st=new StringTokenizer(bf.readLine());
			for(int c=0;c<N;c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt=0;
		// 가로
		for(int r=0;r<N;r++) {
			int c=1;
			boolean []visited=new boolean[N];
			outer : while(c<N) {
//				System.out.println(r+" "+c+" "+cnt);
				if(map[r][c-1]==map[r][c]) {	// 같은 높이
					c++;
					continue;
				}
				if(map[r][c-1]+1==map[r][c]) {	// 오르막길
					for(int i=c-L;i<c;i++) {
						if(i<0 || visited[i] || map[r][c-1]!=map[r][i]) {
							break outer;
						}
					}
					c++;
				} else if(map[r][c-1]==map[r][c]+1) {	// 내리막길
					visited[c]=true;
					for(int i=c+1;i<c+L;i++) {
						if(i>=N || map[r][c]!=map[r][i]) {
							break outer;
						}
						visited[i]=true;
					}
					c+=L;
				} else break;
			}
			if(c==N) {
//				System.out.println("가로 "+r+" "+c);
				cnt++;
			}
		}
		
		// 세로
		for(int c=0;c<N;c++) {
			int r=1;
			boolean []visited=new boolean[N];
			outer : while(r<N) {
				if(map[r-1][c]==map[r][c]) {
					r++;
					continue;
				}
				if(map[r-1][c]+1==map[r][c]) {	// 오르막길
					
					for(int i=r-L;i<r;i++) {
						if(i<0 || visited[i] || map[r-1][c]!=map[i][c]) {
							break outer;
						}
					}
					r++;
				} else if(map[r-1][c]==map[r][c]+1) {	// 내리막길
					visited[r]=true;
					for(int i=r+1;i<r+L;i++) {
						if(i>=N || map[r][c]!=map[i][c]) break outer;
						visited[i]=true;
					}
					r+=L;
				} else break;
			}
			if(r==N) {
//				System.out.println("세로 "+r+" "+c);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
