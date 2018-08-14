package day0603;

public class QuickSort {

	public static void main(String[] args) {
		int a[] = {68, 11, 29, 3, 15, 9, 32, 23};
		
		quick_sort(a, 0, 7);
		
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}

	}
	
	public static void quick_sort(int a[], int begin, int end) {

		if(begin < end) {
			int p = partition(a, begin, end);
			quick_sort(a, begin, p-1);
			quick_sort(a, p+1, end);
		}
	}
	
	public static int partition(int a[], int begin, int end) {
		
		int pivot = (begin + end) /2;
		
		
		while(begin < end) {
			
			
			while(a[begin]<a[pivot] && begin<end) {
				begin++;
			}
			
			while(a[end]>=a[pivot] && begin<end) {
				end--;
			}
			
			
			if(begin < end) {
				
				if(begin == pivot) {
					pivot = end;
				}
				int tmp = a[end];
				a[end] = a[begin];
				a[begin] = tmp;
			}
			
		}
		
		
		int tmp = a[end];
		a[end] = a[pivot];
		a[pivot] = tmp;
		
		return end;
		
	}

}
