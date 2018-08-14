package day0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SW_1218 {
	static int len;
	static String str;
	static char token;
	static char pivot;
	static Stack<Character> stack;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			len = Integer.parseInt(br.readLine());
			str = br.readLine();

			stack = new Stack<>(); //괄호 조사할 스택
			boolean flag = false; //짝 못 맞추면 false, 맞추면 true
			
			
			for (int i = 0; i < len; i++) {
				
				token = str.charAt(i); //str중 i번째 token 짜름

				//토큰이 왼쪽 괄호면 stack에 push
				if (token == '{' || token == '[' || token == '(' || token == '<') {
					stack.push(token);
				
				//토큰이 오른쪽 괄호녀석들이면
				} else {

					//stack의 가장 위에있는 괄호 하나 빼서 비교
					pivot = stack.pop();

					if (token == '}' && pivot == '{') {
						flag = true;

					} else if (token == ')' && pivot == '(') {
						flag = true;

					} else if (token == ']' && pivot == '[') {
						flag = true;

					} else if (token == '>' && pivot == '<') {
						flag = true;

					} else {
						flag = false;
						break;
					}

				}


			}


			System.out.print("#" + t + " ");
			if (flag == false) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		}

	}

}
