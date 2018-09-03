package day0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SW_1249 {
	static int T;
	static int N;
	static int map[][];
	static int visited[][];
	static PriorityQueue<Node> pq;
					//우 하 좌 상
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new int[N][N];
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = s.charAt(j)-'0';
					
				}
			}
			
			result=0;
			pq = new PriorityQueue<>();
			bfs(new Node(0, 0, 0));
			System.out.println("#"+t+" "+result);
		}
		
	}
	
	public static void bfs(Node start) {
		visited[start.y][start.x]=1;
		pq.add(start);
		
		while(!pq.isEmpty()) {
			
			Node cur = pq.poll();
			int cury = cur.y;
			int curx = cur.x;
			
			if(cury==N-1 && curx==N-1) {
				result = cur.cost;
				return;
			}
			
			for(int index=0; index<4; index++) {
				
				int ny = cury+dy[index];
				int nx = curx+dx[index];
				
				if(ny<0 || nx<0 || ny>N-1 || nx>N-1) continue;
				
				
				if(visited[ny][nx]==0) {
					visited[ny][nx]=1;
					pq.add(new Node(ny, nx, cur.cost+map[ny][nx]));
				
				}
				
			}
			
			
		}
		
		
		
		
	}
	

}

class Node implements Comparable<Node> {
	int y, x, cost;
	Node(int y, int x, int cost) {
		this.y = y;
		this.x = x;
		this.cost = cost;
	}
	@Override
	public int compareTo(Node node) {
		
		//양수면 내림차순, 음수면 오름차순
		return cost - node.cost;
	}
}
