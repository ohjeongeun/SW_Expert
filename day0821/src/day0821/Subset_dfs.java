package day0821;

public class Subset_dfs {
	static int bit[];
	static int k;
	static int n;
	public static void main(String[] args) {
		n=9;
		bit = new int[n];
		for(int i=0; i<bit.length; i++) {
			bit[i]=9;
		}
		
		k=0;
		subset(bit, n, k);
	}
	
	public static void subset(int bit[], int n, int k) {
		if(k==n) {
			for(int i=0; i<bit.length; i++) {
				System.out.print(bit[i]);
			}
			System.out.println();
		
		}else {
			//k번째 원소 포함안한단 뜻
			bit[k]=0;
			subset(bit, n, k+1);
			
			//k번째 원소 포함한단 뜻
			bit[k]=1;
			subset(bit, n, k+1);
		
		
		}
		
	}
	

}
