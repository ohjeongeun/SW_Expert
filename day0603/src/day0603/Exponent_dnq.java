package day0603;

public class Exponent_dnq {

	public static void main(String[] args) {
		
		System.out.println(Power(2, 9));

	}
	//							  밑                     지수
	public static int Power(int base, int exponent) {
		
		if(exponent==1) { //C^1 = C
			return base;
		
		}else if(base==0) { //C^0 = 1
			return 1;
		}
		
		int Nbase;
		
		//반으로 나눈부분은 다시 반으로 나눠서 재귀 호출 .. exponent=1 이 될때까지 
		if(exponent % 2 == 0) { //지수가 짝수
			Nbase = Power(base, exponent/2);
			return Nbase * Nbase; //합병
		
		}else { //지수가 홀수
			Nbase = Power(base, (exponent-1)/2); //분할하여 계산
			return (Nbase * Nbase) * base; //합병
		}
		
	}

}
