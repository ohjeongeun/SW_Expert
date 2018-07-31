package day0603;

public class QuickSort {

	public static void main(String[] args) {
		int a[] = {68, 11, 29, 3, 15, 9, 32, 23};
		
		quick_s(a, 0, 7);
		
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}

	}
	
	public static void quick_s(int a[], int begin, int end) {

		if(begin < end) {
			int p = partition(a, begin, end);
			quick_s(a, begin, p-1);
			quick_s(a, p+1, end);
		}
	}
	
	public static int partition(int a[], int begin, int end) {
		
		int pivot = (begin + end) /2;
		int L = begin;
		int R = end;
		
		while(L<R) {
			while(a[L] < a[pivot] && L<R) {
				L += 1;
			}
			
			while(a[R] >= a[pivot] && L<R) {
				R -= 1;
			}
			
			if(L<R) {
				
				if(L == pivot) {
					pivot = R;
				}
				int tmp = a[R];
				a[R] = a[L];
				a[L] = tmp;
			}
			
		}
		int tmp = a[R];
		a[R] = a[pivot];
		a[pivot] = tmp;
		
		return R;
		
	}

}
