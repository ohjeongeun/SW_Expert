package day1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

import javax.print.attribute.standard.Finishings;

public class BOJ_9466_1 {
	static int n;
	static int arr[];
	static int c[];
	static int visited[];
	static int finished[];
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			c = new int[n+1];
			visited = new int[n+1];
			finished = new int[n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			cnt=0;
			for(int i=1; i<=n; i++) {
				if(visited[i]==0) {
					dfs(i);
				}
				/*for (int j = 1; j <= n; j++) {
					System.out.print(finished[j] + " ");
				}
				System.out.println();*/
			}
			
			System.out.println(n-cnt);
			
		}
	}
	
	public static void dfs(int cur) {
		visited[cur]=1;
		
		int next = arr[cur];
		
		//방문한적 없으면
		if(visited[next]==0) {
			c[next]=cur; //현재값 저장. cycle cnt할때 쓰기 위해
			dfs(next);
		
		//방문했었으면
		}else {
			//방문했었고 끝난지점 아니면
			if(finished[next]==0) {
				cycle(cur, next);
				
			}
			
		}
		finished[cur]=1;
		
	}
	
	public static void cycle(int cur, int next) {
		cnt++;
		if(cur==next) {
			return;
		}
		cycle(c[cur], next);
		
	}
	
	
}
