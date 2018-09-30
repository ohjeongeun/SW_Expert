package day1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589 {
	static int N;
	static int M;
	static String map[][];
	static int visited[][];
	static Queue<Integer> xq;
	static Queue<Integer> yq;
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int len;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new String[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = Character.toString(s.charAt(j));
			}
		}
		
		xq = new LinkedList<>();
		yq = new LinkedList<>();
		
		len=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j].equals("L")) {
					visited = new int[N][M];
					bfs(i, j);
				}
			}
		}

		System.out.println(len);		
		
		
	}
	
	public static void bfs(int y, int x) {
		yq.add(y);
		xq.add(x);
		
		while(!xq.isEmpty()) {
			int cury = yq.remove();
			int curx = xq.remove();
			
			for(int i=0; i<4; i++) {
				int ny = cury+dy[i];
				int nx = curx+dx[i];
				
				if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
				
				if(visited[ny][nx]>0) continue;
				
				if(map[ny][nx].equals("W")) continue;
				
				xq.add(nx);
				yq.add(ny);
				visited[ny][nx] = visited[cury][curx]+1;
				len = Math.max(len, visited[ny][nx]);
			}
			
			
			
			
		}
		
	}

}
