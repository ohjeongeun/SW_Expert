package day0609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW_1226 {

	static String T;
	static int map[][];
	static Queue<int[]> q;
	static int visited[][];
	                //우   하     좌     상
	static int dx[]= {1, 0, -1, 0};
	static int dy[]= {0, 1, 0, -1};
	
	static int result;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<10; t++) {
			T = br.readLine();
			
			map = new int[16][16];
			
			for(int i=0; i<16; i++) {
				String s = br.readLine();
				
				for(int j=0; j<16; j++) {
					map[i][j] = s.charAt(j)-'0';
				}
			}
			
			result=0;
			solve();
			
			System.out.println("#"+T+" "+result);
		}
	}
	
	public static void solve() {
		q = new LinkedList<int[]>();
		visited = new int[16][16];
		
		int temp[] = {1, 1};
		q.add(temp);
		visited[1][1] = 1;
		
		while(!q.isEmpty()) {
			
			//큐의 첫번째 원소 반환
			int t[] = q.poll(); //t[] = {1, 1}
			for(int i=0; i<16; i++) {
				for(int j=0; j<16; j++) {
					System.out.print(visited[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			int y = t[0];
			int x = t[1];
			
			//이웃점 탐색
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(map[ny][nx]==3) {//도착
					result=1;
					return;
				}
				
				/*if(ny<0 || ny>15 || nx<0 || nx>15) {//가장자리인지?
					continue;
				}*/
				
				
				if(visited[ny][nx]==0 && map[ny][nx]==0) {//방문않고 길이면
					int tmp[] = {ny, nx};
					q.add(tmp);
					visited[ny][nx]=1;
					
				}
				
			}
			
		}
		
	}

}
