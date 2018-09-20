package day0920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW_1949 {
	static int T;
	static int N;
	static int K;
	static int map[][];
	static LinkedList<Integer> startX;
	static LinkedList<Integer> startY;
						//우 하 좌 상
	static int dy[] = {0, 1, 0, -1};
	static int dx[] = {1, 0, -1, 0};
	static int visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			//insert data, find startPoint
			int startPoint = 0;
			map = new int[N][N];
			visited = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(startPoint<map[i][j]) {
						startPoint = map[i][j];
					}
				}
			}
			
			//add startPoint
			startY = new LinkedList<>();
			startX = new LinkedList<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]==startPoint) {
						startY.add(i);
						startX.add(j);
					}
				}
			}
			
			/*while(startY.isEmpty()) {
				int y = startY.removeFirst();
				int x = startX.removeFirst();
				dfs(y, x, 0, false);
			}*/
			dfs(2, 4, 100, 1, false);
			
			System.out.println("#"+t+" ");
		}
		
	}
	
	public static void dfs(int curY, int curX, int nextValue, int len, boolean flag) {
		
		visited[curY][curX] = 1;
		System.out.println(curY+" "+ curX+"  "+len);
		
		for(int i=0; i<4; i++) {
			int nextY = curY+dy[i];
			int nextX = curX+dx[i];
			
			//경계 밖이면 넘어감
			if(nextY < 0 || nextX < 0 || nextY >=N || nextX >= N) continue;
			
			//방문한적 있으면 넘어감
			if(visited[nextY][nextX]==1) continue;
			
			//내리막길이면
			if(map[curY][curX] > map[nextY][nextX]) {
				dfs(nextY, nextX, map[nextY][nextX], len+1, false);
				
			}
			
			//같으면
			else if(map[curY][curX] == map[nextY][nextX]) {
				//아직 공사한적 없으면
				if(flag==false) {
					dfs(nextY, nextX, map[nextY][nextX]-1, len+1, true);
				}else {
					return; //같은데 이미 공사했으면 종료.
				}
				
			}
			//오르막길이면
			else if(map[curY][curX] < map[nextY][nextX]) {
				//아직 공사한적 없는지? K만큼 깎아서 될 일인지?
				if(flag==false && map[curY][curX] > map[nextY][nextX]-K) {
					dfs(nextY, nextX, map[nextY][nextX]-1, len+1, true);
				}else {
					return; //오르막길인데 이미 공사했으면 종료.
				}
				
				
			}
			
			visited[nextY][nextX]=0;
		}
		
		
		
	}

}
