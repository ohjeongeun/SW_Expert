package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1219 {
	static int T;
	static int N;
	static int tree[][];
	static int visited[];
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int t=0; t<10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				T = Integer.parseInt(st.nextToken());
				N = Integer.parseInt(st.nextToken());
			}
			
			tree = new int[100][2];
			visited = new int[100];
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				if(tree[p][0]==0) {
					tree[p][0] = c;
				}else {
					tree[p][1] = c;
				}
			}
			result=0;
			dfs(0);
			System.out.println("#"+T+" "+result);
			
		}
		
	}
	
	//부모정보를 가지고 자식을 찾고, 또 자식이 부모가되어 자식을 탐색하는 재귀함수
	public static void dfs(int p) {
		
		for(int j=0; j<2; j++) {
			int child = tree[p][j];
			
			//자식이 99면 종료
			if(child==99) {
				result=1;
				return;
			}
			
			//자식이 0이아니면, 방문하고, 부모가되어 재귀 탐색
			if(child!=0) {
				visited[child]=1;
				dfs(child);
			}
		}
		
	}
	
	

}
