public class Fibo_recur {

	public static void main(String[] args) {
		int n = 10;
		for(int i=1; i<=n; i++) {
			System.out.print(fibo(i)+" ");	
		}
	}
	
	public static int fibo(int N) {
		if(N<2) {
			return N;
		}
		else {
			return (fibo(N-1) + fibo(N-2));
		}
		
	}

}
