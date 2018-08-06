public class Fibo_memo {

	static int memo[];
	public static void main(String[] args) {
		int n=10;
		memo = new int[n+1];
		memo[1]=1;
		
		fibo_memo(10);
		for(int i=1; i<memo.length; i++) {
			System.out.print(memo[i]+" ");
		}
	}
	
	public static int fibo_memo(int N) {
		if(N>=2 && memo[N]==0) {
			memo[N] = fibo_memo(N-1) + fibo_memo(N-2);
		}
		return memo[N];
	}
}
