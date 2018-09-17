package day0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1949 {
	static int T;
	static int N;
	static int K;
	static int map[][];
	static int visited[][];
					//우 하 좌 상
	static int dy[] = {0, 1, 0, -1};
	static int dx[] = {1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T= Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			int max=-1;
			map = new int[N][N];

			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int c = Integer.parseInt(st.nextToken());
					if(max<c) {
						max = c;
					}
					map[i][j] = c;
				}
			}

			LinkedList<int[]> list = new LinkedList<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]==max) {
						int tmp[] = {i, j};
						list.add(tmp);
					}
				}
			}
			
			/*while(!list.isEmpty()) {
				int tmp1[] = list.removeFirst();
				int y = tmp1[0];
				int x = tmp1[1];
				
				q = new LinkedList<>();
				visited = new int[N][N];
				bfs(y, x);
				
			}*/
			visited = new int[N][N];
			
			
			dfs(2,4,1,map[2][4],true);
			// 공사안함
			//dfs(2, 3, 1, map[2][3], true);
			
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(visited[i][j]);
				}
				System.out.println();
			}
			
		}
		
	}
	
	public static void dfs(int y, int x, int len, int pre, boolean flag) {
		visited[y][x]=1;
		System.out.println(len);
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		
		for(int i=0; i<4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
			
			if(visited[ny][nx]==1) continue;
			
			
			//아직 공사x (flag==true)
			if(flag) {
				//내리막 (현재 > next)
				if(map[y][x] > map[ny][nx]) {
					dfs(ny, nx, len+1, map[ny][nx], true);
					
				//평면, 오르막	
				}else {
					//k만큼 빼도 부족할경우
					if(map[y][x] > map[ny][nx]-K) {
						dfs(ny, nx, len+1, map[y][x]-1, false);
					}
					
				}
			//이미 공사o (flag==false)
			}else {
				//내리막길
				if(pre>map[ny][nx]) {
					dfs(ny, nx, len+1, map[ny][nx], false);
				}
			}
			
			
			
			//공사o
			
			
			
			//if(map[y][x] <= map[ny][nx]) continue;
			
			//dfs(ny,nx);
			visited[ny][nx]=0;
			
		}
		
		
	}
	

}
