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
			
			LinkedList<Integer> list = new LinkedList<>();
			/*for(int i=0; i<n; i++) {
				if(visited[i][0]==0) {
					dfs(i, list);
				}
			}*/
			
			//case5
			list.add(arr[0][0]);
			list.add(arr[0][1]);
			
			int i=0;
			while(true) {
				if(list.size()==2*n) break;
				if(i>=n) i=0;
				if(visited[i][0]==0) {
					dfs(i, list);
					//System.out.println(list);
				}
				i++;
			}
			
			//dfs(0, list);
			System.out.println("#"+t+" "+list);
		}
		
	}
	
	public static void dfs(int row, LinkedList<Integer> list) {
		
		int a = list.peekFirst(); //����Ʈ ��
		int b = list.peekLast(); //����Ʈ ��
		visited[row][0]=1;
		System.out.println(a+" "+b);
		System.out.println(list);
		
			for(int i=0; i<n; i++) {
				int na = arr[i][0]; //new ��
				int nb = arr[i][1]; //new ��
				
				if(visited[i][0]==1) continue; 
					
				//����Ʈ�� �� �� ����� ���ο� �ϳ� ������
				if(a==nb) {
					list.addFirst(nb);
					list.addFirst(na);
					
				//����Ʈ �� �� �ϳ�� ���ο� ���� ������
				}else if(b==na) {
					list.addLast(na);
					list.addLast(nb);
				
				}else {
					continue;
				}
					
				
				dfs(i, list);
				visited[i][0]=0;
			
			
			
		}
		
		
	}

}
