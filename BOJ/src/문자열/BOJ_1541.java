package 문자열;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1541 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		int now=0;
		boolean isMinus=false;
		List<Integer> num=new ArrayList<>();
		
		for(int i=0;i<s.length();i++) {
			if(i==s.length()-1) {
				if(isMinus) num.add(-1*Integer.parseInt(s.substring(now, i+1)));
				else num.add(Integer.parseInt(s.substring(now, i+1)));
			} else if(s.charAt(i)=='-') {
				if(isMinus) num.add(-1*Integer.parseInt(s.substring(now, i)));
				else num.add(Integer.parseInt(s.substring(now, i)));
				now=i+1;
				isMinus=true;
			} else if(s.charAt(i)=='+') {
				if(isMinus) num.add(-1*Integer.parseInt(s.substring(now, i)));
				else num.add(Integer.parseInt(s.substring(now, i)));
				now=i+1;
			}
		}
		
		int result=0;
		for(int i=0;i<num.size();i++) {
			result+=num.get(i);
		}
		System.out.println(result);
	}

}
