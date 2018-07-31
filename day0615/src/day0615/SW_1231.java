package day0615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1231 {

	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			
			n = Integer.parseInt(br.readLine());
			String tree[] = new String[n+1];
			
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					tree[Integer.parseInt(st.nextToken())] = st.nextToken();
					while(st.hasMoreTokens()) {
						st.nextToken();
					}
				}
				
			}
			
			System.out.print("#"+t+" ");
			inorder(tree, 1);
			System.out.println();
		}
		
	}
	
	
	public static void inorder(String tree[], int root) {
		
		if(root>n) {
			return;
		}
		inorder(tree, 2*root);
		System.out.print(tree[root]);
		inorder(tree, 2*root+1);
	
	}

}
