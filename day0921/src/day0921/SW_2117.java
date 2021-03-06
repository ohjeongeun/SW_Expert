package day0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_2117 {
	static int T;
	static int N;// 도시의 크기
	static int M;// 하나의 집 지불 비용
	static int map[][];
	static int visited[][];
	static Queue<Node> q;
						// 우 하 좌 상
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static class Node{
		int y, x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}


			int max = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					max = Math.max(max, bfs(i, j));
					/*for(int ii=0; ii<N; ii++) {
						for(int jj=0; jj<N; jj++) {
							System.out.print(visited[ii][jj]);
						}
						System.out.println();
					}
					System.out.println();*/
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}

	public static int bfs(int y, int x) {
		q = new LinkedList<>();
		visited = new int[N][N];
		
		q.add(new Node(y, x));
		visited[y][x] = 1;

		
		int sum = 0; //집의 합
		if(map[y][x]==1) { //시작점에 집 있으면 sum도 1
			sum=1;
		}
		
		int cost=0;
		int K = 1; //운영비용(depth)
		int result = 0; //한 판의 '최대 집 수' 저장할 변수
		
		while (!q.isEmpty()) {
			
			if(K>N) break; //K가 배열크기 넘을 수 없음
	
			K++;
			cost = K*K + (K-1)*(K-1);
			
			int qsize = q.size();
			for (int k = 0; k < qsize; k++) {

				int cury = q.peek().y;
				int curx = q.peek().x;
				q.remove();
				
				for (int i = 0; i < 4; i++) {
					int nexty = cury + dy[i];
					int nextx = curx + dx[i];

					if (nexty < 0 || nextx < 0 || nexty >= N || nextx >= N) continue;
					
					
					if (visited[nexty][nextx] == 1)
						continue;

					if (map[nexty][nextx] == 1) sum++;
					
					q.add(new Node(nexty, nextx));
					visited[nexty][nextx] = 1;
				}

			}
			
			if(M*sum-cost>=0) result=sum;
			
			
		}
		
		return result;
	}
}
