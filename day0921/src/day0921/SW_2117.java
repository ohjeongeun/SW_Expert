package day0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_2117 {
	static int T;
	static int N;// 도시의 크기
	static int M;// 하나의 집 지불 비용
	static int map[][];
	static int visited[][];
	static Queue<Integer> xq;
	static Queue<Integer> yq;
	// 우 하 좌 상
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int K;
	static int num;
	static int arr[];
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			xq = new LinkedList<>();
			yq = new LinkedList<>();

			int max = 0;
			result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					visited = new int[N][N];
					num = 0;
					K = 1;
					arr = new int[40];
					bfs(i, j);

					for (int q = 0; q < arr.length; q++) {
						if (M*arr[q]-((q*q)+(q-1)*(q-1))>0 && max<arr[q]) {
							max = arr[q];
						}
					}
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}

	public static void bfs(int y, int x) {
		yq.add(y);
		xq.add(x);
		visited[y][x] = 1;

		while (!xq.isEmpty()) {

			int qsize = xq.size();
			for (int k = 0; k < qsize; k++) {

				int cury = yq.remove();
				int curx = xq.remove();
				if (map[cury][curx] == 1) num++;

				for (int i = 0; i < 4; i++) {
					int nexty = cury + dy[i];
					int nextx = curx + dx[i];

					if (nexty < 0 || nextx < 0 || nexty >= N || nextx >= N)
						continue;

					if (visited[nexty][nextx] == 1)
						continue;

					yq.add(nexty);
					xq.add(nextx);
					visited[nexty][nextx] = 1;
				}

			}
			arr[K] = num;
			K++;

		}
	}
}
