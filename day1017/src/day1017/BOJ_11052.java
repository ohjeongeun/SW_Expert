package day1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int memo[] = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			
			//memo[4]
			for(int j=0; j<=i; j++) {
				memo[i] = Math.max(memo[i], memo[i-j]+arr[j]);
				
				// memo[4] = memo[4], memo[4]+arr[0]; 7
				// memo[4] = memo[4], memo[3]+arr[1]; 6+1
				// memo[4] = memo[4], memo[2]+arr[2]; 5+5
				// memo[4] = memo[4], memo[1]+arr[3]; 1+6
				// memo[4] = memo[4], memo[0]+arr[4]; 0+7
			
			 
			
			}
			
		}
		
		/*for(int i=1; i<=N; i++) {
			System.out.print(memo[i]+" ");
		}*/
		
		System.out.println(memo[N]);
		
	}
}
