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
	
					//우 하 좌 상
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	static int ans;
	
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
		alphabet[board[0][0].charAt(0)-64]=1;
		ans=0;
		dfs(0, 0, 1);
		System.out.println(ans);
		
	} 
	
	public static void dfs(int y, int x, int cnt) {

		ans = Math.max(ans, cnt);
		
		//next지점 탐색
		for(int i=0; i<4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			//board 벗어나면
			if(ny<0 || nx<0 || ny>=R || nx>=C) continue;
			
			//nex지점 알파벳의 인덱스
			int p = board[ny][nx].charAt(0)-64;
			
			//중복된 알파벳이면
			if(alphabet[p]==1) continue;
			
			alphabet[p]=1;
			dfs(ny, nx, cnt+1);
			
			// dfs 호출 후 
			// 호출 전 방문한 지점의 알파벳을 방문하지 않은것으로 처리 
			// => 다른 경로로 가는 경우도 모두 구하기 위해
			alphabet[p]=0;
			
		}
		
		
	}

}
