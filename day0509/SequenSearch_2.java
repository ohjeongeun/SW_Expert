public class SequenSearch_2 {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 5, 7, 10, 19};
		int key = 2;
		sequenSearch(arr, key);
	}
	
	public static void sequenSearch(int arr[], int key) {
	
		int i=0;
		while(arr[i]<key) {
			i++;
		}
		if(arr[i]==key) {
			System.out.println("find key!"+(i+1)+"번째 숫자");
		}else {
			System.out.println("검색횟수="+(i+1)+". key가 없습니다.");
		}
		
	}
}
