package day0927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11403_1 {
	static int N;
	static int adj[][];
	static int visited[];
	static int result[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		adj = new int[N+1][N+1];
		visited = new int[N+1]; //각 i의 인접 노드(j) 방문 체크
		result = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=1; i<=N; i++) {
			dfs(i);
			for(int j=1; j<=N; j++) {
				result[i][j] = visited[j];
			}
			Arrays.fill(visited, 0);
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	public static void dfs(int node) {
		//System.out.println(list);
		
		for(int j=1; j<=N; j++) {
			if(visited[j]==0 && adj[node][j]==1) {
				visited[j]=1;
				dfs(j);
			}
		}
		
	}
	

}
