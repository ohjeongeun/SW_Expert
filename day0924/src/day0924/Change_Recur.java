package day0924;

public class Change_Recur {

	static int memo[];
	static int coin[] = {6, 4, 1};
	static int min;
	public static void main(String[] args) {
		memo = new int[100];
		memo[1]=1;
		for(int i=1; i<memo.length; i++) {
			memo[i]=-1;
		}
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
		
		if(memo[change]!=-1) return memo[change];
		
		if(change==0) {
			return 0;
		
		}else {
			min=Integer.MAX_VALUE;
			for(int i=0; i<3; i++) {
				if(change - coin[i] >=0) {
					int ret = CoinChange(change-coin[i]);
					if(ret<min) min=ret;
				}
			}
			
		}
		memo[change] = min+1;
		return memo[change];
		
	}

}
