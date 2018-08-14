package day0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class SW_1224 {
	static int len;
	static String str;
	static char token;
	static char pivot;
	static Stack<Character> stack;
	static LinkedList<Character> result;
	static Stack<Integer> sum;
	static HashMap<Character, Integer> in;
	static HashMap<Character, Integer> out;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ���� �ȿ��� '('�� �켱���� ���� ����
		in = new HashMap<>();
		in.put('(', 0);
		in.put('+', 1);
		in.put('*', 2);

		// stack�ۿ��� '('�� �켱���� ���� ����
		out = new HashMap<>();
		out.put('(', 3);
		out.put('+', 1);
		out.put('*', 2);

		//result = new StringBuffer();
		result = new LinkedList<>();
		for (int t = 1; t <= 10; t++) {
			len = Integer.parseInt(br.readLine());
			str = br.readLine();

			stack = new Stack<>();

			for (int i = 0; i < len; i++) {
				token = str.charAt(i);

				if (0 <= token - '0' && token - '0' <= 9) {
					//result.append(token);
					result.add(token);
				} else {
					// �ʱ⿡ ���� ��������� ������ push
					if (stack.isEmpty()) {
						stack.push(token);

						
					// ���� ������� ������ 	
					} else {
						if (token == ')') {
							while(!stack.isEmpty()) {
								if(stack.peek()=='(') {
									stack.pop();
									break;
								}
								//result.append(stack.pop());
								result.add(stack.pop());
							}
							
							
						// '(' or '*' or '+'
						// ���� top �� ���Ͽ�
						} else {
							
							//�켱���� stack.peek() < token �̸� stack�� push
							if(in.get(stack.peek()) < out.get(token)) {
								stack.push(token);
							
								
							// �켱���� "stack.peek() >= token" �̸� 
							// "stack.peek() < token" �� �� ������ stack pop
							}else {
								while(!stack.isEmpty()) {
									if(in.get(stack.peek()) < out.get(token)) {
										break;
									}
									//result.append(stack.pop());
									result.add(stack.pop());
									//System.out.println("��ȣ");
								}
								//�ϰ����� push
								stack.push(token);
								
								
							}
							
							
						}

					}

				}
				//System.out.println(stack);
			}
			
			if(!stack.isEmpty()) {
				//result.append(stack.pop());
				result.add(stack.pop());
			}
			
			sum = new Stack<>();
			while(!result.isEmpty()) {

				char token = result.removeFirst();
				
				//������
				if(token =='+' || token =='*') {
					
					int p = sum.pop();
					int q = sum.pop();
					
					if(token=='+' ) {
						sum.push(p+q);
					}else {
						sum.push(p*q);
					}
					
					
				//����	
				}else {
					sum.push(token-48);
				}
				
			}
			
			
			
			System.out.print("#" + t+" ");
			System.out.println(sum.pop());
			//System.out.println(result);

		}

	}
}
