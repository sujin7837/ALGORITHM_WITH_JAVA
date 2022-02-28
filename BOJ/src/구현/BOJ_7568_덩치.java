package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7568_덩치 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int N;
	private static Person[] person;

	static class Person {
		int weight, height;

		public Person(int weight, int height) {
			super();
			this.weight = weight;
			this.height = height;
		}

		@Override
		public String toString() {
			return "Person [weight=" + weight + ", height=" + height + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		person=new Person[N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			person[i]=new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for(int i=0;i<N;i++) {
			Person now=person[i];
			int cnt=1;
			for(int j=0;j<N;j++) {
				Person comp=person[j];
				if(comp.weight>now.weight && comp.height>now.height) cnt++;
			}
			System.out.print(cnt+" ");
		}
	}

}
