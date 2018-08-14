package day0603;

public class QuickSort2 {

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
		
		int pivot = a[begin]; //피봇 값 : 시작 인덱스 l값(피봇으로 선택)
		
		int i = begin; int j = end;
		
		
		while(i <= j) {
			
			
			while(a[i] <= pivot) {//피봇보다 작거나 같은 값일 때 i++.
								//피봇보다 큰 값이면 반복 종료
								//i는 피봇보다 큰값 가리키게 됨
				i++;
			}
			
			while(a[j] > pivot) {//피봇보다 큰 값이면 j--;
								//피봇보다 작은값이면 반복 종료
								//j는 피봇보다 작거나 같은 값
				j--;
			}
			
			
			if(i < j) {
				
				//i<j면 서로 교환. i>j면 반복 종료
				int tmp = a[j];
				a[j] = a[i];
				a[i] = tmp;
			}
			
		}
		
		
		int tmp = a[j];
		a[j] = a[begin];
		a[begin] = tmp;
		
		return j;
		
	}

}
