package day0603;

public class Exponent {

	public static void main(String[] args) {
		
		System.out.println(Power(2, 9));
	}
	
	
	// 시간 복잡도 : O(n)
	//  						밑                     지수
	public static int Power(int base, int exponent) {
		
		int i=0;
		int result = 1; //C^0 = 1
		
		//총 n번의 곱 수행
		for(i=0; i < exponent; i++) {
			result *= base;
		}
		
		
		
		return result;
		
	}

}
