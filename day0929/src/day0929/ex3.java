package day0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ex3 {
	static int map[][];
	static int visited[][];
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//1001로 바꾸기
		map = new int[1001][1001];
		visited = new int[1001][1001];
		
		LinkedList<Integer> start = new LinkedList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			int s = Integer.parseInt(st.nextToken());
			start.add(s);
			list.add(s);
			while(st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			//System.out.println(list);
			for(int j=0; j<list.size()-1; j++) {
				map[list.get(j)][list.get(j+1)]=1;
			}
			
		}
		
		
		for(int i=0; i<21; i++) {
			for(int j=0; j<21; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=0; i<N; i++) {
			max=0;
			dfs(start.remove());
			if(!result.contains(max)) {
				result.add(max);
			}
			
		}
		
		Collections.sort(result);
		//System.out.println(result);
		for(int i=0; i<result.size(); i++) {
			System.out.print(result.get(i)+" ");
		}
		
	}
	
	public static void dfs(int v) {
		if(max<v) {
			max=v;
		}
		
		for(int j=0; j<21; j++) {
			if(map[v][j]==1 && visited[v][j]==0) {
				visited[v][j]=1;
				dfs(j);
				visited[v][j]=0;
			}
			
		}
		
	}
	

}
