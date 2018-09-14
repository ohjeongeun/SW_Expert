package day0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11403 {
	static int N;
	static int adj[][];
	static int ans[][];
	static int visited[][];
	static ArrayList<Integer> row;
	static ArrayList<Integer> graph[];
	
	static ArrayList<Integer> childs;
	static ArrayList<Integer> newGraph[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		adj = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j=0;
			while(st.hasMoreTokens()) {
				adj[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}
		visited = new int[N][N];
		ans = new int[N][N];
		/*for(int i=0; i<N; i++) {
			for(int j=0; j<N;j++) {
				System.out.print(adj[i][j]);
			}
			System.out.println();
		}*/
		
		
		graph = new ArrayList[N]; //행
		for(int i=0; i<N; i++) {
			row = new ArrayList<>(); //열
			graph[i] = row;
			for(int j=0; j<N;j++) {
				if(adj[i][j]!=0) {
					row.add(j);	
				}
			}
		}
		
		newGraph = new ArrayList[N]; //행
		for(int i=0; i<N; i++) {
			childs = new ArrayList<>(); //열
			newGraph[i] = childs;
			visited = new int[N][N];
			recursive(i);
		}
		
		for(int i=0; i<N; i++) {
			System.out.println(newGraph[i]); //출력
			for(int j=1; j<newGraph[i].size(); j++) {
				ans[i][newGraph[i].get(j)]=1;
			}
		
		}
		
		//출력
		for(int i=0; i<N; i++) {
			for(int j=0; j<N;j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
	
								// 출발점
	public static void recursive(int i) {
		
		//System.out.println(i);
		childs.add(i);
		
		for(int p=i; p<N; p++) {
			
			for(int q=0; q<graph[p].size();q++) {
				int j = graph[p].get(q);
				
				
				if(visited[p][j]==0) {
					visited[p][j]=1;
					recursive(j);
					
				}
				
				
			}
		}
		
	}

}
