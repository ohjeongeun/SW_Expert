/*package day1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146 {
	static int N;
	static int map[][];
	static int visited[][];
	
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new int[N][N];
		
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[4][3]=1;
		dfs(4, 3);
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	public static void dfs(int y, int x) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N)
				continue;

			if (visited[ny][nx] > 0)
				return;

			if (map[ny][nx] == 1) {
				System.out.println("µµÂø"+" "+visited[y][x]);
				return;
			}
			visited[ny][nx] = visited[y][x] + 1;
			dfs(ny, nx);
			visited[ny][nx]=0;
		}

	}	

}

class Node {
	int y, x;
	public Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
*/