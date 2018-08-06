public class SelectionAlgo {
	static int arr[] = {8, 5, 6, 2, 4};
	static int minIndex;
	static int minValue;
	static int k=3;
	
	public static void main(String[] args) {	
		int r= select(arr, k);
		System.out.println(r);
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static int select(int arr[], int k) {

		for(int i=0; i<k; i++) {//k번째로 작은 원소를 찾는 알고리즘
			minIndex=i;
			minValue=arr[i];
			for(int j=i+1; j<arr.length; j++) {
				if(minValue>arr[j] ) {
					minIndex = j;
					minValue = arr[j];
				}
			}
			int tmp=0;
			tmp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = tmp;
			
		}
		return arr[k];
		
	}

}
