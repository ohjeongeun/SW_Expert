package day0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2583 {
	static int M;
	static int N;
	static int K;
	static int map[][];
	static int visited[][];
	
	static int dy[] = {0, 1, 0, -1};
	static int dx[] = {1, 0, -1, 0};
	
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new int[M][N];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int leftx = Integer.parseInt(st.nextToken());
				int lefty = Integer.parseInt(st.nextToken());
				
				int rightx = Integer.parseInt(st.nextToken())-1;
				int righty = Integer.parseInt(st.nextToken())-1;
				
				//장애물 생성
				for(int p=lefty; p<=righty; p++) {
					for(int q=leftx; q<=rightx; q++) {
						map[p][q]=1;
					}
				}
				
			}
			
		}
		
		ArrayList<Integer > list = new ArrayList<>();
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]==0 && map[i][j]==0) {
					cnt=1;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	
	}
	
	public static void dfs(int y, int x) {
		visited[y][x]=1;
		
		for(int i=0; i<4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(ny<0 || nx<0 || ny>=M || nx>=N) continue;
			
			if(visited[ny][nx]==1) continue;
			
			if(map[ny][nx]==1) continue;
			
			cnt++;
			dfs(ny, nx);
			
			
		}
		
	}
	
}
