package day0613;


public class MergeSort {

	public static int[] temp = new int[8]; //정렬되어 들어갈 배열
	
	public static void main(String[] args) {
		int arr[] = {69, 10, 30, 2, 16, 8, 31, 22};
		
		mergeSort(arr, 0, arr.length-1);
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void mergeSort(int arr[], int start, int end) {
		int middle;
		//divide
		if(start < end) {
			
			middle = (start+end)/2;
			
			//list의 길이가 1이 될 때까지 재귀 호출
			mergeSort(arr, start, middle);
			mergeSort(arr, middle+1, end);
			
			//병합
			merge(arr, start, middle, end);
		}
	}
	
	//merge
	public static void merge(int arr[], int start, int middle, int end) {
		
		int i=start;     // left ~ middle
		int j=middle+1; //middle+1 ~ right
		
		int k=start; //두 개의 분할된 list를 병합하여 임시로 저장할 배열의 index
		
		//두 서브 list의 첫 원소들 비교
		while(i<=middle && j<=end) {
			//작은것 부터 추가
			if(arr[i] <= arr[j]) {
				temp[k] = arr[i];
				k++; i++; 
			
			}else {
				
				temp[k] = arr[j];
				k++; j++;//다음 값을 넣기 위해 증가
			}
		}
		
		//왼쪽 list에 원소가 남아있을 경우
		while(i<=middle) {
			temp[k] = arr[i];
			k++; i++;
		}
		
		//오른쪽 list에 원소가 남아있을 경우
		while(j<=end) {
			temp[k] = arr[j];
			k++; j++;
		}
		
		for(int index=start; index<=end; index++) {
			arr[index] = temp[index];
		}
		
	}

	
}
