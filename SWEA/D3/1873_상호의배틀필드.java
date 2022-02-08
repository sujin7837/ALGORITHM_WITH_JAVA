package swea.d3;

import java.util.Scanner;

public class SWEA_D3_1873_상호의배틀필드 {
	
	private static int T, H, W, N;
	private static String S;
	private static char map[][];
	private static int R, C;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for(int t=0;t<T;t++) {
			H=sc.nextInt();
			W=sc.nextInt();
			map=new char[H][W];
			for(int r=0;r<H;r++) {
				String s=sc.next();
				for(int c=0;c<W;c++) {
					map[r][c]=s.charAt(c);
					if(map[r][c]=='^' || map[r][c]=='v' || map[r][c]=='<' || map[r][c]=='>') {
						R=r;
						C=c;
					}
				}
			}
			
			N=sc.nextInt();
			S=sc.next();
			
			// 입력 확인
//			for(char []r:map) {
//				System.out.println(r);
//			}
//			System.out.println("S: "+S);
			
			// start
			for(int i=0;i<N;i++) {
				char ch=S.charAt(i);
				if(ch=='U') {
					map[R][C]='.';
					if(R>0 && map[R-1][C]=='.') R-=1;
					map[R][C]='^';
				} else if(ch=='D') {
					map[R][C]='.';
					if(R<H-1 && map[R+1][C]=='.') R+=1;
					map[R][C]='v';
				} else if(ch=='L') {
					map[R][C]='.';
					if(C>0 && map[R][C-1]=='.') C-=1;
					map[R][C]='<';
				} else if(ch=='R') {
					map[R][C]='.';
					if(C<W-1 && map[R][C+1]=='.') C+=1;
					map[R][C]='>';
				} else if(ch=='S') {
					if(map[R][C]=='^') {
						for(int h=R;h>=0;h--) {
							if(map[h][C]=='*') {
								map[h][C]='.';
								break;
							} else if(map[h][C]=='#') {
								break;
							}
						}
					} else if(map[R][C]=='v') {
						for(int h=R;h<H;h++) {
							if(map[h][C]=='*') {
								map[h][C]='.';
								break;
							} else if(map[h][C]=='#') {
								break;
							}
						}
					} else if(map[R][C]=='<') {
						for(int c=C;c>=0;c--) {
							if(map[R][c]=='*') {
								map[R][c]='.';
								break;
							} else if(map[R][c]=='#') {
								break;
							}
						}
					} else if(map[R][C]=='>') {
						for(int c=C;c<W;c++) {
							if(map[R][c]=='*') {
								map[R][c]='.';
								break;
							} else if(map[R][c]=='#') {
								break;
							}
						}
					}
				}
			}
			
			// 출력
			System.out.printf("#%d ", t+1);
			for(char []r:map) {
				System.out.println(r);
			}
		}
	}
}
