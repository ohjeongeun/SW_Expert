//실패
package day0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644 {
	
	static int n;
	static int adj[][];
	static int visited[];
	static Queue<Integer> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		
		adj = new int[n+1][n+1];
		visited = new int[n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); //부모
			int y = Integer.parseInt(st.nextToken()); //자식
			
			adj[x][y]=1;
			//adj[y][x]=1;
		}
		
		int result=0;
		q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			Arrays.fill(visited, 0);
			bfs(i);
			if(visited[a]!=0 && visited[b]!=0) {
				result = visited[a]+visited[b];
				break;
			}

		}
		
		if(result==0) {
			System.out.println(-1);
		}else {
		System.out.println(result);
		}

	}
	
	public static void bfs(int p) {
		q.add(p);
		
		int depth=1;
		while(!q.isEmpty()) {
			
			int qsize=q.size(); 
			for(int d=0; d<qsize; d++) {
				
				int cur = q.remove();
				
				for(int i=1; i<=n; i++) {
					
					if(adj[cur][i]==1 && visited[i]==0) {
						q.add(i);
						visited[i]=depth;
					}
					
				}
				
			}
			depth+=1;
			
			
		}
		
	}

}
