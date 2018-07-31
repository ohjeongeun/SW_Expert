package day0724;

public class ex01 {

	public static void main(String[] args) {
		
		int arr[] = {3, 6, 7, 1, 5, 4};
		
		for(int num=0; num< (1<<arr.length); num++) {
			for(int i=0; i<arr.length; i++) {
				if((num & (1<<i)) != 0) { //if문 안에 boolean값이 들어가야되는데,,,,,,,,,,,,,,,, java는 0 1을 false true로 인식을 못함
					System.out.print(arr[i]);
				}
			}
			System.out.println();
		}
		
	}

}
