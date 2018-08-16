package day0814;

public class Power {

	public static void main(String[] args) {
		int result = Power(2, 8);
		System.out.println(result);
	}
	
	public static int Power(int x, int n) {
		
		if(n==1) return x;
		
		if(n%2==0) {
			int y = Power(x, n/2);
			return y*y;
			
		}else {
			int y = Power(x, (n-1)/2);
			return y*y*x;
		}
		
			
	}
	
}
