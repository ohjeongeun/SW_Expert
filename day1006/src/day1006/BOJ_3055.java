package day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055 {
	static int R;
	static int C;
	static String map[][];
	static int visited[][];
	static Queue<Node> q;
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new String[R][C];
		visited = new int[R][C];
		
		String s="";
		for(int i=0; i<R; i++) {
			s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = Character.toString(s.charAt(j));
			}
		}
		
		q = new LinkedList<>();
		
		int destY=0;
		int destX=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				
				if(map[i][j].equals("D")) {
					destY=i;
					destX=j;
				}
				
				//물을 먼저 넣음
				if(map[i][j].equals("*")) {
					q.add(new Node(i, j));
					//visited[i][j]=1;
				}else if(map[i][j].equals("S")) {
					q.add(new Node(i, j));
					//visited[i][j]=1;
				}
			}
		}
		
		bfs();
		int result = visited[destY][destX];
		if(result==0 ) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(result);
		}
		
		//출력테스트
		/*for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}*/
		
	}
	
	public static void bfs() {
		
		while(!q.isEmpty()) {
			int cury = q.peek().y;
			int curx = q.peek().x;
			q.remove();
			
			for(int i=0; i<4; i++) {
				int ny = cury+dy[i];
				int nx = curx+dx[i];
				
				if(ny<0 || nx<0 || ny>=R || nx>=C) continue;
				
				//출력
				/*for(int k=0; k<R; k++) {
					for(int j=0; j<C; j++) {
						System.out.print(map[k][j]);
					}
					System.out.println();
				}
				System.out.println();*/
				
				
				if(visited[ny][nx]>0) continue;
				
				if(map[ny][nx].equals("X")) continue;
				
				//만약 물인데 비버동굴이면 피함.
				if(map[cury][curx].equals("*")) {
					if(map[ny][nx].equals("D")) {
						continue;
					}
				}
				
				
				//만약 고슴도친데 물있으면 피함.
				if(map[cury][curx].equals("S")) {
					if(map[ny][nx].equals("*")) {
						continue;
					}
				}
				
				q.add(new Node(ny, nx));
				visited[ny][nx] = visited[cury][curx]+1;
				map[ny][nx] = map[cury][curx];
				
				
			}
			
			
			
			
			
			
		}
		
	}
	

}

class Node {
	int y, x;
	public Node(int y, int x) {
		this.y=y;
		this.x=x;
	}
	
}


