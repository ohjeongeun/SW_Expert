import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SW_1219 {

	static int T;
	static int len;
	static int a[][];
	static int visited[];
	static int result;
	static Stack<Integer> route;
	static int top;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				T = Integer.parseInt(st.nextToken());
				len = Integer.parseInt(st.nextToken());
			}
			
			//인접행렬
			a = new int[100][100];
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				a[i][j] = 1;
				//a[j][i] = 1;
				
			}
			
			visited = new int[100];
			route = new Stack<Integer>();
			result=0;
			dfs(0);
			
			
			System.out.println("#"+T+" "+result);
			System.out.println(route);
			for(int i=0; i<100; i++) {
				System.out.print(visited[i]+" ");
			}
		}

	}
	
	public static void dfs(int v) {
		
		visited[v] = 1; //방문표시
		route.push(v); //루트 스택에 넣음
		System.out.println(route);
		
		if(route.peek()==99) {
			result=1;
			return;
		}
		
		for(int j=0; j<100; j++) {
			if(visited[j]==0 && a[v][j]==1) {
				dfs(j);
			}
		}

		route.pop();

	}
}
