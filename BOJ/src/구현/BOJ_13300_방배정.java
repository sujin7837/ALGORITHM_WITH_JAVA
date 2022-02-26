package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13300_방배정 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int N, K;
	private static Student [] student;

	static class Student implements Comparable<Student> {
		int mf, grade;

		public Student(int mf, int grade) {
			super();
			this.mf = mf;
			this.grade = grade;
		}

		@Override
		public String toString() {
			return "Student [mf=" + mf + ", grade=" + grade + "]";
		}

		@Override
		public int compareTo(Student o) {
			if(this.mf==o.mf) return Integer.compare(this.grade, o.grade);
			else return Integer.compare(this.mf, o.mf);
		}

	}

	public static void main(String[] args) throws IOException {

		bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		student=new Student[N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			student[i]=new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(student);
		
//		for(Student s:student)
//			System.out.println(s);
		
		int result=1, now=1;
		for(int i=1;i<N;i++) {
			if(student[i-1].mf==student[i].mf && student[i-1].grade==student[i].grade) now++;
			else {
				result++;
				now=1;
			}
			if(now>K) {
				result++;
				now=1;
			}
		}
		
		System.out.println(result);
	}

}
