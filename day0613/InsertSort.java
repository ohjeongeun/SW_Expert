package day0613;


public class InsertSort {

	static int[] arr = {69, 10, 30, 2, 16, 8, 31, 22};

	public static void main(String[] args) {
		
		insertionSort();
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	 
	public static void insertionSort() {
		
		for(int i=1; i<arr.length; i++) {
			int standard = arr[i]; //미정렬 원소 집합의 첫번쨰 원소(기준)
			int sortedLast = i-1; //정렬된 원소 집합의 마지막 인덱스
			
			                      //기준이 정렬된 원소 마지막 인덱스보다 작으면
			while(sortedLast >=0 && standard < arr[sortedLast]) {
				arr[sortedLast+1] = arr[sortedLast]; //배열 오른쪽으로 밀기
				sortedLast--;
			}
			arr[sortedLast+1] = standard;
			
		}
	}

}
