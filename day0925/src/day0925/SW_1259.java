package day0925;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW_1259 {
	static int T;
	static int n;
	static int arr[][];
	static int visited[][];
	static LinkedList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][2];
			visited = new int[n][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				for(int j=0; j<2; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			/*for(int i=0; i<n; i++) {
				for(int j=0; j<2; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}*/
			
			list = new LinkedList<>();
			for(int i=0; i<n; i++) {
				if(visited[i][0]==0) {
					dfs(i);
					
					for(int k=0; k<n; k++) {
						for(int j=0; j<2; j++) {
							System.out.print(visited[k][j]);
						}
						System.out.println();
					}
					System.out.println();
					
				}
			}
			//dfs(0);
			/*for(int i=0; i<n; i++) {
				for(int j=0; j<2; j++) {
					System.out.print(visited[i][j]);
				}
				System.out.println();
			}*/
			System.out.println(list);
			System.out.println("#"+t+" ");
		}
		
	}
	
	public static void dfs(int row) {
		int a = arr[row][0]; //¼ý³ð
		int b = arr[row][1]; //¾Ï³ð
		System.out.println(a+" "+b);
		visited[row][0]=1;
		
		/*if(list.size()>0) {
			if(list.peekLast()==a) {
				list.add(a);
				list.add(b);
			}else if(list.peekFirst()==b) {
				list.addFirst(b);
				list.addFirst(a);
			}
		}else {*/
			list.add(a);
			list.add(b);
		//}
		
		for(int i=0; i<n; i++) {
			if(visited[i][0]==0 && b == arr[i][0]) {
				dfs(i);
			}
		}
		
	}

}
