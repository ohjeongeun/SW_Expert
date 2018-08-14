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

			stack = new Stack<>(); //��ȣ ������ ����
			boolean flag = false; //¦ �� ���߸� false, ���߸� true
			
			
			for (int i = 0; i < len; i++) {
				
				token = str.charAt(i); //str�� i��° token ¥��

				//��ū�� ���� ��ȣ�� stack�� push
				if (token == '{' || token == '[' || token == '(' || token == '<') {
					stack.push(token);
				
				//��ū�� ������ ��ȣ�༮���̸�
				} else {

					//stack�� ���� �����ִ� ��ȣ �ϳ� ���� ��
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
