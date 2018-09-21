package day0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class SW_1953 {
	static int T;
	static int N; //지도 세로크기
	static int M; //지도 가로크기
	static int R; //맨홀 뚜껑 세로 위치
	static int C; //맨홀 뚜껑 가로 위치
	static int L; //탈출 후 소요 시간
	static int map[][];
	static int visited[][];

	static ArrayList<int[]> xt;
	static ArrayList<int[]> yt;
	
	static Queue<Integer> xq;
	static Queue<Integer> yq;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new int[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			xt = new ArrayList<>();
			yt = new ArrayList<>();
			tunnel();
			
			
			xq = new LinkedList<>();
			yq = new LinkedList<>();
			result=1;
			bfs(R, C);
			
			System.out.println("#"+t+" "+result);
		}
		
	}
	
	public static void tunnel() {
		int dx[] = null;
		int dy[] = null;
		
		for(int i=1; i<=7; i++) {
			if(i==1) { //우 하 좌 상
				dx = new int[]{1, 0, -1, 0};
				dy = new int[]{0, 1, 0, -1};
			}else if(i==2) { //하 상
				dx = new int[]{0, 0, 0, 0};
				dy = new int[]{0, 1, 0, -1};
			}else if(i==3) { //우 좌
				dx = new int[]{1, 0, -1, 0};
				dy = new int[]{0, 0, 0, 0};
			}else if(i==4) { //우 상
				dx = new int[]{1, 0, 0, 0};
				dy = new int[]{0, 0, 0, -1};
			}else if(i==5) { //우 하
				dx = new int[]{1, 0, 0, 0};
				dy = new int[]{0, 1, 0, 0};
			}else if(i==6) { //하 좌
				dx = new int[]{0, 0, -1, 0};
				dy = new int[]{0, 1, 0, 0};
			}else if(i==7) { //좌 상
				dx = new int[]{0, 0, -1, 0};
				dy = new int[]{0, 0, 0, -1};
			}
			
			xt.add(dx);
			yt.add(dy);
			
		}
		
	}
	
	public static boolean isPossible(int index, int next) {
		boolean flag = false;
		int r[] = new int[]{1, 3, 6, 7};
		int d[] = new int[]{1, 2, 4, 7};
		int l[] = new int[]{1, 3, 4, 5};
		int u[] = new int[]{1, 2, 5, 6};
		
		if(index==0) {
			flag = IntStream.of(r).anyMatch(x->x==next);
			
		}else if(index==1) {
			flag = IntStream.of(d).anyMatch(x->x==next);
			
		}else if(index==2) {
			flag = IntStream.of(l).anyMatch(x->x==next);
			
		}else if(index==3) {
			flag = IntStream.of(u).anyMatch(x->x==next);
		}
		return flag;
		
	}
	
	public static void bfs(int y, int x) {
		visited[y][x]=1;
		yq.add(y);
		xq.add(x);
		
			
		while(!yq.isEmpty()) {
			int curY = yq.remove();
			int curX = xq.remove();
			int curValue = map[curY][curX];
			
			int dy[] = yt.get(curValue-1);
			int dx[] = xt.get(curValue-1);
			
			// 우i=0, 하i=1, 좌i=2, 상i=3
			for(int i=0; i<dy.length; i++) {
				int nextY = curY + dy[i];
				int nextX = curX + dx[i];
				
				if(nextY<0 || nextX<0 || nextY>=N || nextX>=M) continue;
				
				if(map[nextY][nextX]==0) continue;
				
				
				int nextValue = map[nextY][nextX];
				boolean flag = isPossible(i, nextValue);

				//터널 매치 안되면 pass
				if(flag==false) continue;
				
				if(visited[nextY][nextX]==0) {
					xq.add(nextX);
					yq.add(nextY);
					visited[nextY][nextX] = visited[curY][curX]+1;
					if(visited[nextY][nextX]<=L) result++;
				}
			}
		}
	}
}
