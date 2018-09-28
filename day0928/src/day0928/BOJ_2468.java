package day0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2468 {
	static int N;
	static int map[][];
	static int visited[][];
	
	static int dy[] = {0, 1, 0, -1};
	static int dx[] = {1, 0, -1, 0};
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st = null;
		
		int maxValue=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(maxValue<map[i][j]) {
					maxValue = map[i][j];
				}
			}
		}
		
		int maxResult=1;
		for(int k=1; k<=maxValue; k++) {
			visited = new int[N][N];
			result=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]>k && visited[i][j]==0) {
						dfs(i, j, k);
						result++;
					}
				}
			}
			maxResult = Math.max(result, maxResult);
			
		}
		
		
		System.out.println(maxResult);
		

	}

	public static void dfs(int y, int x, int p) {
		visited[y][x]=1;
		
		for(int i=0; i<4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
			
			if(visited[ny][nx]==0 && map[ny][nx]> p) {
				dfs(ny, nx, p);
			}
			
		}
		
	}
	
}
