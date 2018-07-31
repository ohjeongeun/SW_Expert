package day0609;

import java.util.Scanner;


public class SW_4408_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		for(int t=0; t<T; t++) {
			int room[] = new int[400];
			
			int N = sc.nextInt();
			
			int start[] = new int[N];
			int end[] = new int[N];
			for(int i=0; i<N; i++) {
				
				start[i] = sc.nextInt();
				end[i] = sc.nextInt();

			}
			
			int cnt=1;
			for(int i=0; i<N; i++) {
				for(int j=start[i]; j<=end[i]; j++) {
					if(room[j]==1) {
						cnt++;
						break;
					}else {
						room[j]=1;
					}
	
				}
			}
			
			System.out.println("#"+T+" "+cnt);
		}
	}

}
