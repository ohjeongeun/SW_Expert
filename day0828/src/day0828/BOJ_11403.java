package day0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11403 {
	static int N;
	static int adj[][];
	static int visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		adj = new int[N][N];
		visited = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j=0; 
			while(st.hasMoreTokens()) {
				adj[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}
		
		dfs(0);
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}
	}
	
	//고쳐야댐
	public static void dfs(int i) {
		for(int j=0; j<N; j++) {
			//인접정렬 1이고 방문한적 없으면
			if(adj[i][j]==1 && visited[i][j]==0) {
				//방문 시키고
				visited[i][j]=1;
				dfs(j);
			}
		}
		
		
	}
	
}
