package day0615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1233 {
	
	static int n;
	static String tree[];
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			n = Integer.parseInt(br.readLine());
			
			tree = new String[n+1];
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					tree[Integer.parseInt(st.nextToken())] = st.nextToken();
					while(st.hasMoreTokens()) {
						st.nextToken();
					}
				}
				
			}
			result=1;
			System.out.println("#"+t+" "+inorder(tree, 1));
			
		}
	}
	
	public static int inorder(String tree[], int root) {
		if(root>n) {
			return 0;
		}
		
		inorder(tree, 2*root);
		check(root);
		inorder(tree, 2*root+1);
		
		return result;
	}
	
	public static void check(int root) {
		if(2*root>n) {
			if(tree[root].equals("+") ||tree[root].equals("-") ||tree[root].equals("*") ||tree[root].equals("/")) {
				result=0;
				return;
			}
		}
	}
}
