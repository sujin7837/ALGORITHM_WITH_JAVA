package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1244_스위치켜고끄기 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int N, StudentN, cnt=1;
	private static int[] switchState;
	private static Student [] student;

	static class Student {
		int mf, num;

		public Student(int mf, int num) {
			super();
			this.mf = mf;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Student [mf=" + mf + ", num=" + num + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		switchState = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++)
			switchState[i] = Integer.parseInt(st.nextToken());
		
		StudentN=Integer.parseInt(bf.readLine());
		student=new Student[StudentN];
		for(int i=0;i<StudentN;i++) {
			st=new StringTokenizer(bf.readLine());
			student[i]=new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// 입력 확인
//		System.out.println(Arrays.toString(switchState));
//		for(Student s:student) System.out.println(s);
		
		for(int i=0;i<StudentN;i++) {
			int nowNum=student[i].num;
			if(student[i].mf==1) {	// 남학생
				for(int s=0;s<N;s++) {
					if((s+1)%nowNum==0) switchState[s]=Math.abs(switchState[s]-1);
				}
			} else {	// 여학생
				cnt=1;
				symmetry(nowNum-1);
//				System.out.println("cnt: "+cnt);
				for(int j=nowNum-cnt;j<nowNum-1+cnt;j++) {
					switchState[j]=Math.abs(switchState[j]-1);
				}
			}
//			for(int r:switchState) System.out.print(r+" ");
//			System.out.println();
		}
		
		for(int i=0;i<N;i++) {
			if(i>0 && i%20==0) System.out.println();
			System.out.print(switchState[i]+" ");
		}
	}

	public static void symmetry(int a) {
		while(true) {
			if(!isIn(a-cnt) || !isIn(a+cnt)) return;
			else if(switchState[a-cnt]!=switchState[a+cnt]) return;
			else cnt++;
		}
	}
	
	public static boolean isIn(int a) {
		return a>=0 && a<N;
	}
	
}
