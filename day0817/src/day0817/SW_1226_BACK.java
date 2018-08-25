package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_1226_BACK {
	static int T;
	static int map[][];
	static int visited[][];
					//우 하 좌 상
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			T = Integer.parseInt(br.readLine());
			
			map = new int[16][16];
			visited = new int[16][16];
			
			for(int i=0; i<16; i++) {
				String s = br.readLine();
				for(int j=0; j<16; j++) {
					map[i][j] = s.charAt(j)-'0';
				}
			}
			
			
			result=0;
			visited[1][1]=1;
			dfs(1, 1);
			
			System.out.println("#"+T+" "+result);
		}
		
	}
	
	public static void dfs(int y, int x) {
		
		for(int i=0; i<16; i++) {
			for(int j=0; j<16; j++) {
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		//다음점
		for(int i=0; i<4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(map[ny][nx]==3) {
				result=1;
				return;
			}
			
			
			//범위 안이면
			if(0<=ny && ny<=15 && 0<=nx && nx <=15) {
				//방문한적 없고 길이면
				if(visited[ny][nx]==0 && map[ny][nx]==0) {
					visited[ny][nx] = 1;
					dfs(ny, nx);
					visited[ny][nx] = 0;
				}
			}
		}
	}
}
