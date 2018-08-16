package day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_BFS {
	
	static int N; //수빈
	static int K; //동생
	static int visited[];
	static int dx[];
	static Queue<Integer> queue;
	static int depth;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());	
		}
		
		//dx = new int[]{N-1, N+1, 2*N};
		visited = new int[200001];
		queue = new LinkedList<>();
		depth=0;
		bfs(N, K);
		System.out.println(depth);
		br.close();
	}
	
	public static void bfs(int x, int K) {
		//수빈이 초기 위치
		queue.add(x);
		visited[x] =1;
		
		//수빈이 현재 위치
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			for(int dep=0; dep<size; dep++) {
				
				int v = queue.remove();
				if(v==K) {
					return;
				}
				
				dx = new int[]{v-1, v+1, 2*v};
				//수빈이의 다음 위치
				for(int i=0; i<3; i++) {
					int nv = dx[i];
					
					if(0>=nv || nv>100001) {
						continue;
					}
					
					//방문한적 없으면 
					if(visited[nv]==0) {
						visited[nv]=1;
						queue.add(nv);	
					}
				}
			}
			depth++;
		}
	}
}
