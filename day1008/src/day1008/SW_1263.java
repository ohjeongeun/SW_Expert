package day1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1263 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int adj[][] = new int[N+1][N+1];
			int memo[][] = new int[N+1][N+1];
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					adj[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			

			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					System.out.print(adj[i][j]);
				}
				System.out.println();
			}
			
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(i!=j && adj[i][j]==0) {
						
					}
				}
			}
			

			
			System.out.println("#"+t);
		}
		
	}

}
