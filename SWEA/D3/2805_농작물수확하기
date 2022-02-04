private static int T, N;
	private static int [][]value;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for(int t=0;t<T;t++) {
			N=sc.nextInt();
			value=new int[N][N];
			for(int i=0;i<N;i++) {
				String s=sc.next();
				for(int j=0;j<N;j++) {
					value[i][j]=s.charAt(j)-'0';
				}
			}
			
			// 입력 확인
//			for(int []r:value) {
//				for(int c:r) {
//					System.out.print(c+" ");
//				}
//				System.out.println();
//			}
			
			int til=N/2;
			int result=0;
			for(int n=0;n<=til;n++) {
				int cnt=(n+1)*2-1;
				for(int i=0;i<cnt;i++) {
					result+=value[n][til-n+i];
				}
			}
			for(int n=N-1;n>til;n--) {
				int cnt=(N-n)*2-1;
				for(int i=0;i<cnt;i++) {
					result+=value[n][n-til+i];
				}
			}
			
			// 출력
			System.out.printf("#%d %d\n", t+1, result);
		}
	}
