package day0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SW_1258 {
	static int T;
	static int n;
	static int map[][];
	static int visited[][];
	static int dx[]= {1, 0, -1, 0};
	static int dy[]= {0, 1, 0, -1};
	static int size;
	static int endY;
	static int endX;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visited = new int[n][n];
			
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt=0;
			ArrayList<int[]> list = new ArrayList<>();
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j]!=0 && visited[i][j]==0) {
						size=0;
						endY=0;
						endX=0;
						dfs(i, j);
						size = (endY-i+1)*(endX-j+1);
						int tmp[] = {size, endY, endY-i+1, endX-j+1};
						list.add(tmp);
						cnt++;
					}
				}
			}
			
			//출력테스트(정렬전)
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i)[0]+" "+list.get(i)[1]+" "+list.get(i)[2]+" "+list.get(i)[3]);
			}
			
			Collections.sort(list, new Comparator<int[]>() {

				@Override
				public int compare(int o1[], int o2[]) {
					int result = 0;
					
					if(o1[0]<o2[0]) {
						result= -1;
					}else if(o1[0]==o2[0] && o1[2]<o2[2]){
						result= -1;
					}
					return result;
				}

			});
			
			System.out.println();
			System.out.println();
			//출력테스트(정렬후)
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i)[0]+" "+list.get(i)[1]+" "+list.get(i)[2]+" "+list.get(i)[3]);
			}
			
			
			System.out.print("#"+t+" "+cnt);
			for(int i=0; i<cnt; i++) {
				System.out.print(" "+list.get(i)[2]+" "+list.get(i)[3]);
				if(i==cnt-1) System.out.println();
			}
		}
	}
	
	public static void dfs(int y, int x) {
		if(y>endY || x>endX)  {
			endY=y; endX=x;
		}
		visited[y][x]=1;
		
		for(int i=0; i<4; i++) {
			int nextY = y+dy[i];
			int nextX = x+dx[i];
			
			if(nextY<0 || nextX<0 || nextY>=n || nextX>=n) continue;
			
			if(visited[nextY][nextX]==1) continue;
			
			if(map[nextY][nextX]!=0) {
				
				dfs(nextY, nextX);
			}
			
		}
		
	}
	
}
