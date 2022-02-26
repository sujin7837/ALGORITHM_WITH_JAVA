package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2628_종이자르기 {

	private static BufferedReader bf;
	private static StringTokenizer st;

	private static int W, H, N;
	private static Cut[] cut;

	static class Cut {
		int dir, no;

		public Cut(int dir, int no) {
			super();
			this.dir = dir;
			this.no = no;
		}

		@Override
		public String toString() {
			return "Cut [dir=" + dir + ", no=" + no + "]";
		}

	}

	public static void main(String[] args) throws IOException {

		bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bf.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(bf.readLine());
		cut = new Cut[N];

		List<Integer> w = new ArrayList<>();
		List<Integer> h = new ArrayList<>();
		w.add(0);
		w.add(W);
		h.add(0);
		h.add(H);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			cut[i] = new Cut(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			if (cut[i].dir == 0)
				h.add(cut[i].no);
			else
				w.add(cut[i].no);
		}

		Collections.sort(w);
		Collections.sort(h);
		
		// 입력 확인
//		for(Cut c:cut) System.out.println(c);
//		System.out.println(w);
//		System.out.println(h);
		
		int width=0, height=0;
		for(int i=1;i<w.size();i++) {
			width=Math.max(width, w.get(i)-w.get(i-1));
		}
		for(int i=1;i<h.size();i++) {
			height=Math.max(height, h.get(i)-h.get(i-1));
		}
		System.out.println(width*height);
	}

}
