package day0618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//디저트 카페
// Queue 사용 dfs로 해보려 했지만 실패..
// 이웃점 다 넣고 시도해보기 때문에 안됨
// 한번에 여러 방향으로 뻗어 나가기 때문에 안됨,,
public class SW_2105 {
					//우하    좌하   좌상   우상
	static int dx[] = { 1, -1, -1, 1};
	static int dy[] = { 1, 1, -1, -1};
	
	static int N;
	static int map[][];
	static int visited[][];
	
	static Queue<int[]> q;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String T = br.readLine();
		for(int t=1; t<=10; t++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			
			cnt=1;
			solve(0, 1);
			
			System.out.println("#"+t+" ");
		}
	}
	
	public static void solve(int y, int x) {
		//Queue 생성
		q = new LinkedList<>();
		visited = new int[N][N];
		
		int cury=y;
		int curx=x;
		//시작점 q에 넣음 && 방문 표시
		int temp[] = {cury, curx};
		q.add(temp);
		visited[cury][curx] = 1;
		

		while(!q.isEmpty()) {
			//t에 Queue의 첫번째 원소 반환
			int t[] = q.poll();
			cury = t[0];
			curx = t[1];
			
			//t의 이웃점 탐색
			for(int i=0; i<4; i++) {
				int ny = cury+dy[i];
				int nx = curx+dx[i];
				
				if(cnt==4 && ny==y && nx==x) {
					System.out.println("성공");
					return;
				}
				
				
				//경계선이면 next
				if(ny>N-1 || nx>N-1 || ny<0 || nx<0) {
					cnt++;
					continue;
				}
				
				//중복가게면 next
/*				int z = map[ny][nx];
				if(q.contains(z)) {
					cnt++;
					continue;
				}*/
				
				//방문 않았으면
				if(visited[ny][nx]==0) {
					int tmp[] = {ny, nx};
					q.add(tmp);
					visited[ny][nx]=1;
					
					for(int p=0; p<N; p++) {
						for(int q=0; q<N; q++) {
							System.out.print(visited[p][q]+" ");
						}
						System.out.println();
					}
					System.out.println();
				}
				
				
			}
			
		}
		
	}

}
