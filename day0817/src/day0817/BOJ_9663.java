package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {
	static int N;
	static int board[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		dfs(0, 1);
		
		
	}
	
	public static void dfs(int y, int x) {
		
		
		
	}
	

}
