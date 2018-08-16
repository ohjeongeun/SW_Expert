package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {
	static int R;//세로
	static int C;//가로
	static String board[][];
	static int alphabet[];
	static int visited[][];
	
					//우 하 좌 상
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
		}
		
		board = new String[R][C];
		
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				board[i][j] = s.charAt(j)+"";
			}
		}
		
		//1~26개
		alphabet = new int [27];
		visited = new int[R][C];
		
		cnt=0;
		dfs(0, 0);
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}
		System.out.println(cnt);
		
	}
	
	//갈수있는지 없는지가아니라 최댓값이니까 다른방향도 탐색해봐야함
	public static void dfs(int y, int x) {
		visited[y][x]=1;
		alphabet[board[y][x].charAt(0)-64]=1;
		cnt++;
		
		//다음 점 탐색
		for(int i=0; i<4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			//board 벗어나면
			if(ny<0 || nx<0 || ny>=R || nx>=C) continue;
			
			//방문했던곳 아니고 중복된 알파벳 아니면
			if(visited[ny][nx]==0 && alphabet[board[ny][nx].charAt(0)-64]==0) {
				dfs(ny, nx);
			}
			
		}
		
	}

}
