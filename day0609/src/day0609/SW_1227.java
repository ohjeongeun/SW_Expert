package day0609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW_1227 {

	static String T;
	static int map[][];
	static int visited[][];
	static Queue<int[]> q;
	                 //©Л   го      аб   ╩С
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int t=0; t<10; t++) {
			T=br.readLine();
			
			map = new int[100][100];
			visited = new int[100][100];
			
			for(int i=0; i<100; i++) {
				String s = br.readLine();
				for(int j=0; j<100; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			result=0;
			solve();
			
			
			System.out.println("#"+T+" "+result);
		}
	}
	
	public static void solve() {
		q = new LinkedList<int[]>();
		
		int start[] = {1, 1};
		q.add(start);
		visited[1][1] = 1;
		
		while(!q.isEmpty()) {
			int t[] = q.poll();
			int y = t[0];
			int x = t[1];
			
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(map[ny][nx]==3) {
					result=1;
					return;
				}
				
				if(ny < 0 || ny > 99 || nx < 0 || nx > 99) {
					continue;	
				}
				
				if(visited[ny][nx]==0 && map[ny][nx]==0) {
					int u[] = {ny, nx};
					q.add(u);
					visited[ny][nx]=1;
				}

				
			}
			
			
		}	
		
	}

}
