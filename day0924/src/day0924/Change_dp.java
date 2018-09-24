package day0924;

public class Change_dp {

	static int memo[];
	static int coin[] = {6, 4, 1};
	static int min;
	public static void main(String[] args) {
		memo = new int[100];
		
		CoinChange(10);
		
		for(int i=0; i<memo.length; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i=0; i<memo.length; i++) {
			System.out.print(memo[i]+" ");
		}
		
	}
	
	public static int CoinChange(int change) {
		memo[0]=0;
		
		for(int N=1; N<=change; N++) {
			
			min = Integer.MAX_VALUE;
			for(int i=0; i<3; i++) {
				if(N>=coin[i] && memo[N-coin[i]]<min) {
					min = memo[N-coin[i]];
				}
			}
			memo[N]=min+1;
		}
		return memo[change];
		
		
	}

}
