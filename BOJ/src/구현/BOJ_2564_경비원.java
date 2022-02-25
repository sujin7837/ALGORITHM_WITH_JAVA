package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2564_경비원 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int W, H, N, Dir, Distance;

	static class Shop {
		int dir, distance;

		public Shop(int dir, int distance) {
			super();
			this.dir = dir;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "Shop [dir=" + dir + ", distance=" + distance + "]";
		}

	}

	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		W=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(bf.readLine());
		Shop [] shop=new Shop[N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			shop[i]=new Shop(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		st=new StringTokenizer(bf.readLine());
		Dir=Integer.parseInt(st.nextToken());
		Distance=Integer.parseInt(st.nextToken());
		
		// 입력 확인
//		for(Shop s:shop) System.out.println(s);
		
		int [] result=new int[N];
		for(int i=0;i<N;i++) {
			if(Dir==shop[i].dir) result[i]=Math.abs(Distance-shop[i].distance);
			else {
				if(Dir==1) {
					if(shop[i].dir==2) result[i]=H+Math.min(Distance+shop[i].distance, 2*W-(Distance+shop[i].distance));
					else if(shop[i].dir==3) result[i]=Distance+shop[i].distance;
					else if(shop[i].dir==4) result[i]=W-Distance+shop[i].distance;
				} else if(Dir==2) {
					if(shop[i].dir==1) result[i]=H+Math.min(Distance+shop[i].distance, 2*W-(Distance+shop[i].distance));
					else if(shop[i].dir==3) result[i]=Distance+(H-shop[i].distance);
					else if(shop[i].dir==4) result[i]=W-Distance+H-shop[i].distance;
				} else if(Dir==3) {
					if(shop[i].dir==1) result[i]=Distance+shop[i].distance;
					else if(shop[i].dir==2) result[i]=H-Distance+shop[i].distance;
					else if(shop[i].dir==4) result[i]=W+Math.min(Distance+shop[i].distance, 2*H-(Distance+shop[i].distance));
				} else if(Dir==4) {
					if(shop[i].dir==1) result[i]=Distance+W-shop[i].distance;
					else if(shop[i].dir==2) result[i]=H-Distance+W-shop[i].distance;
					else if(shop[i].dir==3) result[i]=W+Math.min(Distance+shop[i].distance, 2*H-(Distance+shop[i].distance));
				}
			}
		}
		
		int sum=0;
		for(int r:result) sum+=r;
		System.out.println(sum);
	}

}
