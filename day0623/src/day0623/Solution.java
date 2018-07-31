package day0623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Solution {
	
	static int len;
	static String str;
	static Stack<String> myStack;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			len = Integer.parseInt(br.readLine());
			myStack = new Stack<String>();
			str = br.readLine();
			boolean flag=true;
			
			for(int i=0; i<len; i++) {
				String s = Character.toString(str.charAt(i));
				if(s.equals("(") || s.equals("<") || s.equals("[") || s.equals("{")) {
					myStack.push(s);
				}
				else {
					if(myStack.isEmpty()) {
						flag=false;
						break;
					}
					String top = myStack.peek();
					if(top.equals("(") && s.equals(")")) {
						myStack.pop();
					}
					else if(top.equals("<") && s.equals(">")) {
						myStack.pop();
					}
					else if(top.equals("[") && s.equals("]")) {
						myStack.pop();
					}
					else if(top.equals("{") && s.equals("}")) {
						myStack.pop();
					}else {
						flag=false;
						break;
					}
				}		
			}
			System.out.print("#"+t+" ");
			if(myStack.isEmpty() && flag==true) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}
}
