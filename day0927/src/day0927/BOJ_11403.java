package day0927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11403 {
	static int N;
	static int adj[][];
	static int visited[][];
	static int result[][];
	static LinkedList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		adj = new int[N+1][N+1];
		visited = new int[N+1][N+1];
		result = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=1; i<=N; i++) {
			list = new LinkedList<>();
			list.add(i);
			dfs(i);
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
		if(list.size()>1) {
			int p = list.getFirst();
			int c = list.getLast();
			result[p][c]=1;
		}
		
		for(int j=1; j<=N; j++) {
			if(visited[node][j]==0 && adj[node][j]==1) {
				list.add(j);
				visited[node][j]=1;
				dfs(j);
				list.removeLast();
				visited[node][j]=0;
			}
		}
		
	}
	

}
