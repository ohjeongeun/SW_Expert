public class Fibo_dp {
	static int n=10;
	static int fibo[];
	
	public static void main(String[] args) {
		fibo = new int[n+1];
		fibo_db(n);
		for(int i=1; i<fibo.length; i++) {
			System.out.print(fibo[i]+" ");
		}
	}
	
	public static void fibo_db(int n) {
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i = 2; i<=n; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
	}
}
