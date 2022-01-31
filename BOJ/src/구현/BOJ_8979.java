package 구현;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_8979 {

	private static int N, K;
	private static int arr[][];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		ArrayList<Comp> list = new ArrayList<>();
		N=sc.nextInt();
		K=sc.nextInt();
		arr=new int[N][4];
		for(int i=0;i<N;i++) {
			arr[i][0]=sc.nextInt();	// 국가 번호
			arr[i][1]=sc.nextInt();	// 금메달 수
			arr[i][2]=sc.nextInt();	// 은메달 수
			arr[i][3]=sc.nextInt();	// 동메달 수
			list.add(new Comp(arr[i][0], sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
	}
	
	class OlympicComparator implements Comparator<Olympic> {

		@Override
		public int compare(Olympic o1, Olympic o2) {
			if(o1.gold>o1.gold) return 1;
			else if(o1.silver>o2.silver) return 1;
			else if(o1.bronze>o2.bronze) return 1;
			return 0;
		}
		
	}
	
	class Olympic {
		int nation;
		int gold;
		int silver;
		int bronze;
		
		public Olympic(int nation, int gold, int silver, int bronze) {
			super();
			this.nation = nation;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		@Override
		public String toString() {
			return "Olympic [nation=" + nation + ", gold=" + gold + ", silver=" + silver + ", bronze=" + bronze + "]";
		}
	}

}
