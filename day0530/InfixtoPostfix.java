import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class InfixtoPostfix {

	public static void main(String[] args) {
		Stack<String> myStack = new Stack<String>();
		
		String infix = "( 5 + 4 * ( 1 - 7 ) / 1 )";
		StringTokenizer st = new StringTokenizer(infix);
		
		//Stack 내에 있을 때 연산자 우선순위 : 낮->높
		HashMap<String, Integer> inP = new HashMap<String, Integer>();
		inP.put("(", 0); // 왼쪽 괄호는 스택 내에 있을 땐 우선순위 제일 낮음
		inP.put("+", 1); // 따라서 어떤 연산자든 위에 쌓일 수 있음
		inP.put("-", 1);
		inP.put("*", 2);
		inP.put("/", 2);
		
		//Stack 밖에서의 연산자 우선순위 : 낮->높
		HashMap<String, Integer> outP = new HashMap<String, Integer>();
		outP.put("+", 1);
		outP.put("-", 1);
		outP.put("*", 2);
		outP.put("/", 2);
		outP.put("(", 3);

		//출력 배열
		ArrayList<String> arr = new ArrayList<String>(); 

		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			
			// 토큰이 왼쪽괄호 및 연산자
			if(token.equals("(") || token.equals("/") || token.equals("*") || token.equals("-") || token.equals("+")) {
				
				//스택이 비어있으면
				if(myStack.isEmpty()) {
					myStack.push(token);
				
				//스택 비어있지 않으면
				}else {
					
					// 우선순위 : top < token
					if(inP.get(myStack.peek()) < outP.get(token)) {
						myStack.push(token);
					
					}else {
					// 우선순위 : top > token
						while(true) {
							if(inP.get(myStack.peek()) < outP.get(token)) {
								myStack.push(token);
								break;
							} // 우선순위 : top < token 될때까지 Stack pop
							arr.add(myStack.pop());
						}
					}
					
				}
			// 토큰이 오른쪽 괄호	
			} else if(token.equals(")")) {
				while(true) {
					if(myStack.peek().equals("(")) {
						myStack.pop();
						break;
					}
					arr.add(myStack.pop());
				}
				
			// 토큰이 숫자	
			} else {
				arr.add(token);
			}
			

			
		}
		if(!st.hasMoreTokens()) {
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
	
		System.out.println(sum);
	

	}

}
