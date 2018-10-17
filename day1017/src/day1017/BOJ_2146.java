//시간초과!
package day1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146 {
	static int N;
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int map[][];
	static int visited[][];
	static int area[][];
	static Queue<Node> q;
	static LinkedList<Node> edge;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		map = new int[N][N]; //인풋데이터
		visited = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
		//지역
		q = new LinkedList<>();
		edge = new LinkedList<>();
		int num=1;
		area = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1&& area[i][j]==0) {
					bfs(i, j, num);
					num++;
				}
			}
		}
		
		//출력Test
		/*for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}*/
		
		System.out.println(getLength());
		
	}
	
	public static int getLength() {
		int min=Integer.MAX_VALUE;
		
		
		while(!edge.isEmpty()) {
			
			int vy = edge.peek().y;
			int vx = edge.peek().x;
			int vnum = area[vy][vx];
			edge.remove();
			
			for(int i=0; i<edge.size(); i++) {
				int uy = edge.get(i).y;
				int ux = edge.get(i).x;
				int unum = area[uy][ux];
				
				if(unum!=vnum) {
					min = Math.min(min, Math.abs(vy-uy)+Math.abs(vx-ux)-1);
					
				}
			}
			
		}
		return min;
		
	}
	
	
	public static void bfs(int y, int x, int num) {
		//1. 넘버링
		q.add(new Node(y, x));
		area[y][x]=num;
		
		while(!q.isEmpty()) {
			int cury = q.peek().y;
			int curx = q.peek().x;
			q.remove();
			
			for(int i=0; i<4; i++) {
				int ny = cury+dy[i];
				int nx = curx+dx[i];
				
				if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
				
				//1. 넘버링
				if(area[ny][nx]==0 && map[ny][nx]==1) {
					q.add(new Node(ny, nx));
					area[ny][nx]=num;
				}
				
				//2. 그 중 바다에 가까운 야들만
				if(map[ny][nx]==0 && visited[cury][curx]==0) {
					edge.add(new Node(cury, curx));
					visited[cury][curx]=1;
				}
				
			}
			
			//2. 그 중 바다에 가까운 야들만
			/*for(int i=0; i<4; i++) {
				int ny = cury+dy[i];
				int nx = curx+dx[i];
				
				if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
				
				//가장자리(바다옆) 좌표 찾기
				if(map[ny][nx]==0 && visited[cury][curx]==0) {
					edge.add(new Node(cury, curx));
					visited[cury][curx]=1;
				}
				
			}*/
			
			
		}
		
	}
	
	
}

class Node {
	int y, x;
	public Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
