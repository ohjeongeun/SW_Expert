package day0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_2105_1 {
	static int T;
	static int N;
	static int map[][];
	static int visited[][];
					//우하  좌하  좌상  우상
	static int dx[] = {1, -1, -1, 1};
	static int dy[] = {1, 1, -1, -1};
	
	static int dessert[];
	
	static Queue<int[]> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			visited = new int[N][N];
			dessert = new int[101];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			q = new LinkedList<>();
			bfs(0, 2);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(visited[i][j]+" ");
				}
				System.out.println();
			}
		}
		
	}
	
	public static void bfs(int y, int x) {
		int start[] = {y, x};
		visited[y][x]=1;
		dessert[map[y][x]]=1;
		q.add(start);
		
		
		while(!q.isEmpty()) {
			int tmp[] = q.remove();
			int cury = tmp[0];
			int curx = tmp[1];
			
			for(int i=0; i<4; i++) {
				int ny = cury + dy[i];
				int nx = curx + dx[i];
				
				//경계지점 넘는지?
				if(ny<0 || nx<0 || ny>=N || nx>=N) continue;

				System.out.println(map[ny][nx]);
				
				
				//이미 먹은 디저트 종륜지?
				if(dessert[map[ny][nx]]==1) continue;
				
				//방문지점인지?
				if(visited[ny][nx]==1) continue;
				
				int tmp1[] = {ny, nx};
				visited[ny][nx]=1;
				dessert[map[ny][nx]]=1;
				q.add(tmp1);
				
			}
			
			
			
			
		}
		
		
		
	}
	

}
