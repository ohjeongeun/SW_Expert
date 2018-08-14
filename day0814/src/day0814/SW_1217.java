package day0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1217 {
	static int T;
	static int N;
	static int M;
	static int memo[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			while (st.hasMoreTokens()) {
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
			}

			memo = new int[M + 1];

			memo[0] = 1;
			memo[1] = N;
			for (int i = 2; i < M + 1; i++) {
				memo[i] = (int) Math.pow(memo[1], i);
			}

			
			System.out.println("#" + T + " " + memo[M]);

		}

	}
	

}
