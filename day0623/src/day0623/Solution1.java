package day0623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;
public class Solution1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			Stack<String> myStack = new Stack<String>();
			int N = Integer.parseInt(br.readLine());
			String infix = br.readLine();
			HashMap<String, Integer> inP = new HashMap<String, Integer>();
			inP.put("(", 0); 
			inP.put("+", 1);
			inP.put("-", 1);
			inP.put("*", 2);
			inP.put("/", 2);
			HashMap<String, Integer> outP = new HashMap<String, Integer>();
			outP.put("+", 1);
			outP.put("-", 1);
			outP.put("*", 2);
			outP.put("/", 2);
			outP.put("(", 3);
			ArrayList<String> arr = new ArrayList<String>(); 
			int n=0;
			while(n<N) {
				String token = Character.toString(infix.charAt(n));
				if(token.equals("(") || token.equals("/") || token.equals("*") || token.equals("-") || token.equals("+")) {
					if(myStack.isEmpty()) {
						myStack.push(token);
					}else {
						if(inP.get(myStack.peek()) <= outP.get(token)) {
							myStack.push(token);
						}else {
							while(true) {
								if(inP.get(myStack.peek()) <= outP.get(token)) {
									myStack.push(token);
									break;
								}
								arr.add(myStack.pop());
							}
						}
					}
				} else if(token.equals(")")) {
					while(true) {
						if(myStack.peek().equals("(")) {
							myStack.pop();
							break;
						}
						arr.add(myStack.pop());
					}
				} else {
					arr.add(token);
				}
				n++;
			}
			if(n==N) {
				while(true) {
					if(myStack.isEmpty()) {
						break;
					}
					arr.add(myStack.pop());	
				}
			}
			int len = arr.size();
			Stack<Integer> sum =  new Stack<Integer>();
			int i=0;
			while(i<len) {
				int p; int q;
				if(arr.get(i).equals("+")) {
					q = sum.pop();
					p = sum.pop();	
					sum.add(p+q);
				}else if(arr.get(i).equals("-")) {
					q = sum.pop();
					p = sum.pop();	
					sum.add(p-q);
				}else if(arr.get(i).equals("*")) {
					q = sum.pop();
					p = sum.pop();	
					sum.add(p*q);
				}else if(arr.get(i).equals("/")) {
					q = sum.pop();
					p = sum.pop();	
					sum.add(p/q);
				}else {
					sum.add(Integer.parseInt(arr.get(i)));				
				}
				i++;
			}
			System.out.println("#"+t+" "+sum.peek());
		}
	}
}
