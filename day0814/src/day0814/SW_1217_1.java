package day0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1217_1 {
	static int T;
	static int N;
	static int M;
	static int memo[];
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			while (st.hasMoreTokens()) {
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
			}
			
			result = recursive(N, M);
			
			System.out.println("#" + T + " " + result);

		}

	}
	
	
	public static int recursive(int n,int m) {
		
		if(m==0) return 1;
		
		
		return n * recursive(n, m-1);
		
	
	}

}
