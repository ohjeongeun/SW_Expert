package day0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11403 {
	static int N;
	static int adj[][];
	static int visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		adj = new int[N][N];
		visited = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j=0; 
			while(st.hasMoreTokens()) {
				adj[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}
		
		dfs(0);
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}
	}
	
	//���ľߴ�
	public static void dfs(int i) {
		for(int j=0; j<N; j++) {
			//�������� 1�̰� �湮���� ������
			if(adj[i][j]==1 && visited[i][j]==0) {
				//�湮 ��Ű��
				visited[i][j]=1;
				dfs(j);
			}
		}
		
		
	}
	
}
