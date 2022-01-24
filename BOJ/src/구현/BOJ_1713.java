package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1713 {
	private static int N;
	private static int Total;
	private static int student[]=new int[101];
	private static int nominate[];
	private static int num[];
	private static int time[]=new int[101];
	private static int cnt=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		Total=sc.nextInt();
		nominate=new int[N];
		num=new int[Total];

		for(int i=0;i<Total;i++) {
			boolean isNominate=false;
			num[i]=sc.nextInt();
			
			for(int x:nominate) {	// 4
				if(x==num[i]) {
					student[x]++;
					isNominate=true;
					break;
				}
			}
			if(!isNominate) {
				time[num[i]]=i+1;
				if(cnt<N) {
					student[num[i]]++;
					nominate[cnt++]=num[i];
				} else {
					int temp=0;
					for(int j=1;j<N;j++) {
						if(student[nominate[temp]]>student[nominate[j]]) {
							temp=j;
						} else if(student[nominate[temp]]==student[nominate[j]]) {
							if(time[nominate[temp]]>time[nominate[j]]) {
								temp=j;
							}
						}
					}
					student[nominate[temp]]=0;
					nominate[temp]=num[i];
					student[nominate[temp]]++;
				}
			}
		}
		Arrays.sort(nominate);
		for(int x:nominate) {
			if(x!=0) System.out.print(x+" ");
		}
	}

}
