package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2263_트리의순회 {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, idx=0;
	private static int []inorder, postorder, preorder;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		inorder=new int[N];
		postorder=new int[N];
		preorder=new int[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) inorder[i]=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) postorder[i]=Integer.parseInt(st.nextToken());
		
		getPreorder(0, N-1, 0, N-1, -1);
		for(int i:preorder) System.out.print(i+" ");
	}

	private static void getPreorder(int is, int ie, int ps, int pe, int root) {
//		if(root==-1) return;
		if(is<=ie && ps<=pe) {
//			System.out.println(is+" "+ie+" "+ps+" "+pe+" "+root);
			preorder[idx++]=postorder[pe];
//			System.out.println(Arrays.toString(preorder));
			for(int i=is;i<=ie;i++) {
				if(inorder[i]==postorder[pe]) {
					root=i;
//					System.out.println(root);
					break;
				}
			}
			getPreorder(is, root-1, ps, ps+root-1-is, root);
			getPreorder(root+1, ie, ps+root-is, pe-1, root);
		}
	}
}
