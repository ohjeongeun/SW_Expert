package day1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_9466 {
	static int n;
	static int arr[];
	static int visited[];
	static LinkedList<Integer> list;
	static ArrayList<Integer> result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			visited = new int[n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			list = new LinkedList<>();
			result = new ArrayList<>();
			
			for(int i=1; i<=n; i++) {
				list.add(i);
				dfs(i);
				Arrays.fill(visited, 0);
				list = new LinkedList<>();
			}
			
			System.out.println(n-result.size());
			
			
		}
	}
	
	public static void dfs(int v) {
		//System.out.println(v);
		if(list.size()!=1 && list.getFirst()==list.getLast()) {
			//System.out.println(list);
			for(int i=0; i<list.size(); i++) {
				if(!result.contains(list.get(i))) {
					result.add(list.get(i));
				}
			}
			
		}
		
		if(visited[arr[v]]==0) {
			visited[arr[v]]=1;
			list.add(arr[v]);
			dfs(arr[v]);
		}
		
	}
	
	
	
}
