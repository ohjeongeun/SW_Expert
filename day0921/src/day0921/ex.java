package day0921;

public class ex {
	public static void main(String[] args) {
		
		int K=7;
		int big[][] = new int[10][10];
		int map[][] = new int[2*K-1][2*K-1];
		
		for(int i=0; i<K; i++) {
			if(i<K) {
				for(int j=K-1-i; j<=K-1+i; j++) {
					map[i][j]=1;
				}
			}
		}
		for(int i=2*K-2; i>=K; i--) {
			for(int j=i-(K-1); j<=3*(K-1)-i; j++) {
				System.out.println(i+" "+j);
				map[i][j]=1;
			}
		}
	
		//Ãâ·Â
		for(int i=0; i<2*K-1; i++) {
			for(int j=0; j<2*K-1; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	
	
	}
}
