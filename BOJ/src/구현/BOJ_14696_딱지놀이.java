package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14696_딱지놀이 {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N, ANUM, BNUM;
	private static int [] A, B, Acounter, Bcounter;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		for(int n=0;n<N;n++) {
			Acounter=new int[5];
			Bcounter=new int[5];
			
			// A 입력
			st=new StringTokenizer(bf.readLine());
			ANUM=Integer.parseInt(st.nextToken());
			A=new int[ANUM];
			for(int i=0;i<ANUM;i++) {
				A[i]=Integer.parseInt(st.nextToken());
				Acounter[A[i]]++;
			}
			// B 입력
			st=new StringTokenizer(bf.readLine());
			BNUM=Integer.parseInt(st.nextToken());
			B=new int[BNUM];
			for(int i=0;i<BNUM;i++) {
				B[i]=Integer.parseInt(st.nextToken());
				Bcounter[B[i]]++;
			}
			
			String s=null;
			for(int i=4;i>=1;i--) {
				if(Acounter[i]==Bcounter[i]) continue;
				else {
					if(Acounter[i]>Bcounter[i]) {
						s="A";
						break;
					} else {
						s="B";
						break;
					}
				}
			}
			if(s==null) s="D";
			System.out.println(s);
		}
		
	}

}
