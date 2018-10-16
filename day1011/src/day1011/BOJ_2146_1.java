package day1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146_1 {
	static int N;
	static int map[][];
	static int visited[][];
	static Queue<Node> q;
	static Queue<Node> q2; 
	
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	static int min=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new int[N][N];
		q = new LinkedList<>();
		q2 = new LinkedList<>();
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = 100;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]==0 && map[i][j]==1) {
					findStart(i, j);
					bfs();
					for(int ii=0; ii<N; ii++) {
						for(int jj=0; jj<N; jj++) {
							System.out.print(visited[ii][jj]+" ");
						}
						System.out.println();
					}
					System.out.println();
					visited = new int[N][N];
					q2 = new LinkedList<>();
				}
			}
		}
		
		System.out.println(min);
		/*for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}*/
		
	}
	
	public static void findStart(int y, int x) {
		visited[y][x]=1;
		q.add(new Node(y, x));
		q2.add(new Node(y, x));
		
		while(!q.isEmpty()) {
			int cury = q.peek().y;
			int curx = q.peek().x;
			q.remove();
			
			for(int i=0; i<4; i++) {
				int ny = cury+dy[i];
				int nx = curx+dx[i];
				
				//경계선이면 다음
				if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
				
				if(visited[ny][nx]==0 && map[ny][nx]==1) {
					visited[ny][nx]=1;
					q.add(new Node(ny, nx));
					q2.add(new Node(ny, nx));
				}
			}
		}
	}
	
	
	public static void bfs() {
		
		while(!q2.isEmpty()) {
			int cury = q2.peek().y;
			int curx = q2.peek().x;
			q2.remove();
			
			for(int i=0; i<4; i++) {
				int ny = cury+dy[i];
				int nx = curx+dx[i];
				
				//경계선이면 다음
				if(ny<0 || nx<0 || ny>=N || nx>=N) continue;

				//방문한곳이면
				if(visited[ny][nx]>0) continue;
				
				
				//
				if(visited[ny][nx]==0 && map[ny][nx]==1) {
					min = Math.min(min, (visited[cury][curx]-1));
					//System.out.println(ny+" "+nx+" "+(visited[cury][curx]-1));
					return;
				}
				
				visited[ny][nx] = visited[cury][curx]+1;
				q2.add(new Node(ny, nx));
				
			}
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
