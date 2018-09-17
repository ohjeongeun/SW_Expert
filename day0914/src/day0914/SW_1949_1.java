package day0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1949_1 {
	static int T;
	static int N;
	static int K;
	static int map[][];
	static int visited[][];
	static Queue<int[]> q;
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
			q = new LinkedList<>();
			visited = new int[N][N];
			bfs(2, 3);
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(visited[i][j]);
				}
				System.out.println();
			}
			
		}
		
	}
	
	public static void bfs(int y, int x) {
		int tmp2[] = {y, x};
		q.add(tmp2);
		visited[y][x]=1;
		
		while(!q.isEmpty()) {
			int tmp3[] = q.remove();
			int cury = tmp3[0];
			int curx = tmp3[1];
			
 			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(visited[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			
			//이웃점 찾기
			for(int i=0; i<4; i++) {
				int ny = cury+dy[i];
				int nx = curx+dx[i];
				
				//경계점이면
				if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
				
				//방문했었으면
				if(visited[ny][nx]>0) continue;
				
				//현재점보다 값이 크면
				if(map[cury][curx] <= map[ny][nx] ) {
					
					//공사하면 내리막길이니?
					if(map[cury][curx] > map[ny][nx]-K) {
						map[ny][nx]-=K;
						
					}else {
						continue;
					}
					
				}
				
				visited[ny][nx]= visited[cury][curx]+1;
				int tmp4[] = {ny, nx}; 
				q.add(tmp4);
				
				

				
				
				
			}
		
			
			
			
			
			
		}
		
		
	}
	

}
