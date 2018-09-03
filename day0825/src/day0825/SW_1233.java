package day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SW_1233 {
	
	static int N;
	static String tree[];
	static LinkedList<String> list;
	static Stack<Integer> stack;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			
			N = Integer.parseInt(br.readLine());
			tree = new String[N+1];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				/*while(st.hasMoreTokens()) {
					int index =  Integer.parseInt(st.nextToken());
					tree[index] = st.nextToken();
					
					while(st.hasMoreTokens()) {
						st.nextToken();
					}
				}*/
				int index =  Integer.parseInt(st.nextToken());
				tree[index] = st.nextToken();
			}
			
			list = new LinkedList<>();
			stack = new Stack<>();
			postfix(1);
			System.out.println(list);
			result=1;
			sum();
			
			
			System.out.println("#"+t+" "+result);
		}
		
	}
	
	public static void postfix(int node) {
		if(node>N) return;
		postfix(2*node);
		postfix(2*node+1);
		list.add(tree[node]);
	}
	
	public static void sum() {
		try {
			for(int i=0; i<list.size(); i++) {
				int p; int q;
				
				if(list.get(i).equals("*")||list.get(i).equals("/")||list.get(i).equals("+")||list.get(i).equals("-")) {
					q = stack.pop();
					p = stack.pop();
					
					if(list.get(i).equals("*")) {
						stack.push(p*q);
					}else if(list.get(i).equals("/")) {
						try {
							stack.push(p/q);
						}catch (ArithmeticException e) {
							stack.push(0);
						}
						
					}else if(list.get(i).equals("+")) {
						stack.push(p+q);
					}else if(list.get(i).equals("-")) {
						stack.push(p-q);
					}
					
				}else {
					stack.push(Integer.parseInt(list.get(i)));
				}
			}			
		}catch (Exception e) {
			result=0;
			return;
		}

		
	}
	
	
}
