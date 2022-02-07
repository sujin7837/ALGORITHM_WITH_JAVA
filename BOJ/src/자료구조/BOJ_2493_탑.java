import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int[] top;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		top=new int[N];
		HashMap<Integer, Integer> map=new HashMap<>();
		Stack<Integer> stack=new Stack<>();
		
		for(int i=0;i<N;i++) {
			boolean isPrint=false;
			top[i]=Integer.parseInt(st.nextToken());
			map.put(top[i], i);
			
			while(!stack.isEmpty()) {
				int t=stack.pop();
				if(t>top[i]) {
					System.out.print((map.get(t)+1)+" ");
					stack.push(t);
					isPrint=true;
					break;
				}
			}
			stack.push(top[i]);
			if(!isPrint) System.out.print(0+" ");
		}
		
	}

}
