package day0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_6603 {
	static int k;
	static int arr[];
	static int visited[];
	static LinkedList<Integer> list;
	static ArrayList<String> arrlist;
	static String str;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
		
			str = br.readLine();
			if(str.equals("0")) {
				return;
			}
			
			StringTokenizer st = new StringTokenizer(str);
			k = Integer.parseInt(st.nextToken());
			arr = new int[k];
			//visited = new int[k];
			for(int i=0; i<k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
	
			}
	
			arrlist = new ArrayList<>();
			
			/*for(int i=0; i<arr.length; i++) {
				list = new LinkedList<>();
				visited = new int[k];
				list.add(arr[i]);
				dfs(i);
			}*/
			
			list = new LinkedList<>();
			visited = new int[k];
			list.add(arr[0]);
			dfs(0);
			
			for(int i=0; i<arrlist.size(); i++) {
				System.out.println(arrlist.get(i));
			}
			System.out.println();
		
		}
	}
	
	public static void dfs(int index) {
		if(list.size()==6) {
			Collections.sort(list);
			
			String s = list.toString().replaceAll(",", "").replace("[", "").replace("]", "");
			if(!arrlist.contains(s)) {
				arrlist.add(s);
			}
			return;
		}
		
		visited[index]=1;
		
		
		for(int i=index; i<arr.length; i++) {
			
			if(visited[i]==1) continue;
			
			if(list.contains(arr[i])) continue;
			
			list.addLast(arr[i]);
			dfs(i);
			visited[i]=0;
			list.removeLast();
			
		}
		
	}
}
