package day0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_1 {
	static int M; //가로
	static int N; //세로
	static int H; //상자 수
	static int box[][][];
	static int visited[][][];
	static Queue<Integer> xq;
	static Queue<Integer> yq;
	static Queue<Integer> zq;
	static int day;
					//위 아래 우 하 좌 상
	static int dx[] = {0, 0, 1, 0, -1, 0};
	static int dy[] = {0, 0, 0, 1, 0, -1};
	static int dz[] = {-1, 1, 0, 0, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box = new int[H][N][M];
		visited = new int[H][N][M];
		
		xq = new LinkedList<>();
		yq = new LinkedList<>();
		zq = new LinkedList<>();
		for(int k=0; k<H; k++) {
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					box[k][i][j] = Integer.parseInt(st.nextToken());
					if(box[k][i][j]==1) {
						zq.add(k);
						yq.add(i);
						xq.add(j);
						visited[k][i][j]=1;
					}else if(box[k][i][j]==-1) {
						visited[k][i][j]=-1;
					}
				}
			}
			
		}
		
		day=0;
		bfs();
		for(int k=0; k<H; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visited[k][i][j]==0) {
						System.out.println(-1);
						return;
					}
				}
			}
			
		}
		
		System.out.println(day);
		
		
		
	}
	
	public static void bfs() {
		
		while(!xq.isEmpty()) {
			int curz = zq.remove();
			int cury = yq.remove();
			int curx = xq.remove();
			
			for(int i=0; i<6; i++) {
				int nz = curz+dz[i];
				int ny = cury+dy[i];
				int nx = curx+dx[i];
				
				
				if(nz<0 || ny<0 || nx<0 || nz>=H || ny>=N || nx>=M) continue;
				
				if(visited[nz][ny][nx]>=1) continue;
				
				if(box[nz][ny][nx]==-1) continue;
				
				visited[nz][ny][nx] = visited[curz][cury][curx] + 1;
				day = Math.max(day, visited[nz][ny][nx]-1);
				zq.add(nz);
				yq.add(ny);
				xq.add(nx);
				
			}
			
			
			
			
			
		}
		
	}

}
