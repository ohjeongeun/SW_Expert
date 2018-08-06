
public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = {8, 5, 6, 2, 4};
		select_sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void select_sort(int arr[]) {
		int min;
		for(int i=0; i<arr.length-1; i++) {
			min = i; 
			for(int j=i+1; j<arr.length; j++) {
				if(arr[min]>arr[j]) { 
					min = j; // 
				}
			}
			
			int tmp=0;
			tmp = arr[min];
			arr[min] = arr[i];
			arr[i] = tmp;
		}
	}
}
