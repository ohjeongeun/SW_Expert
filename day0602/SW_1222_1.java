package day0602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class SW_1222_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			
			Stack<String> myStack = new Stack<String>();
			
			int N = Integer.parseInt(br.readLine());
			String infix = br.readLine();

			//출력 배열
			ArrayList<String> arr = new ArrayList<String>(); 
			int n=0;
			
			while(n<N) {
				String token = Character.toString(infix.charAt(n));
				
				// 1. 토큰이 +
				if(token.equals("+")) {
					myStack.push(token);	
					
				// 2. 토큰이 숫자	
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
			
			System.out.println(arr);
			
			int len = arr.size();
			Stack<Integer> sum =  new Stack<Integer>();
			
			int i=0;
			while(i<len) {
				int p; int q;
				
				if(arr.get(i).equals("+")) {
					q = sum.pop();
					p = sum.pop();	
					sum.push(p+q);
					
				}else {
					sum.push(Integer.parseInt(arr.get(i)));				
				
				}
				i++;
			}
		
			System.out.println("#"+t+" "+sum.peek());
			
		}	
	}
}
