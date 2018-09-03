package day0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class SW_1232 {
	static int N;
	static String tree[];
	static LinkedList<String> list;
	
	//완전 이진 트리가 아니므로
	//어케허냐잉
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			
			N = Integer.parseInt(br.readLine());
			tree = new String[N+1];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					int index = Integer.parseInt(st.nextToken());
					tree[index] = st.nextToken();
					while(st.hasMoreTokens()) {
						st.nextToken();
					}
				}
				
			}
			
			list = new LinkedList<>();
			postfix(1);
			System.out.println(list);
			//int answer = sum(list);
			//System.out.println(answer);
		}
		
	}
	
	public static void postfix(int node) {
		if(node>N) return;
		
		postfix(2*node);
		postfix(2*node+1);
		list.add(tree[node]);
		
	}
	
	public static int sum(LinkedList<String> list) {
		Stack<Integer> stack = new Stack<>();
		
		while(!list.isEmpty()) {
			String token = list.removeFirst();
			
			if(token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")) {
				int q = stack.pop();
				int p = stack.pop();
				
				if(token.equals("*")) {
					stack.push(p*q);
				}else if(token.equals("+")) {
					stack.push(p+q);
				}else if(token.equals("-")) {
					stack.push(p-q);
				}else if(token.equals("/")) {
					if(q==0) {
						stack.push(0);
					}else {
						stack.push(p/q);	
					}
					
				}
				
				
			}else {
				stack.push(Integer.parseInt(token));
			}
			
			
		}
		
		int result = stack.pop();
		return result;
		
		
	}
	

}
