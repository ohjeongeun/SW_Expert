package day0609;

import java.util.LinkedList;
import java.util.Queue;

public class BFSalgo {
		
	static LinkedList<int[]> adj;
	static int visited[];
	static Queue<Integer> q;
	
	static int D[];
	static int P[];
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

		D = new int[9]; //최단거리
		P = new int[9]; //최단경로
		bfs();
		for(int i=0; i<9; i++) {
			System.out.print(D[i]);
		}
		System.out.println();
		for(int i=0; i<9; i++) {
			System.out.print(P[i]);
		}
	}
	
	public static void bfs() {
		
		q = new LinkedList<Integer>();
		visited = new int[9];
		
		q.add(0);
		visited[0]=1;
		D[0] = 0;
		P[0] = 0;
		
		
		while(!q.isEmpty()) {
			
			int t = q.poll();
			System.out.println(t);
			
			//t의 이웃점 탐색
			for(int j=1; j<adj.get(t).length; j++) {
				
				
				int u = adj.get(t)[j];
				
				if(visited[u]==0) {
					q.add(u);
					visited[u]=1;
					D[u] = D[t]+1;
					P[u] = t;//정점 u의 부모 정점을 t로 설정
				}
			}

		}
	
	}
}
