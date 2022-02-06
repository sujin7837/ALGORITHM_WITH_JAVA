import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static int N;
	private static long rank[];
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		rank=new long[N];
		for(int i=0;i<N;i++) {
			rank[i]=sc.nextInt();
		}
		Arrays.sort(rank);
		
		long result=0;
		for(int i=1;i<=N;i++) {
			result+=Math.abs(rank[i-1]-i);
		}
		
		System.out.println(result);
	}

}
