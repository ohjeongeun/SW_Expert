package day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1697_DFS {
	static int N;// ¼öºó
	static int K;// µ¿»ý
	static int dx[];
	static int visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
		}

		visited = new int[200001];
		// dx = int[]{};
		dfs(N, K);
	}

	public static void dfs(int n, int k) {

		if (n == k) {
			return;
		}
		visited[n] = 1;
		System.out.println(n);

		dx = new int[] { n - 1, n + 1, 2 * n };
		for (int i = 0; i < dx.length; i++) {
			int nv = dx[i];

			if (nv < 0 || nv > 200001) {
				continue;
			}

			if (visited[nv] == 0) {
				dfs(nv, k);
			}

		}

	}

}
