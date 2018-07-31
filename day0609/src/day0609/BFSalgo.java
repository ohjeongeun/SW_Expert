package day0609;

import java.util.LinkedList;
import java.util.Queue;

public class BFSalgo {
		
	static LinkedList<int[]> adj;
	static int visited[];
	static Queue<Integer> q;
	
	public static void main(String[] args) {
		adj = new LinkedList<>();
		
		int tmp0[] = {0, 1, 2, 3};
		int tmp1[] = {1, 4, 5};
		int tmp2[] = {2};
		int tmp3[] = {3, 6, 7, 8};
		
		adj.add(tmp0);
		adj.add(tmp1);
		adj.add(tmp2);
		adj.add(tmp3);
		for(int i=4; i<9; i++) {
			int tmp[] = {i};
			adj.add(tmp);
		}

		bfs();
	}
	
	public static void bfs() {
		q = new LinkedList<Integer>();
		visited = new int[9];
		
		q.add(0);
		visited[0]=1;
		
		while(!q.isEmpty()) {
			
			//System.out.println(q);
			int t = q.poll();
			//System.out.println(q);
			
			//tÀÇ ÀÌ¿ôÁ¡ Å½»ö
			for(int j=1; j<adj.get(t).length; j++) {
				
				
				int u = adj.get(t)[j];
				
				if(visited[u]==0) {
					q.add(u);
					visited[u]=1;
					
				}
			}

		}
	
	}
}
