package day0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {
	static int M; //가로
	static int N; //세로
	static int H; //상자 수
	static int box[][];
	static int visited[][];
	static Queue<Integer> xq;
	static Queue<Integer> yq;
	static int day;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box = new int[N*H][M];
		visited = new int[N*H][M];
		for(int i=0; i<N*H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j]==-1) {
					visited[i][j]=-1;
				}
			}
			
		}
		
		xq = new LinkedList<>();
		yq = new LinkedList<>();
		for(int i=0; i<N*H; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j]==1 && visited[i][j]==0) {
					visited[i][j]=1;
					xq.add(j);
					yq.add(i);
					//아래 가능
					if(i+N<H*N && box[i+N][j]==0 && visited[i+N][j]==0) {
						xq.add(j);
						yq.add(i+N);
						visited[i+N][j]=2;
					
					}
					
					//위로 가능
					if(i-N>=0 && box[i-N][j]==0 && visited[i-N][j]==0) {
						xq.add(j);
						yq.add(i-N);
						visited[i-N][j]=2;
					}
					
					
				}
				
			}
			
		}
		day=0;
		bfs();
		
		for(int i=0; i<N*H; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}
		
		for(int i=0; i<N*H; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j]==0 && visited[i][j]==0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(day);
		
		
	}
	
	public static void bfs() {
		
		//위, 아래, 우 하 좌 상
		int dx[] = {0, 0, 1, 0, -1, 0};
		int dy[] = {-N, N, 0, 1, 0, -1};
		while(!xq.isEmpty()) {
			int cury = yq.remove();
			int curx = xq.remove();
			
			for(int i=0; i<6; i++) {
				int ny = cury+dy[i];
				int nx = curx+dx[i];
				
				if(ny<0 || nx<0 || ny>=H*N || nx>=M) continue;

				if(box[ny][nx]==-1) continue;
				
				if(visited[ny][nx]>=1) continue;
				
				if(box[ny][nx]==0) {
					visited[ny][nx] = visited[cury][curx]+1;
					day = Math.max(visited[ny][nx]-1, day);
					xq.add(nx);
					yq.add(ny);
				}
				
			}
		}
		
		
	}

}
