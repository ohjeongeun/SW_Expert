package day0620;

import java.util.Stack;

public class ex {

	public static void main(String[] args) {

			
		Stack<int[]> stack = new Stack<>();
		
		for(int i=0; i<5; i++) {
			int tmp[] = {i,2*i};
			stack.push(tmp);
		}
		
		for(int i=0; i<5; i++) {
			int tmp[] = stack.get(i);
			System.out.println(tmp[0]+" "+tmp[1]);
		}
		
	}

}
