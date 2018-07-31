package day0623;

import java.util.HashMap;
import java.util.Stack;

public class ex02 {

	public static void main(String[] args) {
		String input = "3+[(5+1)-1]";
		solution(input);
	}

    public static boolean solution(String input) {
        boolean answer = true;
        Stack<String> myStack = new Stack<String>();
        HashMap<String, Integer> Pri = new HashMap<String, Integer>();
        Pri.put("(", 0); 
        Pri.put("{", 1);
        Pri.put("[", 2);
        
        int i=0;
        while(i<input.length()) {
        	String s = Character.toString(input.charAt(i));
        	if(s.equals("(")||s.equals("{")||s.equals("[")) {
        		if(myStack.isEmpty()) {
        			myStack.push(s);
        		}else {
        			if(Pri.get(myStack.peek()) <= Pri.get(s)) {
        				myStack.push(s);
        			}else {
        				while(true) {
        					if(Pri.get(myStack.peek())<=Pri.get(s)) {
        						myStack.push(s);
        						break;
        					}
        					myStack.pop();
        				}
        			}
        		}
        		
        	}else if(s.equals(")")||s.equals("}")||s.equals("]")) {
        		
        		String top = myStack.peek();
        		
        		while(!myStack.isEmpty()) {
        			if(myStack.peek().equals("(")) {
        				myStack.pop();
        			}else if(myStack.peek().equals("{")) {
        				myStack.pop();
        			}if(myStack.peek().equals("[")) {
        				myStack.pop();
        			}
        			myStack.pop();
        		}
        		
        		
        	}
        	i++;
        }
        
        
        return answer;
    }
}
