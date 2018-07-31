package day0618;

import java.util.ArrayList;
import java.util.Stack;

public class DFSalgo {

	static ArrayList<int[]> adj;
	public static void main(String[] args) {
		
		adj = new ArrayList<>();
		
		int a0[] = {};
		int a1[] = {2, 3};
		int a2[] = {1, 4, 5};
		int a3[] = {1, 5};
		int a4[] = {2, 6};
		int a5[] = {2, 3, 6};
		int a6[] = {4, 5, 7};
		int a7[] = {6};
		
		adj.add(0, a0);
		adj.add(1, a1);
		adj.add(2, a2);
		adj.add(3, a3);
		adj.add(4, a4);
		adj.add(5, a5);
		adj.add(6, a6);
		adj.add(7, a7);
		
		dfs(1);
		
	}
	
	public static void dfs(int v) {
		//Stack, visited 초기화
		Stack<Integer> stack = new Stack<>();
		int visited[] = new int[9];
		
		//시작점 방문
		System.out.print(v+" ");
		visited[v]=1;
		stack.push(v);
		
		while(!stack.isEmpty()) {
			
			//v의 인접점 전부
			for(int j=0; j<adj.get(v).length; j++) {
				
				//v의 인접점
				int w = adj.get(v)[j];
				
				//2-1. 방문하지 않은 정점 w가 있으면
				if(visited[w]==0) {
					
					//w방문
					System.out.println(w+" ");
					visited[w]=1;
					stack.push(w);
		
					v=w;
					//이웃점 찾았으니까 j초기화 (인접점 모두를 탐색하기위해)
					j=0;
					
				}
				
			}
			
			//2-2. 방문하지 않은 정점이 없으면
			v = stack.pop();
			//System.out.println(stack);
			
		}

		
	}
	

}
