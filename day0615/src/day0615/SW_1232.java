package day0615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SW_1232 {
	static int n;
	static String tree[];
	static Stack<String> mystack;
	static Stack<Integer> sum;
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
			mystack = new Stack<>();
			sum = new Stack<>();
			postorder(tree, 1);
			//System.out.println(mystack);
			sum();
			System.out.print("#"+t+" ");
			System.out.println(sum.pop());
		}
	}
	
	public static void postorder(String tree[], int root) {
		if(root> n) {
			return;
		}
		postorder(tree, 2*root);
		postorder(tree, 2*root+1);
		mystack.push(tree[root]);
		
		
	}
	
	public static void sum() {
		
		int len = mystack.size();
		int i=0;
		
		while(i < len) {
			
			String s = mystack.get(i);
			
			int p=0; int q=0;
			if(s.equals("+")) {
				q = sum.pop();
				p = sum.pop();
				sum.add(p+q);
				
			}else if(s.equals("-")) {
				q = sum.pop();
				p = sum.pop();
				sum.add(p-q);
				
			}else if(s.equals("*")) {
				q = sum.pop();
				p = sum.pop();
				sum.add(p*q);
				
			}else if(s.equals("/")) {
				q = sum.pop();
				p = sum.pop();
				
				if(q==0) {
					sum.add(0);
				}else {
					sum.add(p/q);	
				}
				
				
			}else {
				sum.add(Integer.parseInt(s));
				//System.out.println(sum);
			}
			
			i++;
			
		}
		
		
	}
	
}
