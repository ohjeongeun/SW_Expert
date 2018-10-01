package day1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1263 {
	static int T;
	static int N;
	static int adj[][];
	static Queue<Integer> q;
	static PriorityQueue<Integer> min;
	static int visited[];
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			adj = new int[N+1][N+1];
			visited = new int[N+1];
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					adj[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			q = new LinkedList<>();
			min = new PriorityQueue<>();
			for(int i=1; i<=N; i++) {
				Arrays.fill(visited, 0);
				sum=0;
				bfs(i);
				sum-=visited[i];
				min.add(sum);
			}
			
			/*for(int i=1; i<=N; i++) {
				System.out.print(visited[i]);
			}*/
			/*for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					System.out.print(adj[i][j]);
				}
				System.out.println();
			}*/
			System.out.println("#"+t+" "+min.poll());
			
			
		}
	}
	
	
	public static void bfs(int v) {
		q.add(v);
		//visited[v]=-1;
		
		while(!q.isEmpty()) {
			int cur = q.remove();
			
			for(int j=1; j<=N; j++) {
				//nextÃ£±â
				if(adj[cur][j]==1 && visited[j]==0) {
					visited[j] = visited[cur]+1;
					q.add(j);
					sum+=visited[j];
				}
			}
			
		}
		
		
	}
	
	

}
