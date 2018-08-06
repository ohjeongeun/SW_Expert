package day0609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_4408 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t=0; t<T; t++) {
			int room[] = new int[400]; //0
			
			int N = Integer.parseInt(br.readLine());
			
			int start[] = new int[N];
			int end[] = new int[N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					start[i] = Integer.parseInt(st.nextToken());
					end[i] = Integer.parseInt(st.nextToken());
				}
				
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
