
public class Subset_1 {

	public static void main(String[] args) {
		
		int bit[] = new int[4];
		int arr[] = {1, 2, 3, 4}; 

		for(int i=0; i<=1; i++) {
			bit[0] = (i&1)==0 ? 0 : 1;
			for(int j=0; j<=1; j++) {
				bit[1] = (j&1)==0 ? 0 : 1;
				for(int k=0; k<=1; k++) {
					bit[2] = (k&1)==0 ? 0 : 1;
					for(int l=0; l<=1; l++) {
						bit[3] = (l&1)==0 ? 0 : 1;
						for(int m=0; m<4; m++) {
							if(bit[m]!=0) {
								System.out.print(arr[m]+" ");
							}
						}
						System.out.println();	
					}	
				}	
			}	
		}
	}
}

