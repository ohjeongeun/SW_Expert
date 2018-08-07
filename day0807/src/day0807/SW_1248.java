package day0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1248 {
	static int T;
	static int V;
	static int E;
	static int A;
	static int B;
	static int tree[][];
	static int visited[];
	static String result1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				V = Integer.parseInt(st.nextToken());//정점의 총 수
				E = Integer.parseInt(st.nextToken());//간선의 총 수
				
				//자식들
				A = Integer.parseInt(st.nextToken());
				B = Integer.parseInt(st.nextToken());
			
			}
			
			tree = new int[V+1][V+1];
			visited = new int[V+1];
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				tree[p][c]=1;
				
			}
			
			int cnt=0;
			
			for(int i=0; i<V+1; i++) {
				for(int j=0; j<V+1; j++) {
					if(tree[i][j]==1) {
						cnt++;
					}
					if(cnt==2) {
						result1="";
						System.out.println(i);
						dfs(i);
					}
				}
			}
			//dfs(1);
			
			
			System.out.println("#"+t);
			System.out.println(result1);
/*			for(int i=0; i<V+1; i++) {
				for(int j=0; j<V+1; j++) {
					System.out.print(tree[i][j]);
				}
				System.out.println();
			}*/
			
			
			
		}
		
		
		
	}
	
	public static void dfs(int v) {
		visited[v]=1;
		result1 += String.valueOf(v)+" ";
		
		for(int j=0; j<V+1; j++) {
			if(tree[v][j]==1 && visited[j]==0) {
				dfs(j);
			}
		}
		
	}
	
	
}
