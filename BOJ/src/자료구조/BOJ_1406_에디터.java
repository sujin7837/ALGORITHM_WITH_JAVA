package 자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class BOJ_1406_에디터 {

	private static BufferedReader bf;
	private static BufferedWriter bw;
	private static StringTokenizer st;
	
	private static String S, command;
	private static char alpha;
	private static int M;
	private static LinkedList<Character> list=new LinkedList<>();
	
	public static void main(String[] args) throws IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		bw=new BufferedWriter(new OutputStreamWriter(System.out));
		S=bf.readLine();
		M=Integer.parseInt(bf.readLine());
		
		for(int i=0;i<S.length();i++) {
			list.add(S.charAt(i));
		}
		
		ListIterator<Character> il=list.listIterator();
		for(int i=0;i<S.length();i++) il.next();
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(bf.readLine());
			command=st.nextToken();
			if(command.equals("L")) {
				if(il.hasPrevious()) il.previous();
			} else if(command.equals("D")) {
				if(il.hasNext()) il.next();
			} else if(command.equals("B")) {
				if(il.hasPrevious()) {
					il.previous();
					il.remove();
				}
			} else if(command.equals("P")) {
				alpha=st.nextToken().charAt(0);
				il.add(alpha);
			}
		}
		
		for(char ch:list) bw.write(ch);
		bw.flush();
	}

}
