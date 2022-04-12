package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14891_톱니바퀴 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
//	private static int [][]wheel;
	private static List<Integer> []list;
	private static int [][]rotate;
	private static int K;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
//		wheel=new int[5][8];
		list=new ArrayList[5];
		for(int i=1;i<=4;i++) list[i]=new ArrayList<>();
		for(int i=1;i<=4;i++) {
			String s=br.readLine();
			for(int j=0;j<8;j++) list[i].add(s.charAt(j)-'0');
		}
		
		K=Integer.parseInt(br.readLine());
		rotate=new int[K][2];
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			rotate[i][0]=Integer.parseInt(st.nextToken());
			rotate[i][1]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<K;i++) {
			checkLeft(rotate[i][0], rotate[i][1]);
			checkRight(rotate[i][0], rotate[i][1]);
		}
		
		int sum=0;
		int now=1;
		for(int i=1;i<=4;i++) {
			if(list[i].get(0)==1) sum+=now;
			now*=2;
		}
		System.out.println(sum);
	}

	private static void checkLeft(int current, int dir) {
		int idx=current-1;
		int []direction=new int[5];
		while(idx>0) {
			dir*=-1;
			if(list[idx].get(2)==list[idx+1].get(6)) break;
			direction[idx]=dir;
			idx--;
		}
		doRotate(direction);
	}
	
	private static void checkRight(int current, int dir) {
		int idx=current+1;
		int []direction=new int[5];
		direction[current]=dir;
		while(idx<=4) {
			dir*=-1;
			if(list[idx-1].get(2)==list[idx].get(6)) break;
			direction[idx]=dir;
			idx++;
		}
		doRotate(direction);
	}
	
	private static void doRotate(int []direction) {
		for(int i=1;i<direction.length;i++) {
			if(direction[i]==-1) {
				int get=list[i].get(0);
				list[i].remove(0);
				list[i].add(get);
			} else if(direction[i]==1){
				int get=list[i].get(7);
				list[i].remove(7);
				list[i].add(0, get);
			}
		}
	}
}
