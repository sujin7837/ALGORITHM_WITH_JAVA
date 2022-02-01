package 문자열;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1254 {

	private static String S=null;
	private static List<Integer> even=new ArrayList<>();
	private static List<Integer> odd=new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		S=sc.next();
		int len=S.length();
		int result=0;
        
        if(len==1) result=1;
        else {
            for(int i=len/2;i<len;i++) {
			    if(S.charAt(i-1)==S.charAt(i)) {
				    even.add(i);
			    }
                if(i<len-1 && S.charAt(i-1)==S.charAt(i+1)) {
				    odd.add(i);
			    }
            }
            
            int cnt=0;
			int maxCnt=0;
			if(even.size()==0 && odd.size()==0) {
				result=len+len-1;
			} else {
				for(int i=0;i<even.size();i++) {
					int now=even.get(i);
	                for(int j=now;j<len;j++) {
	                    if(now-1>=0 && S.charAt(now-1)==S.charAt(j)) {
	                        cnt+=2;
	                        now--;
	                    } else {
	                        cnt=0;
	                        break;
	                    }
	                }
					if(cnt>maxCnt) {
						maxCnt=cnt;
					}
					cnt=0;
				}
				for(int i=0;i<odd.size();i++) {
					cnt=1;
					int now=odd.get(i);
	                for(int j=now+1;j<len;j++) {
	                    if(now-1>=0 && S.charAt(now-1)==S.charAt(j)) {
	                        cnt+=2;
	                        now--;
	                    } else {
	                        cnt=0;
	                        break;
	                    }
	                }
					if(cnt>maxCnt) {
						maxCnt=cnt;
					}
					cnt=0;
				}
				if(maxCnt==0) result=len+len-1;
				else result=len+len-maxCnt;
			}
        }
		
		System.out.println(result);
	}
}
