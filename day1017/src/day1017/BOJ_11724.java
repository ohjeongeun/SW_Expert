package day1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724 {
	static int N; //정점
	static int M; //간선
	static Queue<Integer> q;
	static int visited[];
	static int adj[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new int[N+1][N+1]; //인접행렬
		visited = new int[N+1]; //방문배열
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u][v]=1;
			adj[v][u]=1;
			
		}
		
		q = new LinkedList<>();
		
		int cnt=0;
		for(int i=1; i<=N; i++) {
			if(visited[i]==0) {
				bfs(i);
				cnt++; //연결요소 count
			}
		}
		
		System.out.println(cnt);
		
	}
	
	public static void bfs(int v) {
		q.add(v);
		visited[v]=1;
		
		
		while(!q.isEmpty()) {
			
			int cur = q.remove();
			
			for(int i=1; i<=N; i++) {
				int next = adj[cur][i];
				
				if(next==1 && visited[i]==0) {
					q.add(i);
					visited[i]=1;
				}
			}
		}
	}
}
