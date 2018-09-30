package day0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex3_1 {
	static int map[][];
	static int visited[];
	static int max;
	static Queue<Integer> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//1001로 바꾸기
		map = new int[1001][1001];
		visited = new int[1001];
		
		int maxValue=0;
		LinkedList<Integer> start = new LinkedList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			int s = Integer.parseInt(st.nextToken());
			
			start.add(s);
			list.add(s);
			while(st.hasMoreTokens()) {
				int t = Integer.parseInt(st.nextToken());
				list.add(t);
				if(maxValue<t) {
					maxValue=t;
				}
			}
			
			for(int j=0; j<list.size()-1; j++) {
				map[list.get(j)][list.get(j+1)]=1;
			}
			
		}
		
		System.out.println("*"+maxValue);
		//출력
		for(int i=0; i<21; i++) {
			for(int j=0; j<21; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		q = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();
		
		while(!start.isEmpty()) {
			max=0;
			bfs(start.remove());
			if(!result.contains(max)) {
				result.add(max);
			}
		}
		max=0;
		bfs(13);
		
		/*for(int i=0; i<N; i++) {
			max=0;
			dfs(start.remove());
			if(!result.contains(max)) {
				result.add(max);
			}
			
		}*/
		
		Collections.sort(result);
		//System.out.println(result);
		for(int i=0; i<result.size(); i++) {
			System.out.print(result.get(i)+" ");
		}
		
		
		
	}
	
	public static void bfs(int v) {
		q.add(v);
		visited[v]=1;
		
		while(!q.isEmpty()) {
			int cur =  q.remove();
			if(max<cur) {
				max=cur;
			}
			
			int cnt=0;
			for(int j=0; j<1001; j++) {
				if(map[cur][j]==1 && visited[j]==0) {
					cnt++;
					if(cnt>1) {
						System.out.println(-1);
						return;
					}
					q.add(j);
					visited[j]=1;
				}
				
			}
			
			
			
			
		}
		
		
		
	}
	

}
