package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_D3_1228_암호문1 {

	private static int N1, N2;
	private static LinkedList<String> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		for(int t=0;t<10;t++) {
			list=new LinkedList<String>();
			N1=Integer.parseInt(bf.readLine());
			StringTokenizer st1=new StringTokenizer(bf.readLine(), " ");
			
			for(int i=0;i<N1;i++) {
				list.add(st1.nextToken());
			}
			
			N2=Integer.parseInt(bf.readLine());
			StringTokenizer st2=new StringTokenizer(bf.readLine(), " ");
			
			for(int i=0;i<N2;i++) {
				String s=st2.nextToken();
				int x=Integer.parseInt(st2.nextToken());
				int y=Integer.parseInt(st2.nextToken());
				
				for(int j=x;j<x+y;j++) {
					list.add(j, st2.nextToken());
				}
			}
			
			System.out.print("#"+(t+1)+" ");
			for(int i=0;i<10;i++) System.out.print(list.get(i)+" ");
			System.out.println();
		}
	}

}
