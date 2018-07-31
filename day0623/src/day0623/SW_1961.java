package day0623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1961 {

	static int T;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			n = Integer.parseInt(br.readLine());
			int mat[][] = new int[n][n];
			int mat1[][] = new int[n][n];
			int mat2[][] = new int[n][n];
			int mat3[][] = new int[n][n];
			
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int j=0;
				while(st.hasMoreTokens()) {
					mat[i][j] = Integer.parseInt(st.nextToken());
					j++;
				}
			}
			
			solve(mat, mat1);
			solve(mat1, mat2);
			solve(mat2, mat3);
			
			System.out.println("#"+t);
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(mat1[i][j]);
				}
				System.out.print(" ");
				for(int j=0; j<n; j++) {
					System.out.print(mat2[i][j]);
				}
				System.out.print(" ");
				for(int j=0; j<n; j++) {
					System.out.print(mat3[i][j]);
				}
				System.out.println();
			
			}
		}
	}
	
	public static void solve(int mat[][], int mat1[][]) {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				mat1[j][n-1-i] = mat[i][j]; 
			}
		}
	}
}
