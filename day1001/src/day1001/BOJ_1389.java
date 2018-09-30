package day1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389 {
	static int N;
	static int adj[][];
	static int visited[];
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		adj = new int[N+1][N+1];
		visited = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adj[A][B] = 1;
			adj[B][A] = 1;
			
		}
		
		int b;
		int result[]= new int[N+1];
		q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			Arrays.fill(visited, 0);
			bfs(i);
			b=0;
			for(int j=1; j<visited.length; j++) {
				b+=visited[j]; 
			}
			result[i]=b;
		}
		
		int min=Integer.MAX_VALUE;
		int ans=0;
		for(int j=1; j<=N; j++) {
			if(result[j]<min) {
				min = result[j];
				ans=j;
			}else if(result[j]==min) {
				ans = Math.min(ans, j);
			}
		
		}
		System.out.println(ans);
		
	}
	
	public static void bfs(int v) {
		q.add(v);
		
		while(!q.isEmpty()) {
			int cur = q.remove();
			
			for(int i=1; i<=N; i++) {
				if(visited[i]==0 && adj[cur][i]==1) {
					q.add(i);
					visited[i] = visited[cur]+1;
				}
			}
		}
	}
}
