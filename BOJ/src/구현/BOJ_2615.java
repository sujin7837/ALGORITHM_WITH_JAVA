package 구현;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class BOJ_2615 {
	private static int graph[][]=new int[20][20];
	
	private static boolean down(int r, int c) {
		if(r+5>20) return false;
		else {
			for(int i=0;i<5;i++) {
				if(graph[r+i][c]!=graph[r][c]) return false;
			}
		}
		if(r+5<=19 && graph[r+5][c]==graph[r][c]) return false;
		if(r>1 && graph[r-1][c]==graph[r][c]) return false;
		return true;
	}
	
	private static boolean right(int r, int c) {
		if(c+5>20) return false;
		else {
			for(int i=0;i<5;i++) {
				if(graph[r][c+i]!=graph[r][c]) return false;
			}
		}
		if(c+5<=19 && graph[r][c+5]==graph[r][c]) return false;
		if(c>1 && graph[r][c-1]==graph[r][c]) return false;
		return true;
	}
	
	private static boolean crossDown(int r, int c) {
		if(r+5>20 || c+5>20) return false;
		else {
			for(int i=0;i<5;i++) {
				if(graph[r+i][c+i]!=graph[r][c]) return false;
			}
		}
		if(r+5<=19 && c+5<=19 && graph[r+5][c+5]==graph[r][c]) return false;
		if(r>1 && c>1 && graph[r-1][c-1]==graph[r][c]) return false;
		return true;
	}
	
	private static boolean crossUp(int r, int c) {
		if(r-5<0 || c+5>20) return false;
		else {
			for(int i=0;i<5;i++) {
				if(graph[r-i][c+i]!=graph[r][c]) return false;
			}
		}
		if(r-5>=1 && c+5<=19 && graph[r-5][c+5]==graph[r][c]) return false;
		if(c>1 && r<19 && graph[r+1][c-1]==graph[r][c]) return false;
		return true;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("Test5.txt"));
		Scanner sc=new Scanner(System.in);
		// 구현하세요.
		for(int r=1;r<=19;r++) {
			for(int c=1;c<=19;c++) {
				graph[r][c]=sc.nextInt();
			}
		}
		
		// test output
//		for(int []row:graph) {
//			for(int c:row) {
//				System.out.print(c+" ");
//			}
//			System.out.println();
//		}
		
		
		int result=0;
		int resultR=0;
		int resultC=0;
		boolean isZero=true;
		for(int []row:graph) {
			for(int c:row) {
				if(c!=0) {
					isZero=false;
					break; 
				}
			}
		}
		
		if(isZero) {
			System.out.println(result);
		} else {
			outer: for(int r=1;r<=19;r++) {
				for(int c=1;c<=19;c++) {
					if(graph[r][c]==1 || graph[r][c]==2) {
						if(down(r, c) || right(r, c) || crossDown(r, c) || crossUp(r, c)) {
							resultR=r;
							resultC=c;
							result=graph[r][c];
							break outer;
						}
					}
				}
			}
			if(result==0) System.out.println(result);
			else {
				System.out.println(result);
				System.out.println(resultR+" "+resultC);
			}
			
		}
	}

}

