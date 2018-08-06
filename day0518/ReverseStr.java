public class ReverseStr {

	public static void main(String[] args) {
		String arr[] = {"a", "l", "g", "o", "r", "i", "t", "h", "m"};
		String R_arr[] = new String[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			R_arr[i] = arr[arr.length-1-i];
		}
			
		for(int i=0; i<arr.length; i++) {
			System.out.print(R_arr[i]);
		}

	}

}
