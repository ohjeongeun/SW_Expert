package scpc_0623;

import java.util.Stack;

public class QuickSort {

	public static void main(String[] args) {
		int a[] = {68, 11, 29, 3, 15, 9, 32, 23};
		
		quick_s(a, 8);
		
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}

	}
	
	public static void quick_s(int a[], int n) {
		int tmp;
		int i,j;
		int pivot;
		int left;
		int right;
		
		Stack<Integer> stack = new Stack<>();
		
		left=0;
		right=n-1;
		
		stack.push(right);
		stack.push(left);
		
		while(!stack.isEmpty()) {
			left = stack.pop();
			right = stack.pop();
			
			if(right-left>0) {
				pivot = a[right];
				i = left-1;
				j = right;
				
				while(true) {
					while(a[++i] < pivot);
					while(a[--j] > pivot);
					
					if(i>=j)break;
					
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
					
					
				}
				
				tmp = a[i];
				a[i] = a[right];
				a[right] = tmp;
				
				stack.push(right);
				stack.push(i+1);
				stack.push(i-1);
				stack.push(left);
				
				
				
			}
			
			
			
			
			
			
		}
	}

}
