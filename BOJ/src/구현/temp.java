package 구현;

import java.util.Scanner;

public class temp {

	static int N;
	static int[][] scores;
	static int[][] cnt32;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		scores = new int[N+1][3]; //N+1 행 배열에 합산값 저장
		
		int sum1 = 0; //후보 1번 점수총합
		int sum2 = 0;
		int sum3 = 0;
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<3; c++) {
				scores[r][c] = scan.nextInt();
			}
		}
		scan.close();
		//입력완료
		
		cnt32 = new int[3][2]; //각 후보의 3점 2점 횟수
		
		for(int r=0; r<N; r++) { //각 후보의 점수 합계
			for(int c=0; c<3; c++) {
				switch(c) {
				case 0: //1번 후보
					sum1+=scores[r][c];
					
					if(scores[r][c] == 3) { // 3점이면 cnt 증가
						cnt32[0][0]++;
					}else if(scores[r][c] == 2) { //2점이면 cnt 증가
						cnt32[0][1]++;
					}
					
					break;
				case 1:
					sum2+=scores[r][c];
					if(scores[r][c] == 3) { // 3점이면 cnt 증가
						cnt32[1][0]++;
					}else if(scores[r][c] == 2) { //2점이면 cnt 증가
						cnt32[1][1]++;
					}
					break;
				case 2:
					sum3+=scores[r][c];
					if(scores[r][c] == 3) { // 3점이면 cnt 증가
						cnt32[2][0]++;
					}else if(scores[r][c] == 2) { //2점이면 cnt 증가
						cnt32[2][1]++;
					}
					break;
				}
			}
		}
		
		
		scores[N][0] = sum1;
		scores[N][1] = sum2;
		scores[N][2] = sum3;
		
		int winner = 0;
		int temp;
		int [] rank = {1,2,3};
		
		outer : for(int i=0; i<3; i++) { //각 후보를 3번 비교하는 for문
			for(int j=i+1; j<3; j++) {
				if(scores[N][i] > scores[N][j]) {
					
				}else if(scores[N][i] < scores[N][j]) {
					temp = rank[i];
					rank[i] = rank[j];
					rank[j] = temp;
					
					continue outer;
					
				}else { //비겼을 때
					if(compare(i,j)==1) {
						temp = rank[i];
						rank[i] = rank[j];
						rank[j] = temp;
						
						continue outer;
					}
				}
			}
		} //더이상 순위변동없으면 for문 탈출
		
		if(compare(rank[0]-1, rank[1]-1) != 2) {
			System.out.println(rank[0] + " " + scores[N][rank[0] - 1]);
		}else {
			System.out.println(0 + " " + scores[N][rank[0] - 1]);
		}
		
	} //main
	
	public static int compare(int a, int b) { // a승:0 , b승:1, 비김:2
		if(cnt32[a][0] < cnt32[b][0]) { // 3점 비교
			return 1;
		}else if(cnt32[a][0] == cnt32[b][0]) { // 2점 비교
			if(cnt32[a][1] < cnt32[b][1]) {
				return 1;
			}else if(cnt32[a][1] == cnt32[b][1]) { //완전비김
					return 2;
				}
			}
		
		return 0;
	}

}
