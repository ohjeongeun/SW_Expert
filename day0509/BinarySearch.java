public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = {1, 4, 7, 9, 11, 19, 23};
		int key =11;
		int result = binary(arr, key);
		
		if(result==-1) {
			System.out.println("검색 실패");
		}else {
			System.out.println("find key! "+(result+1)+"번째 숫자");
		}
	}
	
	public static int binary(int arr[], int key) {
		int start = 0;
		int end = arr.length-1;
		int middle;
		
		while(start<=end) {
			middle = (start+ end)/2;
			
			//find key!
			if(arr[middle]==key) {
				return middle;
				
			//arr[middle]!=key. 검색 범위 조정
			}else if(arr[middle]<key) {
				start=middle+1;	
			}else{
				end = middle-1;			
			}
		}
		return -1; //start==key && key를 찾지 못했을 때
	}
}
