package 자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_17219_비밀번호찾기 {

	private static BufferedReader bf;
	private static BufferedWriter bw;
	private static StringTokenizer st;
	
	private static int N, M;
	private static HashMap<String, String> hm=new HashMap<>();
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			hm.put(st.nextToken(), st.nextToken());
		}
		
		bw=new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<M;i++) {
			bw.write(hm.get(bf.readLine()));
			bw.newLine();
		}
		
		bw.flush();
	}

}
