package day1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_14502 {
	static int N;
	static int M;
	static int map[][];
	static int visited[][];
	static int dy[] = {0, 1, 0, -1};
	static int dx[] = {1, 0, -1, 0};
	static LinkedList<Integer> startY;
	static LinkedList<Integer> startX;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[N][M];
		
		startY = new LinkedList<>();
		startX = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					startY.add(i);
					startX.add(j);
				}
			}
		}
		
		max=0;
		walls(0, 1, 0);
		System.out.println(max);
		
	}
	
	public static void dfs(int y, int x) {
		
		for(int i=0; i<4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
			
			if(map[ny][nx]==3 || map[ny][nx]==2 || map[ny][nx]==1) continue;
			
			if(visited[ny][nx]==1) continue;
			
			visited[ny][nx]=1;
			dfs(ny, nx);
			//visited[ny][nx]=0;
			
			
		}
		
		
	}
	
	public static void walls(int y, int x, int cnt) {
		if(cnt==3) {
			visited = new int[N][M];
			for(int i=0; i<startX.size(); i++) {
				visited[startY.get(i)][startX.get(i)]=1;
				dfs(startY.get(i), startX.get(i));
			}
			
			//count
			int count=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==0 && visited[i][j]==0) {
						count++;
					}
				}
			}
			max = Math.max(count, max);
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==3 || map[i][j]==1 || map[i][j]==2) continue;
					
				map[i][j]=3; //새로만든벽
				walls(i, j, cnt+1);
				map[i][j]=0;
				
			}
		}
	}
}
