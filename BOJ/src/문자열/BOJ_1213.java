package 문자열;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BOJ_1213 {

	private static Map<String, Integer> m=new TreeMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s=null;
		
		s=sc.next();
		char ch[]=new char[s.length()];
		for(int i=0;i<s.length();i++) {
			ch[i]=s.charAt(i);
		}
		Arrays.sort(ch);
		
		for(int i=0;i<s.length();i++) {
			String key=ch[i]+"";
			if(m.containsKey(key)) {
				m.put(key, m.get(key)+1);
			} else {
				m.putIfAbsent(key, 1);
			}
		}
		
		
		int cnt=0;
		boolean isImpossible=false;
		String resultPre="";
		String resultMid="";
		String resultPost="";
		String result=null;
		
		for(Map.Entry<String, Integer> entry:m.entrySet()) {
			String key=entry.getKey();
			Integer value=entry.getValue();
			
			if(value%2==1) {
				cnt++;
				resultMid=key;
			}
			if(cnt>1) {
				isImpossible=true;
				break;
			} else {
				int len=value/2;
				for(int i=0;i<len;i++) {
					result=resultPre+key+key+resultPost;
					resultPre=resultPre+key;
					resultPost=key+resultPost;
				}
			}
		}
		if(!isImpossible) {
			result=resultPre+resultMid+resultPost;
		} else {
			result="I'm Sorry Hansoo";
		}
		System.out.println(result);
	}
	
}
