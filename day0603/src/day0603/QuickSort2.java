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
		
		int pivot = a[begin]; //�Ǻ� �� : ���� �ε��� l��(�Ǻ����� ����)
		
		int i = begin; int j = end;
		
		
		while(i <= j) {
			
			
			while(a[i] <= pivot) {//�Ǻ����� �۰ų� ���� ���� �� i++.
								//�Ǻ����� ū ���̸� �ݺ� ����
								//i�� �Ǻ����� ū�� ����Ű�� ��
				i++;
			}
			
			while(a[j] > pivot) {//�Ǻ����� ū ���̸� j--;
								//�Ǻ����� �������̸� �ݺ� ����
								//j�� �Ǻ����� �۰ų� ���� ��
				j--;
			}
			
			
			if(i < j) {
				
				//i<j�� ���� ��ȯ. i>j�� �ݺ� ����
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
