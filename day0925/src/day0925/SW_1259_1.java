package day0925;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW_1259_1 {
	static int T;
	static int n;
	static int arr[][];
	static int visited[][];
	static boolean flag;
	static int t;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(t=1; t<=T; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][2];
			visited = new int[n][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				for(int j=0; j<2; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			LinkedList<Integer> list = new LinkedList<>();
			/*for(int i=0; i<n; i++) {
				if(visited[i][0]==0) {
					dfs(i, list);
				}
			}*/
			
			//case5
			list.add(arr[0][0]);
			list.add(arr[0][1]);
			
			/*int i=0;
			while(true) {
				if(list.size()==2*n) break;
				if(i>=n) i=0;
				
				if(visited[i][0]==0) {
					dfs(i, list);
					//System.out.println(list);
				}
				i++;
			}*/
			
			flag=false;
			dfs(0, list);
			/*for(int k=0; k<n; k++) {
				for(int q=0; q<2; q++) {
					System.out.print(visited[k][q]);
				}
				System.out.println();
			}*/
			
			//dfs(0, list);
			//System.out.print("#"+t+" ");
			/*for(int i=0; i<list.size(); i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();*/
		}
		
	}
	
	public static void dfs(int row, LinkedList<Integer> list) {
		if(flag==true) return;
		int a = list.peekFirst(); //리스트 숫
		int b = list.peekLast(); //리스트 암
		visited[row][0]=1;

		
		
		//System.out.println(a+" "+b);
		//System.out.println(list);
		if(list.size()==2*n) {
			flag = true;
			
			System.out.print("#"+t+" ");
			for(int i=0; i<list.size(); i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
			return;
		}
		
		
			for(int i=0; i<n; i++) {
				int na = arr[i][0]; //new 숫
				int nb = arr[i][1]; //new 암
				
				if(visited[i][0]==1) continue; 
					
				//리스트의 맨 앞 숫놈과 새로운 암놈 같으면
				if(a==nb) {
					list.addFirst(nb);
					list.addFirst(na);
					
					dfs(i, list);
					list.removeFirst();
					list.removeFirst();
					visited[i][0]=0;
					
				//리스트 맨 뒷 암놈과 새로운 숫놈 같으면
				}else if(b==na) {
					list.addLast(na);
					list.addLast(nb);
				
					dfs(i, list);
					list.removeLast();
					list.removeLast();
					visited[i][0]=0;
					
				}/*else {
					continue;
				}*/
					
				
				/*dfs(i, list);
				//visited[i][0]=0;
*/			
			
			
		}
		
		
	}

}
