package day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1697_BACK {
	static int N;// 수빈
	static int K;// 동생
	static int dx[];
	static int visited[];
	static Stack<Integer> stack;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
		}
		
		stack = new Stack<>();
		visited = new int[200001];
		// dx = int[]{};
		cnt=0;
		backtracking(N, K);
	}

	public static void backtracking(int x, int k) {
		
		//초기점
		stack.push(x);
		visited[x] = 1;

		//다음점
		
		dx = new int[] {x-1, x+1, 2*x};
		for(int i=0; i<3; i++) {
			int nx = dx[i];
			System.out.println(nx);
			//범위 아니면 continue
			if(nx<0 || nx>100001) {
				System.out.println(111);
				x = stack.pop();
			}
			
			//방문한적 없으면
			if(visited[nx]==0) {
				visited[nx]=1;
				stack.push(nx);
				x = nx;
			}
				
					
		
			
			
		}
		

	}

}
